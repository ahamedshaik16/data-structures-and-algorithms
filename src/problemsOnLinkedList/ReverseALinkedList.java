package problemsOnLinkedList;

import linkedList.ListNode;

public class ReverseALinkedList {

	private int length;
	private static ListNode head;
	
	public ReverseALinkedList(){
		length = 0;
	}
	
	public void insert(int data, int position) {
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		if(head == null){
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		} else{
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
	public static void printList(ListNode head) {
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public ListNode reverse(ListNode head) {
		ListNode p, q;
		p = head;
		if (p.next == null){
			return p;
		}
		
		q = p.next;
		
		q = reverse(q);
		
		p.next.next = p;
		p.next =  null;
		
		return q;
	}
	
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
	
	public static void main(String args[]){
		ReverseALinkedList cList = new ReverseALinkedList();
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
		
		printList(head);
		
		ListNode reverse = cList.reverse(head);
		
		printList(reverse);
	}
}
