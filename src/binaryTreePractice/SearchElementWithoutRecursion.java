package binaryTreePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SearchElementWithoutRecursion {

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
	
	public void preOrderTraversalWithoutRecursion() {
		List<Integer> result = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		if(root != null) 
			stack.push(root);
		while(!stack.isEmpty()) {
			BinaryTreeNode temp = stack.pop();
			System.out.print(temp.getData() + " ");
			if(temp != null) {
				if(temp.getRight() != null)
					stack.push(temp.getRight());
				if(temp.getLeft() != null)
					stack.push(temp.getLeft());
			}
		}
		
	}
	
	public boolean searchElement(int data) {
		if(root == null)
			return false;
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if(temp.getData() == data)
				return true;
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		
		return false;
	}
	
	
	public static void main(String args[]) {
		SearchElementWithoutRecursion tree = new SearchElementWithoutRecursion();
		tree.createTree();
		tree.preOrderTraversalWithoutRecursion();
		System.out.println();
		System.out.println("70 Exists: " + tree.searchElement(70) );
		System.out.println("90 Exists: " + tree.searchElement(90));
	}
	
	
	
	
	
	
	
	
	
}
