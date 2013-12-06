public class ConstantExpression<T> extends ArithmeticExpression{
	private final T value;

	public ConstantExpression(T val){value=val;}
	public Address generateCode(){ return new Constant(value);}
}