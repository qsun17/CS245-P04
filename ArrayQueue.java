
public class ArrayQueue implements Queue{
	
	public int head;
	public int tail;
	public Object[] arr;
	
	public ArrayQueue() {
		arr = new Object[10];
		//head = 0;
		//tail = head;
	}
	
	public Object dequeue() {
		if(empty()) {
			return null;
		}
		Object item = arr[head];
		head++;
		if(head == arr.length) {
			head = 0;
		}
		return item;
	}
	
	public void enqueue(Object item) {
		if(full()) {
			grow_queue();
		}
		arr[tail++] = item;
		if(tail == arr.length) {
			tail = 0;
		}
	}
	
	public boolean full() {
		if((tail+1) % arr.length == head) {
			return true;
		}
		return false;
	}
	
	public void grow_queue() {
		Object[] new_arr = new Object[arr.length * 2];
        if (head < tail) {
            System.arraycopy(arr, head, new_arr, 0, arr.length);
        } else {
            System.arraycopy(arr, head, new_arr, 0, arr.length - head);
            System.arraycopy(arr, 0, new_arr, arr.length - head, tail);
        }
		arr = new_arr;
		tail = head;
		head = 0;
	}	

	public boolean empty() {
		if(head == tail) {
			return true;
		}
		return false;
	}
}
