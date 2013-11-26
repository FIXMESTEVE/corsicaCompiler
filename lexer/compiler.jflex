import java_cup.runtime.Symbol;

%%
%class CompilerLexer
%line
%column
%cupsym CompilerSymbol
%cup

NumberReal = "-"?[[:digit:]]+(\.[[:digit:]]+)?([Ee][+-]?[[:digit:]]+)?
NumberComplexe = {NumberReal}"+"{NumberReal}"i"
NumberInteger = "-"?[[:digit:]]+
Comment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"

%%

/* -------------------------------------------------
        Operateurs
   ------------------------------------------------- */

/*
				 ";"   { return new Symbol(CalculetteSymbol.SEMIC, yyline, yycolumn); }
						","     {return new Symbol(CompilerSymbol.COMA, yyline, yycolumn);}
":=" { }
"[" {}
"]" {}
"int" {} //TYPE_INTEGER
"real" {} //TYPE_REAL


"+"     { return new Symbol(CompilerSymbol.PLUS, yyline, yycolumn); }
"-"     { return new Symbol(CompilerSymbol.MINUS, yyline, yycolumn); }
"*"     { return new Symbol(CompilerSymbol.MULT, yyline, yycolumn); }
"/"     { return new Symbol(CompilerSymbol.DIV, yyline, yycolumn); }
"("     { return new Symbol(CompilerSymbol.LPAR, yyline, yycolumn); }
")"     { return new Symbol(CompilerSymbol.RPAR, yyline, yycolumn); }
*/


/*"true"     { return new Symbol(CompilerSymbol.BOOLEAN, yyline, yytext()); }
"false"      { return new Symbol(CompilerSymbol.BOOLEAN, yyline, yytext()); }
"%"     { return new Symbol(CompilerSymbol.MOD, yyline, yycolumn); }
"=="    { return new Symbol(CompilerSymbol.EQ, yyline, yycolumn); }
"!="    { return new Symbol(CompilerSymbol.DIFF, yyline, yycolumn); }
"<"     { return new Symbol(CompilerSymbol.LT, yyline, yycolumn); }
"<="    { return new Symbol(CompilerSymbol.LE, yyline, yycolumn); }
">"     { return new Symbol(CompilerSymbol.GT, yyline, yycolumn); }
">="    { return new Symbol(CompilerSymbol.GE, yyline, yycolumn); }
"&&"    { return new Symbol(CompilerSymbol.AND, yyline, yycolumn); }
"||"    { return new Symbol(CompilerSymbol.OR, yyline, yycolumn); }
"!"     { return new Symbol(CompilerSymbol.NOT, yyline, yycolumn); }
"->"    { return new Symbol(CompilerSymbol.IMPL, yyline, yycolumn); }	
"<->"   { return new Symbol(CompilerSymbol.EQUIV, yyline, yycolumn); }
"?"     { return new Symbol(CompilerSymbol.QUEST, yyline, yycolumn); }
":"     { return new Symbol(CompilerSymbol.COLON, yyline, yycolumn); }


/* -------------------------------------------------
        Nombres
   ------------------------------------------------- */

/*
{NumberInteger}     { return new Symbol(CompilerSymbol.INTEGER, yyline, yycolumn, new Integer(yytext())); }

{NumberReal}     	{ return new Symbol(CompilerSymbol.REAL, yyline, yycolumn, new Float(yytext())); }

{NumberComplexe}    { 
                        return new Symbol(CompilerSymbol.COMPLEX, yyline, yycolumn, new Complex(yytext())); 
  					}
*/


/* -------------------------------------------------
        Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */
{Comment} {}

/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}