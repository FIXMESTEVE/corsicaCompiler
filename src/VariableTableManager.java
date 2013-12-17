import java.util.*;

public class VariableTableManager{
	public static void verify(HashMap hm, String name){
		//verifier les deux cas suivants
		if(!hm.containsKey(name)){//variable non trouvée
			System.out.println("---------------------\n Error: variable "+name+" not declared! \n---------------------");
		}
		/*if(hm.get(name) != type){ //variable trouvée mais de type différent
			System.err.println("Warning: incompatible types! ("+hm.get(name)+" and "+type);
		}*/
	}
}