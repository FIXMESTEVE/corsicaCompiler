public class UnaryArithmeticExpression extends ArithmeticExpression{
	private EnumOps op;
	private Expression expr;

	public UnaryArithmeticExpression(EnumOps o, Expression e){
		op = o;
		expr = e;
	}

	public Address generateCode(){
		Address op = expr->generateCode();
		Address result = new Temporary;
		System.out.println(result.print() + " = " + op.print());
		return result;
	}
}