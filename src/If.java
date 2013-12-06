public class If implements Instruction{
	Expression condition;
	Instruction code;

	public If(Expression cond, Instruction c){
		condition = cond;
		code = c;
	}

	public void generateCode(final Label nextLabel){
		Label codeLabel = new Label();
		condition.generateJump(codeLabel, nextLabel);
		System.out.println(codeLabel.print() + ":");
		code.generateCode(nextLabel);
	}
}