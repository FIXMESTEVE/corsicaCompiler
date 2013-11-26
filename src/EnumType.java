package org.dm1;
public enum EnumType {
	// types simples
	CHARACTER, INTEGER, FLOAT, STRING, BOOLEAN, 
	// variable de type (on peut dire par exemple "pointeur('x) -> 'x")
	VARIABLE,
	// type constant pour les slots
	CONSTANT,
	// types complexes
	POINTER, FUNCTION, TIMES, 
	// types complexes
	RECORD, LIST, ARRAY, STACK, SET, 
	// erreur de type
	ERROR
}
