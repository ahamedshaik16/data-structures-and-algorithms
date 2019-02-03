package binaryTree;

import binaryTree.InsertAnElementinBinaryTreeIteravtively.TreeNode;

public class SearchAnElementInBinaryTreeWithRecursion {

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
	
	public boolean findElement(TreeNode node, int data) {
		if(node == null)
			return false;
		if(node.getData() == data)
			return true;
		return findElement(node.getLeft(), data) || findElement(node.getRight(), data);
	}
	
	public void preOrderTraversal(TreeNode root){
		if(root != null) {
			System.out.print(root.getData() + " ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
		
	}
	
	public static void main(String[] args) {
		SearchAnElementInBinaryTreeWithRecursion tree = new SearchAnElementInBinaryTreeWithRecursion();
		
		tree.createBinaryTree();
		
		tree.preOrderTraversal(root);
		System.out.println();
		
		System.out.println("Search 160: " + tree.findElement(root, 160));
		
		System.out.println("Search 170: " + tree.findElement(root, 170));
	}

}
