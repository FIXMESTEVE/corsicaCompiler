public class Nombre<T> extends ArithmeticExpression{
	private T number;

	public Nombre(T n){
		number = n;
	}

	public Address generateCode(){
		return new Constant(number);
	}
}