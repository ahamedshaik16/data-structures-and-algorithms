package queues;

public class FixedSizeArrayQueue {

	private int[] queueRep;
	private int size, front, rear;
	
	private static final int CAPACITY = 16;
	
	public FixedSizeArrayQueue() {
		queueRep = new int[CAPACITY];
		size = 0; front = 0; rear = 0;
	}
	
	public FixedSizeArrayQueue(int cap) {
		queueRep = new int[cap];
		size = 0; front = 0; rear = 0;
	}
	
	public void enQueue(int data) {
		if(size == CAPACITY)
			throw new IllegalStateException("Queue is full");
		else {
			size++;
			queueRep[rear] = data;
			rear = (rear + 1) % CAPACITY;
		}
	}
	
	public int deQueue() {
		if(size == 0)
			throw new IllegalStateException("Queue is empty");
		else {
			size--;
			int data = queueRep[front % CAPACITY];
			queueRep[front] = Integer.MIN_VALUE;
			front = (front + 1) % CAPACITY;
			return data;
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == CAPACITY);
	}
	
	public int size(){
		return size;
	}

	public void printQueue(){
		for(int i = 0; i < size; i++){
			System.out.print(queueRep[(front + i) % CAPACITY] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		queue.enQueue(70);
		
		System.out.println("Full queue");
		queue.printQueue();
		
		queue.deQueue();
		queue.deQueue();
		System.out.println("After removing, full queue");
		queue.printQueue();
		
		
		
		
	}

}
