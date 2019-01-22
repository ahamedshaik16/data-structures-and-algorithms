package problemsOnLinkedList;

import linkedList.LinkedList;
import linkedList.ListNode;

public class NthNode {

	private int length = 0;
	static ListNode head;
	
	public NthNode() {
		length = 0;
	}
	
	public void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	public void insertAtEnd(ListNode node) {
		if(head == null)
			head = node;
		else {
			ListNode p, q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length++;
	}
	
	public void insert(int data, int position){
		if(position < 0)
			position = 0;
		else if(position > length)
			position = length;
		if(head == null){
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		} else {
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
	public static void printList() {
		int length = 0;
		ListNode currentNode = head;
		while(currentNode != null) {
			length++;
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public int size() {
		return length++;
	}
	
	public int returnNthNodeFromStart(int nthNode){
		ListNode temp = head;
		for(int i = 1; i < nthNode; i++){
			temp = temp.getNext();
		}
		
		return temp.getData();
	}
	
    public static ListNode nthNodeFromEndIterative(int Nth) {
    	if(head == null){
            return null;
        }
        ListNode nth = head;
        // Get nth from the start
        for (int i = 0; i < Nth; i++) {
            if(nth.next == null){
                return null;
            }
            nth = nth.next;
        }
        // Move both the head and nth node so the difference between them is n
        // Thus we get the nth node from the end
        while(nth != null){
            head = head.next;
            nth = nth.next;
        }
        return head;
    }
	
	public static void main(String args[]) throws Exception {
		NthNode list = new NthNode();
		list.insertAtBegin(new ListNode(10));
		list.insert(20, 1);
		list.insert(30, 2);
		list.insert(40, 3);
		list.insert(50, 4);
		list.insert(60, 5);
		list.insert(70, 6);
		list.insert(80, 7);
		list.insert(90, 8);
		list.insertAtEnd(new ListNode(100));
		printList();
		System.out.println("Size: " + list.size());
		int nthNode = 0;
		if(nthNode > list.size()){
			throw new Exception("size is " + list.size());
		} else {
			System.out.println("Nth Node " +  nthNodeFromEndIterative(nthNode));
		}
	}
}
