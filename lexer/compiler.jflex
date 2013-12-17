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
Comment2  = "//" [^\n\r]* [\n|\r|\r\n]

NumberFloat = [[:digit:]]+(\.[[:digit:]]+)?([Ee][+-]?[[:digit:]]+)?
NumberInteger = [[:digit:]]+
VAR = [a-zA-Z]+[1-9]*

%%

//types
"int*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_INTEGER);}
"unsigned int*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_UNSIGNED_INT);}
"float*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_FLOAT);}
"unsigned float*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_UNSIGNED_FLOAT);}
"char*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_CHAR);}
"string*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_STRING);}
"short*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_SHORT);}
"unsigned short*" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.PTR_UNSIGNED_SHORT);}

"short" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.SHORT);}
"unsigned short" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.UNSIGNED_SHORT);}
"int" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.INTEGER);}
"unsigned int" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.UNSIGNED_INT);}
"float" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.FLOAT);}
"unsigned float" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.UNSIGNED_FLOAT);}
"bool" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.BOOLEAN);}
"char" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.CHAR);}
"string" {return new Symbol(CompilerSymbol.TYPE, yyline, yycolumn, EnumType.STRING);}

//operateurs, booleens, parentheses...
"+"     { return new Symbol(CompilerSymbol.PLUS, yyline, yycolumn); }
"-"     { return new Symbol(CompilerSymbol.MINUS, yyline, yycolumn); }
"*"     { return new Symbol(CompilerSymbol.MULT, yyline, yycolumn); }
"/"     { return new Symbol(CompilerSymbol.DIV, yyline, yycolumn); }
"("     { return new Symbol(CompilerSymbol.LPAR, yyline, yycolumn); }
")"     { return new Symbol(CompilerSymbol.RPAR, yyline, yycolumn); }
"true"  { return new Symbol(CompilerSymbol.BOOL, yyline, yycolumn, yytext()); }
"false" { return new Symbol(CompilerSymbol.BOOL, yyline, yycolumn, yytext()); }
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
"=" { return new Symbol(CompilerSymbol.ASSIGN, yyline, yycolumn); }
"if" {return new Symbol(CompilerSymbol.IF, yyline, yycolumn); }
"while" {return new Symbol(CompilerSymbol.WHILE, yyline, yycolumn); }
"else" {return new Symbol(CompilerSymbol.ELSE, yyline, yycolumn); }
"{" { return new Symbol(CompilerSymbol.LBRACKET, yyline, yycolumn);}
"}" { return new Symbol(CompilerSymbol.RBRACKET, yyline, yycolumn);}
":" { return new Symbol(CompilerSymbol.COLON, yyline, yycolumn);}
"[" { return new Symbol(CompilerSymbol.LSQUAREBRACKET, yyline, yycolumn);}
"]" { return new Symbol(CompilerSymbol.RSQUAREBRACKET, yyline, yycolumn);}
//","     {return new Symbol(CompilerSymbol.COMA, yyline, yycolumn);}

//variables and numbers
{VAR} {return new Symbol(CompilerSymbol.VAR, yyline, yycolumn, new String(yytext()));}
{NumberInteger}     { return new Symbol(CompilerSymbol.NUMBERINT, yyline, yycolumn, new Integer(yytext())); }
{NumberFloat}     { return new Symbol(CompilerSymbol.NUMBERFLOAT, yyline, yycolumn, new Float(yytext())); }
/* -------------------------------------------------
        Commentaires - Caracteres non pris en compte
   ------------------------------------------------- */
{Comment} {}
{Comment2} {}
/* -------------------------------------------------
   ------------------------------------------------- */
.|\n {}
