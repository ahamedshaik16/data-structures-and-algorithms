package problemsOnLinkedList;

import linkedList.ListNode;

public class RotateALinkedList {

	public int length;
	
	public RotateALinkedList() {
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
	
	/** traversing list **/
	public void printList(ListNode head){
		ListNode currentNode = head;
		while(currentNode != null){
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	public ListNode rotateList(ListNode head, ListNode rotateAboutNode) {
		ListNode p = head, newHead = null, q;
		while(p != null){
			if(p == rotateAboutNode)
				break;
			p = p.next;
		}
		newHead = p.next;
		q = newHead;
		p.next = null;
		while(q .next != null){
			q = q.next;
		}
		q.next = head;
		return newHead;
	}
	
	public static void main(String args[]) {
		RotateALinkedList list = new RotateALinkedList();
		
		ListNode head = null, rotateAboutNode;
		head = list.insert(head, 10, 0);
		list.insert(head, 20, 1);
		list.insert(head, 30, 2);
		rotateAboutNode = list.insert(head, 40, 3);
		list.insert(head, 50, 4);
		list.insert(head, 60, 5);
		list.insert(head, 70, 6);
		list.insert(head, 80, 7);
		list.insert(head, 90, 8);
		
		System.out.println("Original list: ");
		list.printList(head);
		
		ListNode newHead = list.rotateList(head, rotateAboutNode);
		
		System.out.println("____________");
		System.out.println("Rotated list: ");
		list.printList(newHead);

		
		
	}
}
