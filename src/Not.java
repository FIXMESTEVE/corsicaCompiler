public class Not extends BooleanExpression{
	private Expression soleExpr;

	public Not(Expression s){
		soleExpr = s;
	}

	public void generateJump(Label yes, Label no){
		soleExpr.generateJump(no, yes);
	}
}