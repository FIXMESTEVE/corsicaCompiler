public class Constant<T> implements Address{
    private T value;

    public Constant(T v){
		value = v;
    }
    
    public String print(){
		return "" + value;
    }
}
