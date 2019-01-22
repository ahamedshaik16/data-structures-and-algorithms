package problemsOnLinkedList;

import linkedList.ListNode;

public class CheckLoopInLinkedList {

	private int length;
	private static ListNode head;
	
	public CheckLoopInLinkedList(){
		length = 0;
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
		}else {
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
	
	public ListNode checkLoop(ListNode head){
		ListNode p = head;
		ListNode q = head;
		while((q.next != null) && (p != null) && (q != null)){
			p = p.next;
			q = q.next.next;
			if(p == q)
				return p;
		}
		return null;
	}
	
	public ListNode startLoop(ListNode tempNode){
		ListNode q = head;
		while(tempNode != q){
			tempNode = tempNode.next;
			q = q.next;
		}
		return tempNode;
	}
	
	public void removeLoop(ListNode tempNode){
		ListNode q = head;
		while(tempNode != q){
			tempNode = tempNode.next;
			q = q.next;
		}
		tempNode.next = null;
	}
	
	public static void main(String[] args) {
		CheckLoopInLinkedList cList = new CheckLoopInLinkedList();
		cList.insert(10, 0);
		cList.insert(20, 1);
		cList.insert(30, 2);
		cList.insert(40, 3);
		cList.insert(50, 4);
		cList.insert(60, 5);
		cList.insert(70, 6);
		cList.insert(80, 7);
		cList.insert(90, 8);
		cList.insert(100, 9);
		
		head.next.next.next.next.next.next.next.next.next.next = head.next.next;
		ListNode tempNode = cList.checkLoop(head);
		System.out.println( "Loop Exists: "+tempNode != null);
		if(cList.checkLoop(head) != null){
			System.out.println("Starting Node of the loop: " + cList.startLoop(tempNode));
		}
		
		/** Removig loop **/
		cList.removeLoop(tempNode);
		System.out.println("After removing loop, does loop exists: " + cList.checkLoop(head));
		
	}

}
