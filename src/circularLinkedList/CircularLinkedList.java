package circularLinkedList;

public class CircularLinkedList {
	
	public static CLLNode tail;
	public int length;
	
	public CircularLinkedList() {
		tail = null;
		length = 0;
	}
	

	/* get size of Circular Linked List starting with tail*/
	public int getLength(CLLNode tail) {
		int size = 0;
		CLLNode currentNode = tail.getNext();
		while(currentNode != tail) {
			size++;
			currentNode = currentNode.getNext();
		}
		return size;
	}
	
	/* get size of circular linked list */
	public int size(){
		return length;
	}
	
	/* print circular linked list */
	public void printList() {
		CLLNode currentNode = tail.getNext();
		while(currentNode != tail){
			System.out.print(currentNode.getData() + "->");
			currentNode = currentNode.getNext();
		}
		System.out.println(currentNode.getData());
	}
	
	/* insert at the starting */
	public void addToHead(int data) {
		CLLNode temp = new CLLNode(data);
		if(tail == null){
			tail = temp;
			tail.setNext(tail);
		} else {
			temp.setNext(tail.getNext());
			tail.setNext(temp);
		}
		length++;
	}
	
	/* insert at the end */
	public void addToTail(int data) {
		CLLNode temp = new CLLNode(data);
		addToHead(data);
		tail = tail.getNext();
	}

	/* Gets head of the list */
	public int peek(){
		return tail.getNext().getData();
	}
	
	/* Get tail of the list */
	public int end() {
		return tail.getData();
	}
	
	
	/* remove from head */
	public int removeFromHead() {
		CLLNode temp = tail.getNext();
		if(temp == tail) {
			tail = null;
		} else {
			tail.setNext(temp.getNext());
			temp.setNext(null);
		}
		
		length--;
		return temp.getData();
	}
	
	/* remove from tail */
	public int removeFromTail() {
		CLLNode secondLastNode = tail;
		while(secondLastNode.getNext() != tail){
			secondLastNode = secondLastNode.getNext();
		}
		
		CLLNode temp = tail;
		if(secondLastNode == temp){
			tail = null;
		} else {
			secondLastNode.setNext(temp.getNext());
			tail = secondLastNode;
		}
			
		length--;
		return temp.getData();
	}
	
	public boolean contains(int data){
		if(tail == null) return false;
		
		CLLNode finger = tail.getNext();
		while(finger != tail && (!(finger.getData() == data))) {
			finger = finger.getNext();
		}
		
		return finger.getData() == data;
	}
	
	public int remove(int data) {
		CLLNode finger = tail.getNext();
		CLLNode previous = tail;
		
		int compares;
		for(compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
			previous = finger;
			finger = finger.getNext();
		}
		
		if(finger.getData() == data) {
			previous.setNext(finger.getNext());
		}
		
		finger.setNext(null);
		length--;
		return finger.getData();
	}
	
	public static void main(String args[]) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.addToHead(3);
		cll.addToHead(2);
		cll.addToHead(1);
		cll.addToTail(4);
		cll.addToTail(5);
		cll.addToTail(6);
		cll.addToTail(7);
		cll.addToTail(8);
		cll.printList();
		
		System.out.println("head: " + cll.peek());
		System.out.println("tail: " + cll.end());
		System.out.print("Remove from head : ");
		cll.removeFromHead();
		cll.printList();
		
		System.out.print("Remove from tail : ");
		cll.removeFromTail();
		cll.printList();
		
		System.out.print("Remove 3 from list : ");
		cll.remove(3);
		cll.printList();
		
		System.out.println(cll.contains(2));
		
	}
	
	
	
	
	
	
}
