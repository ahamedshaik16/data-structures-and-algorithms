package circularLinkedList;

public class CLLNode {

	public CLLNode next;
	public int data;
	
	public CLLNode() {
		next = null;
		data = 0;
	}
	
	public CLLNode(int data) {
		next = null;
		this.data = data;
	}

	public CLLNode getNext() {
		return next;
	}

	public void setNext(CLLNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
	
}
