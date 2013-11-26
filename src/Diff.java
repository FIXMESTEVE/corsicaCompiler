package org.dm1;
import java.io.*;
import java.lang.*;
import java.util.*;

import org.dm1.*;

// Sert à marquer une différence entre deux types pour l'unification
public class Diff {
	private Type var;	
	private Type cons;

	public Type getVar(){
		return this.var;
	}

	public Type getCons(){
		return this.cons;
	}

	public Diff(Type var, Type cons) {
		this.var=var;
		this.cons=cons;
	}

	public Diff() {
		this.var=null;
		this.cons=null;
	}

	public String toString() {
		String result = new String();
		if ((var!=null) && (cons!=null))
			result += "<"+var.toString()+","+cons.toString()+">";
		return result;
	}
}
