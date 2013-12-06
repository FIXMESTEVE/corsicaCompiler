import java_cup.runtime.Symbol;

%%
%class CompilerLexer
%line
%column
%cupsym CompilerSymbol
%cup

/* -------------------------------------------------
        Commentaires
   ------------------------------------------------- */
Comment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"

//NumberReal = "-"?[[:digit:]]+(\.[[:digit:]]+)?([Ee][+-]?[[:digit:]]+)?
NumberInteger = [[:digit:]]+
				     
VAR = [a-zA-Z]+[1-9]*
INT = ": entier" //todo: space*
//UINT = ": entierns"
//FLOAT = ": reel"
//BOOL = ": booleen"				     			     
				     
%%

//stuff
{VAR} {return new Symbol(CompilerSymbol.VAR, yyline, yycolumn, new String(yytext()));}
{NumberInteger}     { return new Symbol(CompilerSymbol.NUMBERINT, yyline, yycolumn, new Integer(yytext())); }

//types
{INT} {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.INTEGER);}
//{UINT} {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.UNSIGNED_INT);}
//{FLOAT} {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.FLOAT);}
//{BOOL} {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.BOOLEAN);}

"+"     { return new Symbol(CompilerSymbol.PLUS, yyline, yycolumn); }
"-"     { return new Symbol(CompilerSymbol.MINUS, yyline, yycolumn); }
"*"     { return new Symbol(CompilerSymbol.TIMES, yyline, yycolumn); }
"/"     { return new Symbol(CompilerSymbol.DIVIDE, yyline, yycolumn); }
"("     { return new Symbol(CompilerSymbol.LPAR, yyline, yycolumn); }
")"     { return new Symbol(CompilerSymbol.RPAR, yyline, yycolumn); }
"vrai"  { return new Symbol(CompilerSymbol.BOOL, yyline, yytext()); }
"faux"  { return new Symbol(CompilerSymbol.BOOL, yyline, yytext()); }
"%"     { return new Symbol(CompilerSymbol.MOD, yyline, yycolumn); }
"=="    { return new Symbol(CompilerSymbol.EQUAL, yyline, yycolumn); }
"!="    { return new Symbol(CompilerSymbol.DIFF, yyline, yycolumn); }
"<"     { return new Symbol(CompilerSymbol.INF, yyline, yycolumn); }
"<="    { return new Symbol(CompilerSymbol.INFE, yyline, yycolumn); }
">"     { return new Symbol(CompilerSymbol.SUP, yyline, yycolumn); }
">="    { return new Symbol(CompilerSymbol.SUPE, yyline, yycolumn); }
"&"     { return new Symbol(CompilerSymbol.AND, yyline, yycolumn); }
"|"     { return new Symbol(CompilerSymbol.OR, yyline, yycolumn); }
"!"     { return new Symbol(CompilerSymbol.NOT, yyline, yycolumn); }
";"   { return new Symbol(CompilerSymbol.SEMIC, yyline, yycolumn); }
":=" { return new Symbol(CompilerSymbol.ASSIGN, yyline, yycolumn); }
//"[" {}
//"]" {}
//","     {return new Symbol(CompilerSymbol.COMA, yyline, yycolumn);}

/* -------------------------------------------------
        Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */
{Comment} {}

/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}
