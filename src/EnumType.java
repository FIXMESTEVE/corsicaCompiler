public enum EnumType {
	// types simples
	CHAR, INTEGER, FLOAT, UNSIGNED_FLOAT, STRING, BOOLEAN, UNSIGNED_INT, SHORT, UNSIGNED_SHORT,
	// variable de type (on peut dire par exemple "pointeur('x) -> 'x")
	VARIABLE,
	// type constant pour les slots
	CONSTANT,
	// types complexes
	POINTER, FUNCTION, TIMES, 
	// types complexes
	RECORD, LIST, ARRAY, STACK, SET, 
	// erreur de type
	ERROR,

	PTR_INTEGER, PTR_UNSIGNED_INT, PTR_FLOAT, PTR_UNSIGNED_FLOAT,
	PTR_CHAR, PTR_STRING, PTR_SHORT, PTR_UNSIGNED_SHORT;


}
