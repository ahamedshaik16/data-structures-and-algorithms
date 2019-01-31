package problemsOnLinkedList;

import doublyLinkedList.DLLNode;

public class ReverseDoublyLinkedList {

	static DLLNode head;
	DLLNode tail;
	int length;
	
	public ReverseDoublyLinkedList(){
		length = 0;
	}
	
	public void insertAtBegin(int data){
		DLLNode newNode = new DLLNode(data, null, head);
		if(head != null)
			head.prev = newNode;
		head = newNode;
		length++;		
	}
	
	public void insertAtEnd(int data) {
		DLLNode newNode = new DLLNode(data);
		DLLNode currentNode = head;
		if(head == null) {
			head = newNode;
		} else {
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
			newNode.setPrev(currentNode);
		}
		length++;
	}
	
	public void insertAtPosition(int data, int position) {
		DLLNode newNode = new DLLNode(data);
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		if(head==null)
			head = newNode;
		else {
			DLLNode tempNode = head;
			for(int i = 1; i < position; i++){
				tempNode = tempNode.getNext();
			}
			newNode.setNext(tempNode.getNext());
			tempNode.getNext().setPrev(newNode);
			tempNode.setNext(newNode);
			newNode.setPrev(tempNode);
		}
		length++;
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
	
	public DLLNode reverseDoublyList(){
		DLLNode currentNode = head, newNodeHead = head;
		DLLNode tempNode = null;
		while(currentNode != null){
			tempNode = currentNode.getPrev();
			currentNode.prev = currentNode.next;
			currentNode.next = tempNode;
			currentNode = currentNode.prev;
		}
		if(tempNode != null){
			newNodeHead = tempNode.prev;
		}
		return newNodeHead;
		
	}
	
	public static void main(String[] args) {
		
		ReverseDoublyLinkedList dllList = new ReverseDoublyLinkedList();
		dllList.insertAtBegin(2);
		dllList.insertAtBegin(1);		
		dllList.insertAtEnd(4);
		dllList.insertAtEnd(5);
		dllList.insertAtEnd(6);
		dllList.insertAtEnd(7);
		dllList.insertAtEnd(8);
		dllList.insertAtPosition(3, 2);
		
		System.out.println("Original list: ");
		dllList.printList(head);
		
		System.out.println("Reverse list:");
		DLLNode reverseHead = null;
		reverseHead = dllList.reverseDoublyList();
		
		dllList.printList(reverseHead);
		
		
	}

}
