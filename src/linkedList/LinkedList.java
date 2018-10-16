package linkedList;

public class LinkedList {
	private int length = 0;
	
	static ListNode head;
	public LinkedList(){
		length = 0;
	}
	
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	public synchronized void insertAtEnd(ListNode node) {
		if(head == null ) {
			head = node;
		} else {
			ListNode p, q;
//			for(p = head; (q = p.getNext()) != null; p = q){
//				if(q.getNext()==null)
//					p.setNext(node);
//			}
				
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length ++;
	}
	
	public void insert(int data, int position) {
		if(position < 0){
			position = 0;
		}
		if(position > length){
			position = length;
		}
		if(head == null){
			head = new ListNode(data);
		} else if(position == 0) {
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		} else {
			ListNode temp = head;
			for(int i =1; i < position; i++) {
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
			
		}
		length += 1;
	}
	
	/** Traversing the list **/
	public static int printList() {
		int length = 0;
		ListNode currentNode = head;
		while(currentNode != null) {
			length++;
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
		return length;
	}
	
	public synchronized ListNode removeFromBegin(){
		ListNode node = head;
		if(node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}
	
	public synchronized ListNode removeFromEnd() {
		if(head == null)
			return null;
		ListNode present =  head, temp = null, next = head.getNext();
		if(next == null){
			head = null;
			length--;
			return present;
		}
		
		while((next = present.getNext()) != null) {
			temp = present;
			present = next;
		}
		
		temp.setNext(null);
		length--;
		return present;
	
	}
	
	public void delete(int position){
		if(position < 0)
			position = 0;
		if(position >= length)
			position = length-1;
		
		if(head == null)
			return;
		if(position == 0) {
			head = head.getNext();
		} else {
			ListNode temp = head;
			for(int i = 1; i < position; i++){
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		
		
		length--;
	}
	
	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.insert(2, 0);
		list.insert(0, 1);
		list.insert(3, 2);
		list.insertAtBegin(new ListNode(1));
		list.insertAtBegin(new ListNode(2));
		list.insertAtEnd(new ListNode(10));
		printList();
		list.removeFromBegin();
		printList();
		list.removeFromEnd();
		printList();
		list.delete(1);
		int size = printList();
		System.out.println("Size: " + size);
	}
}
