package problemsOnLinkedList;

import linkedList.ListNode;

public class MiddleNodeOfLinkedList {

	public int length;
	
	public MiddleNodeOfLinkedList()  {
		length = 0;
	}
	
	public ListNode insert(ListNode head, int data, int position) {
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
			for(int i = 1; i < position; i++){
				temp = temp.getNext();
			}
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length++;
		
		return newNode;
	}
	
	public void printList(ListNode head){
		ListNode currentNode =  head;
		while(currentNode != null){
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public ListNode middleNode(ListNode head){
		ListNode p = head, q = head;
		while((q != null) && (q.next != null)){
			p = p.next;
			q = q.next.next;
		}
		
		return p;
	}
	
	public static void main(String[] args) {

		MiddleNodeOfLinkedList evenList = new MiddleNodeOfLinkedList();
		
		ListNode evenListHead = null;
		evenListHead = evenList.insert(evenListHead, 1, 0);
		evenList.insert(evenListHead, 2, 1);
		evenList.insert(evenListHead, 3, 2);
		evenList.insert(evenListHead, 4, 3);
		evenList.insert(evenListHead, 5, 4);
		evenList.insert(evenListHead, 6, 5);
		
		System.out.println("Original List: ");
		evenList.printList(evenListHead);
		
		System.out.println("Middle node: " + evenList.middleNode(evenListHead));
		
		System.out.println("_________________________");
		
		MiddleNodeOfLinkedList oddList = new MiddleNodeOfLinkedList();
		
		ListNode oddListHead = null;
		oddListHead = oddList.insert(oddListHead, 1, 0);
		oddList.insert(oddListHead, 2, 1);
		oddList.insert(oddListHead, 3, 2);
		oddList.insert(oddListHead, 4, 3);
		oddList.insert(oddListHead, 5, 4);
		
		System.out.println("Original List: ");
		oddList.printList(oddListHead);
		
		System.out.println("Middle node: " + oddList.middleNode(oddListHead));
		
		
	}

}
