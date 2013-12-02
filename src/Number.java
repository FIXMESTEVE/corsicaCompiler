public class Number<T> extends ArithmeticExpression{
	private T number;

	public Number(T n){
		number = n;
	}

	public Address generateCode(){
		return new Constant(number);
	}

	public void generateJump(Label lol, Label lol2){}
}