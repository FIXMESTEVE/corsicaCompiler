public class ConstantExpression extends ArithmeticExpression{
	private final float value;

	public ConstantExpression(float val){value=val;}
	public Address generateCode(){ return new Constant(value);}
}