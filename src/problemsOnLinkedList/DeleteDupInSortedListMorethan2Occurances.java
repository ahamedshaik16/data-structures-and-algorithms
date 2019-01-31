package problemsOnLinkedList;

import linkedList.ListNode;

public class DeleteDupInSortedListMorethan2Occurances {

	public int length;
	
	public DeleteDupInSortedListMorethan2Occurances(){
		length = 0;
	}
	
	public ListNode insert(ListNode head, int data, int position) {
		ListNode newNode = new ListNode(data);
		if(position<0)
			position = 0;
		else if(position > length)
			position = length;
		if(head == null) {
			newNode.setNext(head);
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
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public ListNode deleteDuplicates(ListNode head){
		ListNode p = head, q;
		while((p != null) && (p.next != null)){
			if(p.getData() == p.getNext().getData()){
				q = p.next.next;
				if(q == null){
					p.next = null;
					break;
				}
				
				p.next = q;
			}
			if(p.getData() != p.next.getData())
				p = p.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		DeleteDupInSortedListMorethan2Occurances list1 = new DeleteDupInSortedListMorethan2Occurances();
		ListNode list1Head = null;
		list1Head = list1.insert(list1Head, 10, 0);
		list1.insert(list1Head, 20, 1);
		list1.insert(list1Head, 30, 2);
		list1.insert(list1Head, 30, 3);
		list1.insert(list1Head, 30, 4);
		list1.insert(list1Head, 40, 5);
		list1.insert(list1Head, 40, 6);
		list1.insert(list1Head, 50, 7);
		list1.insert(list1Head, 50, 8);
		
		System.out.println("Original list: ");
		list1.printList(list1Head);
		
		list1.deleteDuplicates(list1Head);
		
		System.out.println("After Removing ");
		list1.printList(list1Head);
		
	}

}
