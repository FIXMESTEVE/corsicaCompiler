public class Label{
    private int num;
    private static int next = 0;
    
    public Label(){
		num = next++;
    }

    public String print(){
		String s = "L" + num;
		return s;
    }
}
