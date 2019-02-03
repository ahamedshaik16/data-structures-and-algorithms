package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.InsertAnElementinBinaryTreeIteravtively.TreeNode;

public class MaxElementInBinaryTreeWithOutRecursion {

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
	
	public void createBinaryTree() {
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
		
		two.setLeft(seven);
		two.setRight(four);
		
		three.setLeft(six);
		three.setRight(five);
	}
	
	public int maxElement(){
		int maxValue = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp.getData() > maxValue)
				maxValue = temp.getData();
			if(temp != null){
				if(temp.getLeft() != null)
					queue.offer(temp.getLeft());
				if(temp.getRight() != null)
					queue.offer(temp.getRight());
			}
			
		}
		
		queue.offer(null);
		return maxValue;
	}
	
	public static void main(String[] args) {
		MaxElementInBinaryTreeWithOutRecursion tree = new MaxElementInBinaryTreeWithOutRecursion();
		tree.createBinaryTree();
		
		System.out.println(tree.maxElement());
	}

}
