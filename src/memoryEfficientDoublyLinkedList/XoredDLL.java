package memoryEfficientDoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class XoredDLL<data> {
	XoredNode start = null;
	XoredNode end = null;
	Map<Integer, XoredNode> pointerMap = new HashMap<>();

	public static void main(String[] args) {
		XoredDLL dll = new XoredDLL();
		dll.add(100);
		dll.add(200);
		dll.add(300);
		dll.add(400);
		dll.add(500);
		dll.add(600);
		dll.add(700);
		dll.add(800);
		dll.add(900);
		dll.printFromStart();
		System.out.println();
		dll.printFromEnd();
	}

	public void add(int i) {
		XoredNode node = new XoredNode(i);
		this.end = node;
		XoredNode currentNode = start;
		int previous = 0;
		if (start == null) {
			start = node;
			pointerMap.put(previous ^ node.hashCode(), start);
			return;
		}
		while (currentNode.next != 0) {
			int current = currentNode.hashCode();
			currentNode = pointerMap.get(previous ^ currentNode.next);
			previous = current;

		}
		currentNode.next = previous ^ node.hashCode();
		pointerMap.put(node.hashCode(), node);
	}

	public void printFromStart() {
		int previous = 0;
		int next = start.hashCode();
		while ((next) != 0) {
			System.out.print(pointerMap.get(next).d + " ");
			// If you verify whether reverse traversal is working,you can
			// comment below i block
			if (pointerMap.get(next).next == 0)
				break;
			int pre = pointerMap.get(next).hashCode();
			next = pointerMap.get(next).next ^ previous;
			previous = pre;
		}
	}
	
	public void printFromEnd() {
//		Address of Next Node = Address of Previous Node ^ pointer in the current Node.
		
//		Address of Previous Node = Address of Next Node ^ pointer in the current Node
		
		int next = 0;
		int previous = end.hashCode();
		while(previous != 0) {
			System.out.println(pointerMap.get(previous).d + " ");
			if(pointerMap.get(previous).next == start.next)
				break;
			int nextHold = pointerMap.get(previous).hashCode();
			previous = pointerMap.get(previous).next ^ nextHold;
			next = nextHold;
		}
	}
}