import java.util.*;

public class BlockInstruction implements Instruction{
	private Vector<Instruction> instructions;

	public BlockInstruction(Vector<Instruction> i){ instructions = i; }

	//on genere le code de toutes les instructions, on met un label vers l'instruction suivante
	//c'est necessaire pour que certaines choses marchent, les boucles imbriquees par exemple
	//quand on atteint la derniere instruction, on genere son code et on sort du block
	public void generateCode(final Label nextLabel){
		for(int i = 0; i < instructions.size(); i++){
			if(i < instructions.size()-1){										
				Label tmpNextLabel = new Label();
				instructions.get(i).generateCode(tmpNextLabel);
				System.out.println(tmpNextLabel.print() + ":");
			}
			else{
				instructions.get(i).generateCode(nextLabel);
			}
		}
	}
}