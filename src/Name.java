public class Name implements Address{
    private String name;
    
    Name(String n){
		name = n;
    }

    public String print(){
		return name;
    }
}
