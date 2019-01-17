package stacks;

public class FixedSizeArrayStack {

	protected int capacity;
	protected static final int CAPACITY = 10;
	protected int[] stackRep;
	protected int top = -1;
	
	public FixedSizeArrayStack() {
		this(CAPACITY);
	}

	public FixedSizeArrayStack(int cap) {
		capacity = cap;
		stackRep = new int[capacity];
	}
	
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public int size() {
		return (top + 1);
	}
	
	public void push(int data) throws Exception{
		if(size() == capacity)
			throw new Exception("Stack is full");
		stackRep[++top] = data;
	}
	
	public int top() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty");
		return stackRep[top];
	}
	
	public int pop() throws Exception {
		int data;
		if(isEmpty())
			throw new Exception("Stack is empty");
		data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		return data;
	}
	
	public void printStack(){
		for(int i = 0; i < size(); i++){
			System.out.print(stackRep[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) throws Exception{
		FixedSizeArrayStack stack = new FixedSizeArrayStack();
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
