public class VariableExpression extends ArithmeticExpression{
	private final String name;

	public VariableExpression(final String n){ name = n;}
	public Address generateCode(){
		return new Name(name);
	}
}