package problemsOnLinkedList;

import linkedList.ListNode;

public class AddTwoNumbersLinkedList {

	/** 
	 1. Find Length of first number L1;
	 2. Find length of second number L2;
	 3. Difference of two number L1 - L2;
	 4. If there is a diff then add zeros(0) in the beginning of that number
	 5. Addition, then divide addition by 10, if it is greater than 0 then update remainder and carry also.
	 6. If addition divided by 10 ( (add / 10) > 0 ) then create new Linked list's node with remainder and update carry, 
	    otherwise create new node with with addition.
	    
	    When addition divided by 10 is not equal to zero newNode = Remainder
	    When addition divided by 10 is equal to zero newNode = addition
	    
	 7. At the end if there is a carry then in the new linked list add that carry at the end. 
	  
	  
	 
	 */
	
	public int length;
	
	public AddTwoNumbersLinkedList(){
		length = 0;
	}
	
	public ListNode insertAtBegin(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		newNode.setNext(head);
		head = newNode;
		length++;
		
		return head;
	}
	
	public void insertAtEnd(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			head = newNode;
		} else {
			ListNode p, q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(newNode);
		}
		length++;
	}
	
	public void printList(ListNode head){
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData());
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public int size(){
		return length;
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode p, q;
		p = head;
		if(p.next == null)
			return p;
		q = p.next;
		
		q = reverseList(q);
		
		p.next.next = p;
		p.next = null;
		
		return q;
	}
	
	public ListNode addTwoNumber(ListNode reverseFirstNumHead, ListNode reverseSecondNumHead) {
		AddTwoNumbersLinkedList addedNumber = new AddTwoNumbersLinkedList();
		ListNode newNumHead = null;
		ListNode firstNumHead = reverseFirstNumHead, secondNumHead = reverseSecondNumHead;
		int remainder = 0, carry = 0;
		while(firstNumHead != null && secondNumHead != null) {
			int addition = firstNumHead.getData() + secondNumHead.getData();
			/** addition has to be divided by 10 **/
		/** When addition divided by 10 is not equal to zero newNode = Remainder
		    When addition divided by 10 is equal to zero newNode = addition		
		    	    
		   **/
			int quotient = addition / 10;
			
			if(newNumHead == null) {
				if(quotient > 0 ){
					newNumHead = addedNumber.insertAtBegin(newNumHead, remainder);
				} else {
					newNumHead = addedNumber.insertAtBegin(newNumHead, addition);
				}
			} else {
				if(quotient > 0) {
					remainder = (addition + carry) % 10;
					addedNumber.insertAtEnd(newNumHead, remainder);
				} else {
					addition = addition + carry;
					addedNumber.insertAtEnd(newNumHead, addition);
				}
			}
			if(quotient > 0 ){
				remainder = addition % 10;
				carry = quotient;
			} else {
				remainder = 0;
				carry = 0;
			}
			firstNumHead = firstNumHead.getNext();
			secondNumHead = secondNumHead.getNext();
		}
		if(carry > 0) {
			addedNumber.insertAtEnd(newNumHead, carry);
		}
		
		return newNumHead;
	}
	
	public static void main(String[] args) {
		
		/** Make first Number **/
		AddTwoNumbersLinkedList firstNumber = new AddTwoNumbersLinkedList();
		
		ListNode firtNumHead = null;
		
		firtNumHead = firstNumber.insertAtBegin(firtNumHead, 1);
		firstNumber.insertAtEnd(firtNumHead, 2);
		firstNumber.insertAtEnd(firtNumHead, 3);
		firstNumber.insertAtEnd(firtNumHead, 4);
		firstNumber.insertAtEnd(firtNumHead, 5);
		
		System.out.print("First Number: ");
		firstNumber.printList(firtNumHead);
		System.out.println("size :" + firstNumber.size());
		
		/** Make second Number **/
		AddTwoNumbersLinkedList secondNumber = new AddTwoNumbersLinkedList();
		
		ListNode secondNumHead = null;
		
		secondNumHead = secondNumber.insertAtBegin(secondNumHead, 9);
		secondNumber.insertAtEnd(secondNumHead, 0);
		secondNumber.insertAtEnd(secondNumHead, 9);
		secondNumber.insertAtEnd(secondNumHead, 6);
		secondNumber.insertAtEnd(secondNumHead, 3);
		
		System.out.print("Second Number: ");
		secondNumber.printList(secondNumHead);
		System.out.println("size :" + secondNumber.size());
		
		int difference = 0;
		if(firstNumber.size() < secondNumber.size()){
			difference = secondNumber.size() - firstNumber.size();
			for(int i = 0; i < difference; i++) {
				firtNumHead = firstNumber.insertAtBegin(firtNumHead, 0);
			}
		} else if(firstNumber.size() > secondNumber.size()){
			difference = firstNumber.size() - secondNumber.size();
			for(int i = 0; i < difference; i++) {
				secondNumHead = secondNumber.insertAtBegin(secondNumHead, 0);
			}
		}
		
		System.out.println();
		System.out.println("_______________________________________");
		System.out.println("After making numbers of same length ");
		
		System.out.print("First Number: ");
		firstNumber.printList(firtNumHead);
		System.out.println("size :" + firstNumber.size());
		
		System.out.print("Second Number: ");
		secondNumber.printList(secondNumHead);
		System.out.println("size :" + secondNumber.size());
		
		ListNode reverseFirstNumHead = firstNumber.reverseList(firtNumHead);
		ListNode reverseSecondNumHead = secondNumber.reverseList(secondNumHead);
		
		System.out.println();
		System.out.println("_________________________");
		System.out.println("After Reversing");
		
		System.out.print("First Number :");
		firstNumber.printList(reverseFirstNumHead);

		System.out.print("Second Number :");
		secondNumber.printList(reverseSecondNumHead);
		
		
		/** Make added Number **/
		AddTwoNumbersLinkedList addedNumberList = new AddTwoNumbersLinkedList();
		ListNode addedNumberHead = addedNumberList.addTwoNumber(reverseFirstNumHead, reverseSecondNumHead);
		System.out.println();
		System.out.println("__________________________");
		System.out.println("Added number in reverse");
		addedNumberList.printList(addedNumberHead);
		
		
	}

}
