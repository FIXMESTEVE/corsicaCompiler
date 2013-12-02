public class BinaryArithmeticOperation extends ArithmeticExpression{
	private Expression leftExpr;
	private Expression rightExpr;
	private EnumOps operator;

	public BinaryArithmeticOperation(Expression l, EnumOps op, Expression r){
		leftExpr = l; rightExpr = r; operator = op;
	}
	public Address generateCode(){
		Address resLeft = leftExpr.generateCode();
		Address resRight = rightExpr.generateCode();
		Address res = new Temporary();
		System.out.println(res.print() + " = " + resLeft.print() + " " + operator + " " + resRight.print());
		return res;
	}
}