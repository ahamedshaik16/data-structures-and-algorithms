package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderDataInReverseOrder {

	public static TreeNode root;
	
	public void createBinaryTree(){
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		TreeNode five = new TreeNode(50);
		TreeNode six = new TreeNode(60);
		TreeNode seven = new TreeNode(70);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public <T> ArrayList<T> levelOrder(TreeNode root) {
		ArrayList<T> res = new ArrayList<>();
		
		if(root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp != null) {
				res.add((T) temp.getData());
				if(temp.getLeft() != null)
					queue.offer(temp.getLeft());
				if(temp.getRight() != null)
					queue.offer(temp.getRight());
			}
				
		}
		return res;
		
	}
	
	public <T> ArrayList<T> levelOrderReverse(TreeNode root) {
		ArrayList<T> res = new ArrayList<>();
		
		if(root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		Stack<TreeNode> stack = new Stack();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp != null) {
				stack.push(temp);
				res.add((T) temp.getData());
				if(temp.getLeft() != null)
					queue.offer(temp.getLeft());
				if(temp.getRight() != null)
					queue.offer(temp.getRight());
			}
				
		} 
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.print(temp.getData()+ " ");
		}
		
		return res;
		
	}
	
	
	
	public static void main(String[] args) {
		LevelOrderDataInReverseOrder tree = new LevelOrderDataInReverseOrder();
		
		tree.createBinaryTree();
		ArrayList<Integer> list = tree.levelOrder(root);
		System.out.println("Original tree ");
		for(Integer i : list) 
			System.out.print(i+ " ");
		System.out.println();
		System.out.println("Reverse tree ");
		tree.levelOrderReverse(root);
		
	}

}
