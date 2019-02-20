package binaryTreePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InsertAnElement {

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
	
	public void postOrderTraversal(){
		List<Integer> result = new ArrayList<>();
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		BinaryTreeNode prev = null;
		while(!stack.isEmpty()) {
			BinaryTreeNode curr = stack.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				if(curr.getLeft() != null)
					stack.push(curr.getLeft());
				else if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else if(curr.getLeft() == prev) {
				if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else {
				result.add(curr.getData());
				stack.pop();
			}
			prev = curr;
		}
		
		for(Integer each: result) {
			System.out.print(each + " ");
		}
		System.out.println();
	}
	
	public BinaryTreeNode insertElement(int data) {
		if(root == null)
			root = new BinaryTreeNode(data);
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			else{
				temp.setLeft(new BinaryTreeNode(data));
				return root;
			}
			if(temp.getRight() != null) {
				queue.offer(temp.getRight());
			} else {
				temp.setRight(new BinaryTreeNode(data));
				return root;
			}
		}
		
		return root;
	}
	
	
	public static void main(String args[]) {
		InsertAnElement tree = new InsertAnElement();
		tree.createTree();
		System.out.println("Tree before insertion: ");
		tree.postOrderTraversal();
		tree.insertElement(80);
		System.out.println("Tree after insertion");
		tree.postOrderTraversal();
	}
	
	
	
	
	
	
	
	
	
}
