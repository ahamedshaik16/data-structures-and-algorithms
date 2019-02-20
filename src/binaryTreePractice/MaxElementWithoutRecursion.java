package binaryTreePractice;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElementWithoutRecursion {

	public static BinaryTreeNode root;
	
	public void createBinaryTree() {
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
	
	public int maxElement(BinaryTreeNode currentNode) {
		int max = 0;
		if(currentNode == null)
			return max;
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(currentNode);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if(temp.getData() >  max)
				max = temp.getData();
			if(temp != null){
				if(temp.getLeft() != null)
					queue.offer(temp.getLeft());
				if(temp.getRight() != null)
					queue.offer(temp.getRight());
			}
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		MaxElementWithoutRecursion tree = new MaxElementWithoutRecursion();
		tree.createBinaryTree();
		System.out.println("Max Element: " + tree.maxElement(root));
	}
	
	
	
	
	
	
	
}
