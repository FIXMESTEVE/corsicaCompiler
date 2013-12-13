public class VariableTableManager{
	public static void contains(HashMap hm, String type, String name){
		//verifier les deux cas suivants
		if(hm.containsKey(name)){//variable non trouvée
			System.err.println("Error: variable "+name+" not found!");
		}
		if(hm.get(name) != type){ //variable trouvée mais de type différent
			System.err.println("Warning: incompatible types! ("+hm.get(name)+" and "+type);
		}
	}
}