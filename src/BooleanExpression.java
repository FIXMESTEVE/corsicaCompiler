abstract class BooleanExpression implements Expression {
	public Address generateCode(){
		Label lYes = new Label();
		Label lNo  = new Label();
		Label lNext = new Label();
		generateJump(lYes, lNo);
		Address result = new Temporary();
		System.out.println(lYes.print() + ": " + result.print() + "= 1");
		System.out.println(" goto " + lNext.print());
		System.out.println(lNo.print() + ": " + result.print() + " = 0");
		System.out.println(lNext.print() + ":");
		return result;
    }
}
