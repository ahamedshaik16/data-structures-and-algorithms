package problemsOnLinkedList;

import linkedList.ListNode;

public class SwapNodesPairWiseInLinkedList {

	public int length;
	
	public SwapNodesPairWiseInLinkedList(){
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
			for(int i = 1; i < position; i++) {
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
	
	public ListNode swapNode(ListNode head){
		ListNode p, q, newListHead, temp;
		p = head;
		newListHead = p.next;
		while(true) {
			q = p.next;
			temp = q.next;
			q.next = p;
			if(temp == null || temp.next == null){
				p.next = temp;
				break;
			}
			q.next = p;
			p.next = temp.next;
			p = temp;
			
		}
		
		return newListHead;
	}
	
	public static void main(String[] args) {
		SwapNodesPairWiseInLinkedList evenList = new SwapNodesPairWiseInLinkedList();
		
		ListNode evenListHead = null;
		evenListHead = evenList.insert(evenListHead, 1, 0);
		evenList.insert(evenListHead, 2, 1);
		evenList.insert(evenListHead, 3, 2);
		evenList.insert(evenListHead, 4, 3);
		evenList.insert(evenListHead, 5, 4);
		evenList.insert(evenListHead, 6, 5);
		
		System.out.println("Original list before swap :");
		evenList.printList(evenListHead);
		
		ListNode newListHead = evenList.swapNode(evenListHead);
		
		System.out.println("After swapping: ");
		evenList.printList(newListHead);
		
		System.out.println("__________________________");
		System.out.println("Odd original list: ");
		
		SwapNodesPairWiseInLinkedList oddList = new SwapNodesPairWiseInLinkedList();
		
		ListNode oddListHead = null;
		oddListHead = oddList.insert(oddListHead, 1, 0);
		oddList.insert(oddListHead, 2, 1);
		oddList.insert(oddListHead, 3, 2);
		oddList.insert(oddListHead, 4, 3);
		oddList.insert(oddListHead, 5, 4);
		
		oddList.printList(oddListHead);
		
		ListNode newOddListHead = oddList.swapNode(oddListHead);
		System.out.println("After swapping:");
		oddList.printList(newOddListHead);
	}

}
