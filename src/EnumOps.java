public enum EnumOps{ 
    
    /*THESE ARE NOT OPERATORS

    QUEST ("?"),
    COLON (":"),
    INTEGER ("int"),
    REAL ("real"),
    BOOLEAN ("boolean"),
    COMPLEX ("complex"),
    NOT ("!"),
    LPAR ("("),
    RPAR (")"),
    SEMIC (";"),
    IMPL ("->"),
    EQUIV ("<->"),
    MOD ("%"),
    AND ("&&"), 
	OR ("||"), 
	LT ("<"), 
	GT (">"), 
	LE ("<="), 
	GE (">="), 
	EQ ("=="), 
	DIFF ("!="),*/ 
	PLUS ("+"), 
	MINUS ("-"), 
	NOT ("!"),
    MULT ("*"), 
	DIV ("/");


    private final String op;

    EnumOps(String s){
		op = s;
    }
    
    public String toString(){
		return op;
    }
    
}
