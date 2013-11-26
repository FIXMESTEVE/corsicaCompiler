public enum EnumTag { 
    
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
	DIFF ("!="), 
	PLUS ("+"), 
	MINUS ("-"), 
	MINUS_U ("-"), 
	MULT ("*"), 
	DIV ("/");
    
    private final String tag;

    EnumTag(String s){
		tag = s;
    }
    
    public String toString(){
		return tag;
    }
    
}
