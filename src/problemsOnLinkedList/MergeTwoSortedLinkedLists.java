package problemsOnLinkedList;

import linkedList.ListNode;

public class MergeTwoSortedLinkedLists {

	private int length;
	private static ListNode firstLinkHead;
	private static ListNode secondLinkHead;
	
	public MergeTwoSortedLinkedLists(){
		length = 0;
	}
	
	public void insertFirstLink(int data, int position){
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		if(firstLinkHead == null){
			ListNode temp = new ListNode(data);
			temp.next = firstLinkHead;
			firstLinkHead = temp;
		}else {
			ListNode temp = firstLinkHead;
			for(int i = 1; i < position; i++){
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		
		length++;
	}
	
	public void insertSecondLink(int data, int position){
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		if(secondLinkHead == null){
			ListNode temp = new ListNode(data);
			temp.next = secondLinkHead;
			secondLinkHead = temp;
		}else {
			ListNode temp = secondLinkHead;
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
	public static void printList(ListNode head) {
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public static ListNode mergeList(ListNode firstLinkHead, ListNode secondLinkHead, ListNode sortingListNode) {
		ListNode newNodeHead = null;
		if(firstLinkHead == null) return secondLinkHead;
		if (secondLinkHead == null) return firstLinkHead;
		if(firstLinkHead != null && secondLinkHead != null){
			if(firstLinkHead.getData() <= secondLinkHead.getData()){
				sortingListNode = firstLinkHead;
				firstLinkHead = sortingListNode.next;
			} else {
				sortingListNode = secondLinkHead;
				secondLinkHead = sortingListNode.next;
			}
		}
		newNodeHead = sortingListNode;
		while(firstLinkHead != null && secondLinkHead != null){
			if(firstLinkHead.getData() <= secondLinkHead.getData()){
				sortingListNode.next = firstLinkHead;
				sortingListNode = firstLinkHead;
				firstLinkHead = sortingListNode.next;
			} else {
				sortingListNode.next = secondLinkHead;
				sortingListNode = secondLinkHead;
				secondLinkHead = sortingListNode.next;
			}
		}
			if (firstLinkHead == null) sortingListNode.next = secondLinkHead;
			if (secondLinkHead == null) sortingListNode.next = firstLinkHead;
		
		
		
		return newNodeHead;
	}
	
	public static void main(String[] args) {

		MergeTwoSortedLinkedLists firstLink = new MergeTwoSortedLinkedLists();
		firstLink.insertFirstLink(10, 0);
		firstLink.insertFirstLink(50, 1);
		firstLink.insertFirstLink(70, 2);
		firstLink.insertFirstLink(90, 3);
		firstLink.insertFirstLink(100, 4);
		
		System.out.println("First sorted link: ");
		printList(firstLink.firstLinkHead);
		
		MergeTwoSortedLinkedLists secondLink = new MergeTwoSortedLinkedLists();
		secondLink.insertSecondLink(20, 0);
		secondLink.insertSecondLink(30, 1);
		secondLink.insertSecondLink(40, 2);
		secondLink.insertSecondLink(60, 3);
		secondLink.insertSecondLink(80, 4);
		
		System.out.println("Second sorted link: ");
		printList(secondLinkHead);
		
		System.out.println("Merged list: ");
		ListNode sortingListNode = null;
		printList(mergeList(firstLinkHead, secondLinkHead, sortingListNode));
	}

}
