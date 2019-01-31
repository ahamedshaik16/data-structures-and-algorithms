package problemsOnLinkedList;

import linkedList.ListNode;

public class SwapNodesWithoutSwappingData {

	public int length;
	
	public static ListNode p, q, prev, prevX, prevY, pX, pY;
	
	public SwapNodesWithoutSwappingData(){
		length = 0;
	}
	
	public ListNode insert(ListNode head, int data, int position){
		ListNode newNode = new ListNode(data);
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		if(head == null){
			newNode.next = head;
			head = newNode;
		} else {
			ListNode temp = head;
			for(int i = 1;  i < position; i++){
				temp = temp.getNext();
			}
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length++;
		return newNode;		
	}
	
	/** Traversing list **/
	public void printList(ListNode head) {
		ListNode currentNode = head;
		while(currentNode != null){
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public void searchNodes(int x, int y, ListNode head){
		
		/** search for x in List **/
		p = head;
		prev = null;
		while((p != null) && (p.getData() != x)){
			prev = p;
			p = p.next;
		}
		pX = p;
		prevX = prev;
		
		/** search for y in List **/
		p = head;
		prev = null;
		while((p != null) && (p.getData() != y)){
			prev = p;
			p = p.getNext();
		}
		
		pY = p;
		prevY = prev;
		
	}
	
	public ListNode swapNodes(int x, int y, ListNode head){
		searchNodes(x, y, head);
		
		ListNode temp;
		
		temp = pY.next;
		pY.next = pX.next;
		pX.next = temp;
		
		if(prevX == null){
			head = pY;
			prevY.next = pX;
		}
		
		if(prevY == null) {
			head = pX;
			prevX.next = pY;
		}
		
		if((prevX != null) && (prevY != null)) {
			prevX.next = pY;
			prevY.next = pX;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		SwapNodesWithoutSwappingData list = new SwapNodesWithoutSwappingData();
		ListNode listHead = null;
		
		listHead = list.insert(listHead, 10, 0);
		list.insert(listHead, 20, 1);
		list.insert(listHead, 30, 2);
		list.insert(listHead, 40, 3);
		list.insert(listHead, 50, 4);
		list.insert(listHead, 60, 5);
		list.insert(listHead, 70, 6);
		
		System.out.println("Original List");
		list.printList(listHead);
		
		ListNode newHead  = list.swapNodes(10, 50, listHead);
		
		System.out.println("After swapping: ");
		list.printList(newHead);
	}

}
