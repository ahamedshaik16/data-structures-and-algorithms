package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import binaryTree.InsertAnElementinBinaryTreeIteravtively.TreeNode;

public class SearchAnElementInBinaryTreeWithOutRecursion {

	public static TreeNode root;
	
	public class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		public TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}
	
	public void createBinaryNode(){
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		TreeNode five = new TreeNode(50);
		TreeNode six = new TreeNode(160);
		TreeNode seven = new TreeNode(70);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public boolean searchElement(int data) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp != null && temp.getData() == data)
				return true;
			if(temp != null){
				if(temp.getLeft() != null)
					queue.offer(temp.getLeft());
				if(temp.getRight() != null)
					queue.offer(temp.getRight());
			}
		}
		return false;
	}
	
	public ArrayList<Integer> preOrderIteratively() {
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			res.add(temp.getData());
			
			if(temp.getRight() != null)
				stack.push(temp.getRight());
			if(temp.getLeft() != null)
				stack.push(temp.getLeft());
		}
		return res;		
	} 
	
	public static void main(String[] args) {
		SearchAnElementInBinaryTreeWithOutRecursion tree = new SearchAnElementInBinaryTreeWithOutRecursion();
		
		tree.createBinaryNode();
		
		ArrayList<Integer> list = tree.preOrderIteratively();
		for(Integer i : list)
			System.out.print(i + " ");
		System.out.println();
		
		System.out.println("Search 160: " +  tree.searchElement(160));
		System.out.println("Search 180: " + tree.searchElement(180));
	}

}
