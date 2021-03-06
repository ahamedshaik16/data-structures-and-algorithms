package binaryTree;

public class TreeNode<T> {
	private TreeNode left;
	private TreeNode right;
	private T data;
	
	public TreeNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(T data, TreeNode left, TreeNode right) {
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
