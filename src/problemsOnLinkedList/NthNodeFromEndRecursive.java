package problemsOnLinkedList;

import linkedList.ListNode;

public class NthNodeFromEndRecursive {

	private int length;
	private static ListNode head;
	private static ListNode nthNode;
	private int counter;
	
	public NthNodeFromEndRecursive() {
		length = 0;
		counter = 0;
	}
	
	public void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	public void insertAtEnd(ListNode node){
		if(head == null)
			head = node;
		else{
			ListNode p, q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length++;			
	}
	
	public void insert(int data, int position){
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		
		if(head == null){
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		} else {
			ListNode temp = head;
			for(int i = 1; i < position; i++){
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		
		length++;
	}
	
	/** Traversing the list **/
	public static void printList() {
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public int size() {
		return length++;
	}
	
	public ListNode recursiveNthNode(ListNode head, int position){
		if(head != null){
			
			recursiveNthNode(head.next, position);
			counter++;
			if(counter == position){
				nthNode = head;
			}	
		}
		return nthNode;
	}
	
	public static void main(String[] args) {
		NthNodeFromEndRecursive list = new NthNodeFromEndRecursive();
		list.insertAtBegin(new ListNode(10));
		list.insert(20, 1);
		list.insert(30, 2);
		list.insert(40, 3);
		list.insert(50, 4);
		list.insert(60, 5);
		list.insert(70, 6);
		list.insert(80, 7);
		list.insert(90, 8);
		list.insertAtEnd(new ListNode(100));
		printList();
		System.out.println("Size: " + list.size());
		
		System.out.println("Nth Node position 5 " + list.recursiveNthNode(head, 4));
	}

}
