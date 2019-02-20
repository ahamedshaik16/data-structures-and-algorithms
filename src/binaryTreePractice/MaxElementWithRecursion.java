package binaryTreePractice;

import binaryTree.MaxElementInBinaryTreeWithRecursion.TreeNode;

public class MaxElementWithRecursion {

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
	
	public int maxElement(BinaryTreeNode currentNode) {
		int max = 0;
		if(currentNode != null){
			int leftMax = maxElement(currentNode.getLeft());
			int rightMax = maxElement(currentNode.getRight());
			if(leftMax > rightMax)
				max = leftMax;
			else 
				max = rightMax;
			if(currentNode.getData() > max)
				max = currentNode.getData();
		}
		return max;
	}
	
	
	public static void main(String args[]) {
		MaxElementWithRecursion tree = new MaxElementWithRecursion();
		
		tree.createTree();
		System.out.println("Max element: " + tree.maxElement(root));
	}
}
