public class Constant<T> implements Address{
    private T value;

    Constant(T v){
		value = v;
    }
    
    public String print(){
		return "" + value;
    }
}
