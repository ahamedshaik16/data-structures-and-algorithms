package problemsOnLinkedList;

import linkedList.ListNode;

public class NthNodeInOneScan {
	private int length;
	static ListNode head;
	
	public NthNodeInOneScan() {
		length = 0;
	}
	
	public void insertAtBegin(ListNode node){
		node.setNext(head);
		head = node;
		length++;
	}
	
	public void insertAtEnd(ListNode node) {
		if(head == null){
			head = node;
		} else {
			ListNode p, q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length++;
	}
	
	public void insert(int data, int position) {
		if(position < 0){
			position = 0;			
		} else if(position > length){
			position = length;
		}
		
		if(head == null) {
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
		int length = 0;
		ListNode currentNode = head;
		while(currentNode != null) {
			length++;
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public int size() {
		return length++;
	}
	
	public ListNode NthNodeFromEnd(int position) {
		ListNode pNthNode = null, pTemp = head;
		for(int i = 1; i < position; i++) {
			if(pTemp != null) {
				pTemp = pTemp.getNext();
			}
		}
		while(pTemp!=null){
			if(pNthNode == null)
				pNthNode = head;
			else{
				pNthNode = pNthNode.getNext();
			}
			pTemp = pTemp.getNext();
		}
		
		if(pNthNode != null)
			return pNthNode;
		return null;
	}
	
	public static void main(String args[]) throws Exception {
		NthNodeInOneScan list = new NthNodeInOneScan();
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
		
		
		System.out.println("Nth Node position 5 " + list.NthNodeFromEnd(5));
	}
}
