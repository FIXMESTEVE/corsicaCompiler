import java.util.*;
public class Array extends ArithmeticExpression{
	private String name;
	public Vector<Expression> indices;

	public Array(String n, Vector<Expression> i){
		name = n;
		indices = i;
	}

	public Address generateCode(){
		Address i = indices.get(0).generateCode();
		Address result = new Temporary();
		System.out.println(result.print() + " = " + name + "[" + i.print() + "]");
		return result;
	}
}