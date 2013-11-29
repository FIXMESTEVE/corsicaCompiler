public class Label{
    private int num;
    private int next = 0;
    
    Temporary(){
	num = next++;
    }

    public void print(){
	String s = "L" + num.toString();
	return s;
    }
}
