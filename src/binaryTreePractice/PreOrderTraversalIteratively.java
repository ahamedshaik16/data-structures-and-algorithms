package binaryTreePractice;

import java.util.Stack;

public class PreOrderTraversalIteratively {

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
	
	public <T> void preOrderTravaesal(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			BinaryTreeNode currentNode = stack.pop();
			System.out.print(currentNode.getData() + " ");
			if(currentNode.getRight() != null)
				stack.push(currentNode.getRight());
			if(currentNode.getLeft() != null)
				stack.push(currentNode.getLeft());
		}
	}
	
	
	public static void main(String args[]) {
		PreOrderTraversalIteratively tree = new PreOrderTraversalIteratively();
		
		tree.createBinaryTree();
		tree.preOrderTravaesal(root);
	}
	
}
