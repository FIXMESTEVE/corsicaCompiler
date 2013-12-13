public class UnaryArithmeticExpression extends ArithmeticExpression{
	private EnumOps operator;
	private Expression soleExpr;

	public UnaryArithmeticExpression(EnumOps o, Expression e){
		operator = o;
		soleExpr = e;
	}

	public Address generateCode(){
		Address resSoleExpr = soleExpr.generateCode();
		Address result = new Temporary();
		System.out.println(result.print() + " = " + operator + resSoleExpr.print());
		return result;
	}
}