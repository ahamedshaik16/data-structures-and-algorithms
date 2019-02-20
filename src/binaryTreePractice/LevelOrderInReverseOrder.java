package binaryTreePractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderInReverseOrder {

	public static BinaryTreeNode root;
	
	public void createTree() {
		BinaryTreeNode one = new BinaryTreeNode(10);
		BinaryTreeNode two = new BinaryTreeNode(20);
		BinaryTreeNode three = new BinaryTreeNode(30);
		BinaryTreeNode four = new BinaryTreeNode(40);
		BinaryTreeNode five = new BinaryTreeNode(50);
		BinaryTreeNode six = new BinaryTreeNode(60);
		BinaryTreeNode seven = new BinaryTreeNode(70);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public void levelOrderTraversal() {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Stack<Integer> stack = new Stack<>();
		System.out.println("Original Level Order: ");
		
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			System.out.print(temp.getData() + " ");
			stack.push(temp.getData());
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		
		System.out.println("Reverse Order: ");
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
	
	public static void main(String args[]) {
		LevelOrderInReverseOrder tree = new LevelOrderInReverseOrder();
		tree.createTree();
		tree.levelOrderTraversal();
	}
	
	
	
}
