import java.util.*;

public class VariableTableManager{
	public static void verify(HashMap hm, String name, EnumType type){
		//verifier les deux cas suivants
		if(hm.containsKey(name)){//variable non trouvée
			System.out.println("Error: variable "+name+" not declared!");
		}
		/*if(hm.get(name) != type){ //variable trouvée mais de type différent
			System.err.println("Warning: incompatible types! ("+hm.get(name)+" and "+type);
		}*/
	}
}