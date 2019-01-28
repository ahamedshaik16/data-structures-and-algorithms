package problemsOnLinkedList;

import java.util.HashMap;

import linkedList.ListNode;

public class DeleteDupInUnsortedLinkedList {

	public int length;
	public static ListNode head;
	
	public DeleteDupInUnsortedLinkedList(){
		length = 0;
	}
	
	public void insert(int data, int position){
		ListNode newNode = new ListNode(data);
		if(position < 0)
			position = 0;
		else if(position > length )
			position = length;
		if(head == null) {
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
	}
	
	
	/** Traversing the list **/
	public static void printList() {
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public int size() {
		return length++;
	}
	
	public void removeDupNSquare() {
		if(head == null)
			return;
		ListNode currentNode = head;       
		while(currentNode!=null){
		    ListNode runner = currentNode;
		    while(runner.next!=null){
		        if(runner.next.data == currentNode.data)
		            runner.next = runner.next.next;
		        else
		            runner = runner.next;
		    }
		    currentNode = currentNode.next;
		}
	}
	
	public void removeDupNtimes(){
		HashMap<Integer, Integer> noDup = new HashMap<>();
		ListNode currentNode = head, previousNode = null;
		while(currentNode != null) {
			if(noDup.containsKey(currentNode.getData())){
				previousNode.next = currentNode.next;
			} else {
				noDup.put(currentNode.getData(), 1);
				previousNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		
		
	}
	
	public static void main(String[] args) {
		DeleteDupInUnsortedLinkedList list = new DeleteDupInUnsortedLinkedList();
		list.insert(10, 0);
		list.insert(20, 1);
		list.insert(30, 2);
		list.insert(40, 3);
		list.insert(40, 4);
		list.insert(40, 5);
		list.insert(70, 6);
		list.insert(70, 7);
		list.insert(90, 8);
		list.insert(90, 9);
		list.insert(90, 10);
		
		System.out.println("Original Linked list: ");
		list.printList();
		
		list.removeDupNSquare();
		
		System.out.println("After removing duplicates: ");
		list.printList();
		
		
	}

}
