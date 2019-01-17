package queues;

import linkedList.ListNode;

public class LinkedQueue {

	private int length;
	private ListNode front, rear;
	
	public LinkedQueue(){
		length = 0;
		front = rear= null;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public void enQueue(int data) {
		ListNode node = new ListNode(data);
		if(isEmpty())
			front = node;
		else
			rear.setNext(node);
		rear = node;
		length++;
	}
	
	public int deQueue() throws Exception {
		if(isEmpty())
			throw new Exception("Empty queue");
		int result = front.getData();
		front = front.getNext();
		length--;
		if(isEmpty())
			rear = null;
		return result;
	}
	
	public int first() throws Exception{
		if(isEmpty())
			throw new Exception("Empty queue");
		return front.getData();
	}
	
	public int size() {
		return length;
	}
	
	public void printStack() {
		ListNode currentNode = front;
		while(currentNode != null){
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public static void main(String args[]) throws Exception {
		LinkedQueue queue = new LinkedQueue();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		
		System.out.println("Print Queue ");
		queue.printStack();
		System.out.println("queue size : " + queue.size());
		System.out.println("Remove");
		queue.deQueue();
		queue.deQueue();
		System.out.println("Print queue ");
		queue.printStack();
		
		System.out.println("queue size : " + queue.size());
	}
}
