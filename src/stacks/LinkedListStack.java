package stacks;

import linkedList.ListNode;

public class LinkedListStack {

	private int length;
	private ListNode top;
	
	private LinkedListStack() {
		length = 0;
		top = null;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int size() {
		return length;
	}
	
	public void push(int data) {
		ListNode tempNode = new ListNode(data);
		tempNode.setNext(top);
		top = tempNode;
		length++;
	}
	
	public int pop() throws Exception{
		if(isEmpty())
			throw new Exception("Stack is empty");
		int result = top.getData();
		top = top.getNext();
		length--;
		return result;
	}
	
	public int peek() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty");
		return top.getData();
	}
	
	public void printStack() {
		ListNode currentNode = top;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public static void main(String args[]) throws Exception {

		LinkedListStack stack = new LinkedListStack();
		System.out.println("Stack size : " + stack.size());
		System.out.println("Is stack empty : " + stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		System.out.println("Print Stack ");
		stack.printStack();
		System.out.println("Stack size : " + stack.size());
		System.out.println("Remove");
		stack.pop();
		stack.pop();
		System.out.println("Print Stack ");
		stack.printStack();
		
		System.out.println("Stack size : " + stack.size());
	}
}
