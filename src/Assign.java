public class Assign implements Instruction{
	private final String name;
	private final Expression expr;

	public Assign(final String n, Expression e){
		name = n; expr = e;
	}

	public void generateCode(final Label nextLabel){
		Address result = expr.generateCode();
		System.out.println(name + " " + result.print());
	}
}