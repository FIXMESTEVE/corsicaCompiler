public class Or extends BooleanExpression {
	private Expression leftExpr;
	private Expression rightExpr;

	public Or(Expression left, Expression right){
		leftExpr = left;
		rightExpr = right;
	}

	public void generateJump(Label yes, Label no){
		Label lRight = new Label();
		leftExpr.generateJump(yes, lRight);
		System.out.println(lRight.print() + ": ");
		rightExpr.generateJump(yes, no);
	}
}