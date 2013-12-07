package org.dm1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Process;
import java.util.Vector;

import org.dm1.*;

// Arbre Binaire de recherche
// symbol est le mot, type est son type
// left contient les mots placés avant dans l'ordre alphabétique
// right contient les mots placés aprËs dans l'ordre alphabétique
// type sert à ranger le type 
// flag sert à éviter de parcourir deux fois

public class BinaryTree {

	private int id;
	private BinaryTree left;
	private BinaryTree right;
	private String symbol;	
	private Type type;
	private boolean flag;

	// Les contructeurs...
	public BinaryTree(BinaryTree left, BinaryTree right, String s, Type t) {
		this.left=left;
		this.right=right;
		this.id=Main.id++;
		this.symbol=s;
		this.type=t;
		this.flag=false;
	}

	public BinaryTree(String s, Type t) {
		this.left=null;
		this.right=null;
		this.id=Main.id++;
		this.symbol=s;
		this.type=t;
		this.flag=false;
	}

	// Les accesseurs
	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public int getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	// Pour retrouver le type d'un symbole
	public Type find(String s) {
		if ((s.compareTo(symbol) < 0) && left!=null)
			return left.find(s);
		else if ((s.compareTo(symbol) > 0) && right!=null)
			return right.find(s);
		else if (s.compareTo(symbol) == 0)
			return type; 
		else
			return null;
	}

	// pour ajouter un couple <symbole, type>
	public BinaryTree add(String s, Type t, BinaryTree a) {
		if (a==null)
			return new BinaryTree(s, t);
		else if (s.compareTo(a.symbol) < 0)
			return new BinaryTree(add(s, t, a.left), a.right, a.symbol, a.type);
		else if (s.compareTo(a.symbol) > 0)
			return new BinaryTree(a.left, add(s, t, a.right), a.symbol, a.type);
		else
			return new BinaryTree(a.left, a.right, s, t);
	}

	// produit une chaÓne pour lecture
	public String toString() {
		String result = new String();
		result += symbol;
		if ((left != null) || (right != null)){
			result +="(";
			if (left != null)
				result += left.toString();
			result+=",";
			if (right != null)
				result += right.toString();
			result+=")";
		}
		return result;
	}

	// 
	protected void toDot(StringBuffer str) {
		if (!flag){
			flag=true;
			str.append(this.id+" [label=\""+symbol+": "+type.toString()+"\"];"+"\n");

			if (left != null){
				left.toDot(str);
				str.append(this.id+" -> "+left.id+" [label=\"\"];\n");
			}
			if (right != null){
				right.toDot(str);
				str.append(this.id+" -> "+right.id+" [label=\"\"];\n");
			}
		}
	}

	// produit un fichier dot (graphviz)
	public void toDot(String file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("./"+file+".dot"));
			out.write("digraph ArbreBinaire {");
			StringBuffer str = new StringBuffer();
			toDot(str);
			out.write(str.toString());
			out.write("}");
			out.close();
		} catch (IOException e) {
			System.out.println("ERROR: build dot");
		}		
	}
}
