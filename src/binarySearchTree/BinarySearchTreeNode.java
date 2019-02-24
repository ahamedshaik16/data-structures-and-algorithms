package binarySearchTree;

public class BinarySearchTreeNode {
	public int data;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode right;
	
	public BinarySearchTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BinarySearchTreeNode(int data, BinarySearchTreeNode left, BinarySearchTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinarySearchTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}
	public BinarySearchTreeNode getRight() {
		return right;
	}
	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}
	
	
}
