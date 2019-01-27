package problemsOnLinkedList;

import linkedList.ListNode;

public class CheckLinkedListPalindrome {

	private int length;
	private static ListNode head, start_second;
	
	public CheckLinkedListPalindrome(){
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
		} else{
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
	
	/** Traversing the list **/
	public static void printList(ListNode head) {
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public boolean checkPalindrome(ListNode listHead) {
		ListNode p = listHead, q = listHead;
		while(true) {
			p = p.next.next;
			if(p != null && p.getNext() == null){
				start_second = q.next.next;
				break;
			} else if(p == null) {
				start_second = q.next;
				break;
			}
			q = q.next;
		}
		q.next = null;
		ListNode reverseStartNode = reverseRecursively(start_second);
		System.out.println();
		System.out.println("Starting hald linked list: " );
		printList(listHead);
		
		System.out.println();
		System.out.println("Reversed half linked list ");
		printList(reverseStartNode);
		
		return areIdentical(listHead, reverseStartNode);
	}
	
//	private static ListNode reverseRecursively(ListNode head) {
//		ListNode p, q;
//		p = head;
//		if(p.next == null)
//			return p;
//		
//		q = p.next;
//		
//		q = reverseRecursively(q);
//		p.next.next = p;
//		p.next = null;
//		
//		return q;		
//	}
	
	private ListNode reverseRecursively(ListNode node){
		ListNode newHead;
	     
	       //base case - tail of original linked list
	       if((node.next == null)){
	           return node;
	       }
	       newHead = reverseRecursively(node.next);
	     
	       //reverse the link e.g. C->D->null will be null       
	       node.next.next = node;
	       node.next = null;    
	       return newHead;
	    }
	
	public static boolean areIdentical(ListNode firstListNode, ListNode secondListNode) {
		while((firstListNode != null) && (secondListNode != null)) {
			if(firstListNode.getData() != secondListNode.getData())
				return false;
			firstListNode = firstListNode.next;
			secondListNode = secondListNode.next;
		}
		
		return ((firstListNode == null) && (secondListNode == null));
	}
	
	public static void main(String[] args) {
		/** Check even palindrome **/
		
		CheckLinkedListPalindrome cList = new CheckLinkedListPalindrome();
		ListNode cListHead = null;
		cListHead = cList.insert(cListHead, 10, 0);
		cList.insert(cListHead, 20, 1);
		cList.insert(cListHead, 30, 2);
		cList.insert(cListHead, 40, 3);
		cList.insert(cListHead, 50, 4);
		cList.insert(cListHead, 50, 5);
		cList.insert(cListHead, 40, 6);
		cList.insert(cListHead,  30, 7);
		cList.insert(cListHead, 20, 8);
		cList.insert(cListHead, 10, 9);
//		cList.insert(cListHead, 100, 10);
		
		
		
		
		System.out.println("Original Linked List ");
		printList(cListHead);
		
//		ListNode reverse = cList.reverseRecursively(cListHead);
//		
//		System.out.println("Reverse linked list: ");
//		printList(reverse);
		
		System.out.println(cList.checkPalindrome(cListHead));
		

		/** Check Odd Palindrome **/
		System.out.println();
		System.out.println("Odd Palindrome ");
		CheckLinkedListPalindrome oddList = new CheckLinkedListPalindrome();
		ListNode oddListHead = null;
		oddListHead = oddList.insert(oddListHead, 10, 0);
		oddList.insert(oddListHead, 20, 1);
		oddList.insert(oddListHead, 30, 2);
		oddList.insert(oddListHead, 40, 3);
		oddList.insert(oddListHead, 50, 4);
		oddList.insert(oddListHead, 100, 5);
		oddList.insert(oddListHead, 50, 6);
		oddList.insert(oddListHead, 40, 7);
		oddList.insert(oddListHead, 30, 8);
		oddList.insert(oddListHead, 20, 9);
		oddList.insert(oddListHead, 10, 10);
		
		System.out.println("Original odd Linked List ");
		printList(oddListHead);
		
		System.out.println(oddList.checkPalindrome(oddListHead));
		
		
	}

}
