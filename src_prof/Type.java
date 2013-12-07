package org.dm1;
import java.io.*;
import java.lang.*;
import java.util.*;

import org.dm1.*;

// Les types
// cf EnumType pour conna”tre les types autorisŽs
// type simple:
//    int, real, boolean, etc
// types composŽs:
//    left -> right
//    left X right
//    pointeur(left)
public class Type {

	private int id; // identifiant unique
	private Type left; // partie gauche d'un type complexe
	private Type right; // partie droite d'un type complexe
	private EnumType type;  // le type (cf EnumType)	

	public Type(Type left, Type right, EnumType type) {
		this.left=left;
		this.right=right;
		this.id=Main.id++;
		this.type=type;
	}

	public Type(Type left, EnumType type) {
		this.left=left;
		this.right=null;
		this.id=Main.id++;
		this.type=type;
	}

	public Type(EnumType type) {
		this.left=null;
		this.right=null;
		this.id=Main.id++;
		this.type=type;
	}

	public Type getLeft() {
		return left;
	}

	public void setLeft(Type left) {
		this.left = left;
	}

	public Type getRight() {
		return right;
	}

	public void setRight(Type right) {
		this.right = right;
	}

	public void putType(EnumType type){
		this.type=type;
	}

	// Pour affichage
	public String toString() {
		String result = new String();
		switch (type) {
		case ERROR: result += "ERROR"; break;
		case INTEGER: result += "INTEGER"; break;
		case FLOAT: result += "FLOAT"; break;
		case STRING: result += "STRING"; break;
		case BOOLEAN: result += "BOOLEAN"; break;
		case POINTER: result += "POINTER("+left.toString()+")"; break;
		case LIST: result += "LIST("+left.toString()+")"; break;
		case FUNCTION: result += "("+left.toString()+" -> "+right.toString()+")"; break;
		case TIMES: result += "("+left.toString()+" X "+right.toString()+")"; break;
		case VARIABLE: result += "VARIABLE:"+id; break;
		case RECORD: result += "RECORD("+left.toString()+")"; break;
		case ARRAY: result += "ARRAY"; break;
		case CHARACTER: result += "CHARACTER"; break;
		case CONSTANT: result += "CONSTANT:"+id; break;
		case SET: result += "SET"; break;
		case STACK: result += "STACK"; break;  
		}
		return result;
	}

	// Algorithme de Robinson
	// Cette fonction provoqe un effet sur ses arguments
	public boolean unify(Type with){
		//System.err.println("############################### UNIFICATION DE "+toString()+", ET DE "+with.toString());
		Diff theta=diff(with);
		if (theta==null)
			return true;
		if (theta.getVar().type!=EnumType.VARIABLE)
			return false;
		//System.err.println("############################### THETA: " + theta.toString());
		int k=0;
		while (theta!=null && k++<10){
			this.substitue(theta);
			with.substitue(theta);
			//System.err.println("############################### RES: "+this.toString()+", "+with.toString());
			boolean test=eq(with);
			theta=diff(with);
			if (theta!=null){
				if (theta.getVar().type!=EnumType.VARIABLE)
					return false;
				//System.err.println("############################### THETA: " + theta.toString());
			}
		}
		return true;
	}

	// Remplace une variable par une constante
	public void substitue(Diff diff){
		switch (type) {
		case INTEGER:
		case FLOAT:
		case STRING:
		case BOOLEAN:
		case ERROR:
			break;
		case POINTER:
			left.substitue(diff);
			break;
		case FUNCTION: 
		case TIMES:
			left.substitue(diff);
			right.substitue(diff);
			break;
		case VARIABLE:
			if ((diff.getVar().id==this.id)){
				this.left=diff.getCons().left;
				this.right=diff.getCons().right;
				this.type=diff.getCons().type;
				if (diff.getCons().type==EnumType.VARIABLE)
					this.id=diff.getCons().id;
			}
			break;
		}
	}

	// Teste si deux types sont Žquivalents
	public boolean eq(Type with){
		//System.err.println("############################### EQ ENTRE "+toString()+" ET "+with.toString());
		if ((with.type!=type)
				&& (with.type!=EnumType.VARIABLE)
				&& (type!=EnumType.VARIABLE))
			return false;
		if ((with.type!=type)
				&& ((with.type==EnumType.VARIABLE)
						|| (type==EnumType.VARIABLE)))
			return true;

		switch (type) {
		case INTEGER:
		case FLOAT:
		case STRING:
		case BOOLEAN:
		case VARIABLE: 
		case ERROR: 
			break;
		case POINTER:
		case LIST:
			return left.eq(with.left);
		case FUNCTION:
		case TIMES:
			return (left.eq(with.left)
					&& 
					right.eq(with.right));
		}
		return true;
	}

	// Calcule la premire diffŽrences entre deux types
	// c'est-ˆ-dire la prŽsence d'une variable dans un 
	// terme pour une constante (ou une autre variable)
	// dans l'autre
	public Diff diff(Type with){
		//System.err.println("############################### DIFF ENTRE "+toString()+" ET "+with.toString());
		switch (type) {
		case ERROR:
			return null;
		case INTEGER:
		case FLOAT:
		case STRING:
		case BOOLEAN:
			if (with.type==type){
				return null;
			} else if (with.type!=EnumType.VARIABLE)
				return new Diff(this, with);
			break;
		case POINTER:
		case LIST:
			if (with.type==type)
				return left.diff(with.left);
		case FUNCTION:
		case TIMES:
			if (with.type == type){
				Diff l=left.diff(with.left);
				if (l!=null)
					return l;
				Diff r=right.diff(with.right);
				if (r!=null)
					return r;
			}
			break;
		case VARIABLE: 
			if ((with.type!=EnumType.VARIABLE) ||
					(with.id!=id))
				return new Diff(this, with);
			break;
		default: 
			System.err.printf("*** bug %s\n", type.toString());
		}
		if (with.type==EnumType.VARIABLE)
			if ((type!=EnumType.VARIABLE) ||
					(id!=with.id))
				return new Diff(with, this);
		return null;
	}
}
