
public class ArrayStack implements Stack{
	
	public Object[] arr;
	public int top;
	
	public ArrayStack() {
		arr = new Object[10];
		//top = 0;
	}

	public void push(Object item) {
		if(top == arr.length) {
			grow_stack();
		}
		arr[top++] = item;
	}
	
	public Object pop() {
		if(empty()) {
			return null;
		}
		return arr[--top];
	}
	
	public Object peek() {
		if(empty()) {
			return null;
		}
		return arr[top-1];
	}
	
	public boolean empty() {
		if(top == 0) {
			return true;
		}
		return false;
	}
	
	public void grow_stack() {
		Object[] new_arr = new Object[arr.length * 2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}
}
