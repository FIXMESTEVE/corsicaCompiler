abstract class ArithmeticExpression implements Expression{
	public void generateJump(Label yes, Label no){
		Address res = generateCode();
		System.out.println("if" + res.print() + " != 0 goto " + yes.print());
		System.out.println("goto" + no.print());
	}
}