package problemsOnLinkedList;

import linkedList.ListNode;

public class CheckLinkedListisEvenOrOddWithoutCounting {

	public int length;
	
	public CheckLinkedListisEvenOrOddWithoutCounting() {
		length = 0;
	}
	
	public ListNode insert(ListNode head, int data, int position) {
		ListNode newNode = new ListNode(data);
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		if(head == null){
			newNode.setNext(head);
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
	
	public String checkEvenOrOdd(ListNode head) {
		ListNode currentNode = head;
		while(true) {
			if(currentNode == null)
				return "Even";
			if(currentNode.next == null)
				return "Odd";
			currentNode = currentNode.next.next;
		}
	}
	
	public static void main(String[] args) {
		CheckLinkedListisEvenOrOddWithoutCounting evenList = new CheckLinkedListisEvenOrOddWithoutCounting();
		
		ListNode evenHead = null;
		evenHead = evenList.insert(evenHead, 10, 0);
		evenList.insert(evenHead, 20, 1);
		evenList.insert(evenHead, 30, 2);
		evenList.insert(evenHead, 40, 3);
		evenList.insert(evenHead, 50, 4);
		evenList.insert(evenHead, 60, 5);
		
		System.out.println("EvenList: " + evenList.checkEvenOrOdd(evenHead));
		
		CheckLinkedListisEvenOrOddWithoutCounting oddList = new CheckLinkedListisEvenOrOddWithoutCounting();
		
		ListNode oddHead = null;
		oddHead = oddList.insert(oddHead, 10, 0);
		oddList.insert(oddHead, 20, 1);
		oddList.insert(oddHead, 30, 2);
		oddList.insert(oddHead, 40, 3);
		oddList.insert(oddHead, 50, 4);
		
		System.out.println("OddList: " + oddList.checkEvenOrOdd(oddHead));
	}

}
