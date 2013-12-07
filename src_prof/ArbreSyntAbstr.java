public class ArbreSyntAbstr {
	private ArbreSyntAbstr left;
	private ArbreSyntAbstr right;
	private EnumTag tag;
	private Object value;

	public ArbreSyntAbstr(ArbreSyntAbstr left, ArbreSyntAbstr right, EnumTag tag, Object value) 
	{
		//if(left != null && right != null && !left.type.compareTo(right.type))
		//	throw new TypeException(left.type,right.type, tag);	   
		
		this.left=left;
		this.right=right;
		this.tag=tag; 
		this.value=value;
	}

	public ArbreSyntAbstr(EnumTag tag, Object value){ 
		this(null, null, tag, value);
	}

	public ArbreSyntAbstr getLeft() {
		return left;
	}

	public void setLeft(ArbreSyntAbstr left) {
		this.left = left;
	}

	public ArbreSyntAbstr getRight() {
		return right;
	}

	public void setRight(ArbreSyntAbstr right) {
		this.right = right;
	}

	public Object getValue() {
		return value;
	}

	public String toString() {
		String result = new String();
		result += tag.toString();
		if ((left != null) || (right != null)){
			result +="(";
			if (left != null)
				result += left.toString();
			result+=",";
			if (right != null)
				result += right.toString();
			result+=")";
		}
		return result;
	}

}
