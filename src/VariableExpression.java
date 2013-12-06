public class Var extends ArithmeticExpression{
	private final String name;

	public Var(final String n){ name = n;}
	public Address generateCode(){
		return new Name(name);
	}
}