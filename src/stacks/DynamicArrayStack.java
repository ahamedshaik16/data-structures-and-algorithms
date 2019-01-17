package stacks;

public class DynamicArrayStack {

	protected int capacity;
	
	public static final int CAPACITY = 16;
	
	public static int MINCAPACITY = 1<<15;
	
	protected int[] stackRep;
	
	protected int top = -1;
	
	public DynamicArrayStack() {
		this(CAPACITY);
	}
	
	public DynamicArrayStack(int cap) {
		capacity = cap;
		stackRep = new int[capacity];
	}
	
	public int size() {
		return (top + 1);
	}
	
	public boolean isEmpty(){
		return (top < 0);
	}
	
	public void push(int data) throws Exception {
		if(size() == capacity)
			expand();
		stackRep[++top] = data;
	}
	
	private void expand() {
		int length = size();
		int[] newStack = new int[length<<1];
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep = newStack;
	}
	
	private void shrink() throws Exception{
		int length = top + 1;
		if(length<=MINCAPACITY || top<<2 >= length)
			return;
		length = length + (top<<1);
		if(top<MINCAPACITY) length = MINCAPACITY;
		int[] newStack = new int[length];
		System.arraycopy(stackRep, 0, newStack, 0, top + 1);
		stackRep = newStack;
		capacity = length;
		
	}
	
	public int top() throws Exception{
		if(isEmpty()) 
			throw new Exception("Stack is empty");
		return stackRep[top];
	}
	
	public int pop() throws Exception{
		int data;
		if(isEmpty())
			throw new Exception("Stack is empty");
		data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		shrink();
		return data;
	}
	
	public void printStack(){
		for(int i = 0; i < size(); i++){
			System.out.print(stackRep[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {

		DynamicArrayStack stack = new DynamicArrayStack();
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
