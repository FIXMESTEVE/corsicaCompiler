public class Comparison extends BooleanExpression{
	private Expression leftExpr;
	private Expression rightExpr;
	private EnumOps operator;
	
	public Comparison(Expression l, EnumOps op, Expression r){
		leftExpr = l;
		rightExpr = l;
		op = operator;
	}

	public void generateJump(Label yes, Label no){
		Address lRes = leftExpr.generateCode();
		Address rRes = rightExpr.generateCode();

		System.out.println("if " + lRes.print() + " " + operator + " " + rRes.print() + " goto " + yes.print());
		System.out.println("goto " + no.print());
	}
}