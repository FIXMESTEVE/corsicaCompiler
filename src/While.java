public class While implements Instruction{
	private Expression condition;
	private Instruction code;

	public While(Expression cond, Instruction c){
		condition = cond;
		code = c;
	}

	public void generateCode(final Label nextLabel){
		Label topLabel = new Label();
		Label codeLabel = new Label();
		System.out.println(topLabel.print() + ":");
		condition.generateJump(codeLabel, next);
		System.out.println(bodyLabel.print() + ":");
		code.generateCode(topLabel);
		System.out.println("goto " + topLabel.print());
	}
}