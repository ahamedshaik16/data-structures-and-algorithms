package doublyLinkedList;

public class DoublyLinkedList {

	static DLLNode head;
	DLLNode tail;
	int length;
	
	public DoublyLinkedList(){
		length = 0;
	}
	
	public void insertAtStarting(int newValue) {
		DLLNode newNode = new DLLNode(newValue,null,head);
		if (head != null) 
	        head.prev = newNode; 
		head = newNode;
		length++;
	} 
	
	public void insertAtEnd(int newValue) {
		DLLNode newNode = new DLLNode(newValue);
		DLLNode presentNode = head;
		
		if(head == null) {
			head = newNode;
			length++;
		} else {
			while(presentNode.getNext() != null) {
				presentNode = presentNode.getNext();
			}
			presentNode.setNext(newNode);
			newNode.setPrev(presentNode);
			length++;
		}
	}
	
	public void insertAtMiddle(int data, int position) {
		DLLNode newNode = new DLLNode(data);
		if(position < 0) 
			position = 0;
		if(position >= length)
			position = length - 1;
		if(head == null) {
			head = newNode;
			length++;
		} else {
			DLLNode tempNode = head;
			for(int i = 1; i < position; i++){
				tempNode = tempNode.getNext();
			}
			newNode.setNext(tempNode.getNext());
			tempNode.getNext().setPrev(newNode);
			tempNode.setNext(newNode);
			newNode.setPrev(tempNode);
			length++;
		}
		
	}
	
	public void deleteAtBegin(){
		if(head == null) {
			return;
		} else if(head.getNext() == null){
			head = null;
			length--;
		} else {
			DLLNode nextNode = head.getNext();
			nextNode.setPrev(null);
			head = nextNode;
			length--;
		}
	}
	
	public void deleteAtEnd() {
		if(head == null) {
			return;
		} else if(head.getNext() == null) {
			head = null;
			length--;
		} else {
			DLLNode presentNode = head;
			while(presentNode.getNext() != null){
				presentNode = presentNode.getNext();
			}
			presentNode.getPrev().setNext(null);
			length--;
		}
	}
	
	void deleteAtPosition(int position) {
		if(position < 0){
			position = 0;
		}
		if(position >= length)
			position = length - 1;
		
		if(head == null)
			return;
		if(head.getNext() == null) {
			head = null;
			length--;
			return;
		}
		
		DLLNode tempNode = head;
		for(int i = 1; i <= position; i++) {
			tempNode = tempNode.getNext();
		}
		
		if(tempNode.getPrev()!= null) tempNode.getPrev().setNext(tempNode.getNext());
		if(tempNode.getNext() != null) tempNode.getNext().setPrev(tempNode.getPrev());
		length--;
	}
	
	void printList(DLLNode node) { 
		if(node == null) {
			System.out.println("List is empty");
		}
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
        System.out.println();
    } 
	
	public static void main(String args[]) {
		DoublyLinkedList dllList = new DoublyLinkedList();
		dllList.insertAtStarting(2);
		dllList.insertAtStarting(1);		
		dllList.insertAtEnd(4);
		dllList.insertAtEnd(5);
		dllList.insertAtEnd(6);
		dllList.insertAtEnd(7);
		dllList.insertAtEnd(8);
		dllList.insertAtMiddle(3, 2);
		dllList.printList(head);
		
		dllList.deleteAtBegin();
		dllList.printList(head);
		
		dllList.deleteAtEnd();
		dllList.printList(head);
		
		dllList.deleteAtPosition(1);
		dllList.printList(head);
		
		dllList.deleteAtPosition(2);
		dllList.printList(head);
		
		dllList.deleteAtEnd();
		dllList.printList(head);
		
		dllList.deleteAtPosition(3);
		dllList.printList(head);
		
		dllList.deleteAtPosition(3);
		dllList.printList(head);
		
		dllList.deleteAtPosition(3);
		dllList.printList(head);

	}
	
}
