package problemsOnLinkedList;

import linkedList.ListNode;

public class DeleteDupInSortedList2Occurances {

	public int length;
	
	public DeleteDupInSortedList2Occurances(){
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
			for(int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length++;
		return newNode;
	}
	
	public void deleteDuplicate(ListNode head) {
		ListNode p = head;
		ListNode q;
		while(p != null && p.next != null) {
			if(p.getData() == p.next.getData()) {
				q = p.next.next;
				p.next = q;
			}
			p = p.next;
		}
	}
	
	/** Traversing the list **/
	public static void printList(ListNode head) {
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		DeleteDupInSortedList2Occurances cList = new DeleteDupInSortedList2Occurances();
		ListNode cListHead = null;
		cListHead = cList.insert(cListHead, 10, 0);
		cList.insert(cListHead, 20, 1);
		cList.insert(cListHead, 30, 2);
		cList.insert(cListHead, 40, 3);
		cList.insert(cListHead, 50, 4);
		cList.insert(cListHead, 60, 5);
		cList.insert(cListHead, 60, 6);
		cList.insert(cListHead, 70, 7);
		cList.insert(cListHead, 70, 8);
		cList.insert(cListHead, 80, 9);
//		cList.insert(cListHead, 100, 10);
		
		
		cList.deleteDuplicate(cListHead);
		
		System.out.println("Original Linked List ");
		printList(cListHead);
	}
}
