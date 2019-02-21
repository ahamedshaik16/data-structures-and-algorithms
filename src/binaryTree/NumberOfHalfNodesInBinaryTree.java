package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfHalfNodesInBinaryTree {

	public static TreeNode root;
	
	public void createTree() {
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		TreeNode five = new TreeNode(50);
		TreeNode six = new TreeNode(60);
		TreeNode seven = new TreeNode(70);
		TreeNode eight = new TreeNode(80);
		TreeNode nine = new TreeNode(90);
		
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
		
		eight.setRight(nine);
	}
	
	public void preOrderTraversal() {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.getData() + " ");
			if(temp.getRight() != null)
				stack.push(temp.getRight());
			if(temp.getLeft() != null)
				stack.push(temp.getLeft());
		}
		System.out.println();
	}
	
	public int numberOfHalfNodes(){
		int count = 0;
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if((temp.getLeft() == null && temp.getRight() != null) || (temp.getLeft() != null && temp.getRight() == null))
				count++;
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		
		return count;		
	}
	
	public static void main(String args[]) {
		NumberOfHalfNodesInBinaryTree tree = new NumberOfHalfNodesInBinaryTree();
		tree.createTree();
		System.out.println("Tree: ");
		tree.preOrderTraversal();
		System.out.println("Number of half nodes: " + tree.numberOfHalfNodes());
	}
}
