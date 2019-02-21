package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SumOfElementsInBinaryTreeWithoutRecursion {

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
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
	}
	
	public void postOrder() {
		int sum = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode prev = null;
		List<Integer> result = new ArrayList<>();
		while(!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				if(curr.getLeft() != null)
					stack.push(curr.getLeft());
				else if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else if(curr.getLeft() == prev) {
				if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else {
				result.add((Integer) curr.getData());
				sum = sum + (Integer) curr.getData();
				stack.pop();
			}
			prev = curr;	
		}
		
		for(Integer each: result) {
			System.out.print(each + " ");
		}
		System.out.println();
		System.out.println("Sum from postOrderTraversal: " + sum);
	}
	
	public void addTree() {
		Queue<TreeNode> queue = new LinkedList<>();
		int sum = 0;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			sum = sum + (Integer) currentNode.getData();
			if(currentNode.getLeft() != null) queue.offer(currentNode.getLeft());
			if(currentNode.getRight() != null) queue.offer(currentNode.getRight());
		}
		System.out.println("Sum from other method: " + sum);
	}
	
	public static void main(String args[]) {
		SumOfElementsInBinaryTreeWithoutRecursion tree = new SumOfElementsInBinaryTreeWithoutRecursion();
		tree.createTree();
		System.out.println("Tree: ");
		tree.postOrder();
		tree.addTree();
	}
	
	
	
	
}
