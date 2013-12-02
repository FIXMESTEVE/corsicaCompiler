public class Variable extends ArithmeticExpression{
	private String varName;

	public Variable(String n){
		varName = n;
	}

	public Address generateCode(){
		return new Name(varName);
	}
}