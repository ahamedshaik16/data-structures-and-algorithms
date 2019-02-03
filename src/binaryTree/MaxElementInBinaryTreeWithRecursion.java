package binaryTree;

import binaryTree.InsertAnElementinBinaryTreeIteravtively.TreeNode;

public class MaxElementInBinaryTreeWithRecursion {

	public static TreeNode root;
	
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
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(seven);
		three.setRight(six);
	}
	
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
	
	public int maxInBinaryTree(TreeNode root){
		int maxValue = 0;
		if(root != null) {
			int leftMax = maxInBinaryTree(root.getLeft());
			int rightMax = maxInBinaryTree(root.getRight());
			
			if(leftMax > rightMax)
				maxValue = leftMax;
			else 
				maxValue = rightMax;
			if(root.getData() > maxValue)
				maxValue = root.getData();
		}
		
		
		return maxValue;
	}
	
	public static void main(String[] args) {
		MaxElementInBinaryTreeWithRecursion tree = new MaxElementInBinaryTreeWithRecursion();
		
		tree.createBinaryTree();
		
		System.out.println(tree.maxInBinaryTree(root));
	}

}
