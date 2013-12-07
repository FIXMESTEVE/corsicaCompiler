public class And extends BooleanExpression{
	private Expression leftExpr;
	private Expression rightExpr;

	public And(Expression l, Expression r){
		leftExpr = l; rightExpr = r;
	}

	public void generateJump(Label yes, Label no){
		Label lRight = new Label();
		leftExpr.generateJump(lRight, no);
		System.out.println(lRight.print() + ":");
		rightExpr.generateJump(yes, no);
	}
}