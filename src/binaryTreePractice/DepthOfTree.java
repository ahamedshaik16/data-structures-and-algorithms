package binaryTreePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthOfTree {

	public static BinaryTreeNode root;
	
	public void createTree() {
		BinaryTreeNode one = new BinaryTreeNode(10);
		BinaryTreeNode two = new BinaryTreeNode(20);
		BinaryTreeNode three = new BinaryTreeNode(30);
		BinaryTreeNode four = new BinaryTreeNode(40);
		BinaryTreeNode five = new BinaryTreeNode(50);
		BinaryTreeNode six = new BinaryTreeNode(60);
		BinaryTreeNode seven = new BinaryTreeNode(70);
		BinaryTreeNode eight = new BinaryTreeNode(80);

		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setLeft(seven);
		
		seven.setLeft(eight);
	}
	
	public void preOrderTraversal() {
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode temp = stack.pop();
			System.out.print(temp.getData() + " ");
			if(temp.getRight() != null)
				stack.push(temp.getRight());
			if(temp.getLeft() != null)
				stack.push(temp.getLeft());
		}
		
		
	}
	
	public int maxDepth(BinaryTreeNode currentNode) {
		if(currentNode == null)
			return 0;
		int leftDepth = maxDepth(currentNode.getLeft());
		int rightDepth = maxDepth(currentNode.getRight());
		return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
	}
	
	public static void main(String args[]) {
		DepthOfTree tree = new DepthOfTree();
		
		tree.createTree();
		System.out.println("Tree: ");
		tree.preOrderTraversal();
		System.out.println();
		System.out.println("Max Depth: " + tree.maxDepth(root));
		
	}
}
