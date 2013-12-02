public class Temporary implements Address{
    private int num;
    private static int next = 0;
    
    Temporary(){
		num = next++;
    }

    public String print(){
		String s = "t" + num;
		return s;
    }
}
