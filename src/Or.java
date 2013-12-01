public class Or extends BooleanExpression {
	private Expr leftExpr;
	private Expr rightExpr;

	public Or(Expr left, Expr right){
		leftExpr = left;
		rightExpr = right;
	}

	public void generateJump(Label yes, Label no){
		
	}
}