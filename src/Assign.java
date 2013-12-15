import java.util.*;

public class Assign implements Instruction{
	private final String name;
	private final Expression expr;
	private final Expression index;
	public Assign(final String n, Expression e){
		name = n; expr = e;
		index = null;
	}

	public Assign(final String n, Expression i, Expression e){
		name = n; index = i; expr = e;
	}

	public void generateCode(final Label nextLabel){
		if(index != null){
			Address i = index.generateCode();
			Address result = expr.generateCode();
			System.out.println(name + "[" + i.print() + "] = " + result.print());
		}
		else{
			Address result = expr.generateCode();
			System.out.println(name + " = " + result.print());
		}
	}
}