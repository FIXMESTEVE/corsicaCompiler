public class Else implements Instruction{
	Expression condition;
	Instruction thenCode;
	Instruction elseCode;

	public Else(Expression cond, Intstruction t, Instruction e ){
		condition = cond;
		thenCode = t;
		elseCode = e;
	}

	public void generateCode(final Label nextLabel){
		Label lthen = new Label();
		Label lelse = new Label();
		condition.generateJump(lthen, lelse);
		thenCode.generateCode(nextLabel);
		System.out.println("goto " + nextLabel.print());
		System.out.println(lelse.print() + ":");
		elseCode.generateCode(nextLabel);
	}
}