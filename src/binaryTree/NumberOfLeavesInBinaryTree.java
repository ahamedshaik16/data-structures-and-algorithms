package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NumberOfLeavesInBinaryTree {

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
	
	public void postOrderTraversal() {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		List<Integer> result = new ArrayList<>();
		TreeNode prev = null;
		while(!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				if(curr.getLeft() != null) 
					stack.push(curr.getLeft());
				else if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else if(curr.getLeft() == prev){
				if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else {
				result.add((Integer) curr.getData());
				stack.pop();
			}
			prev = curr;
		}
		for(Integer each: result)
			System.out.print(each + " ");
	}
	
	public int numberofLeaves() {
		int count = 0;
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp.getLeft() == null && temp.getRight() == null) 
				count++;
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		return count;
	}
	
	public static void main(String args[]) {
		NumberOfLeavesInBinaryTree tree = new NumberOfLeavesInBinaryTree();
		tree.createTree();
		System.out.println("Tree: ");
		tree.postOrderTraversal();
		System.out.println();
		System.out.println("Number of leaves: " + tree.numberofLeaves());
	}
	
	
	
	
	
	
}
