public class Temporary implements Address{
    private int num;
    private int next = 0;
    
    Temporary(){
	num = next++;
    }

    public void print(){
	String s = "t" + num.toString();
	return s;
    }
}
