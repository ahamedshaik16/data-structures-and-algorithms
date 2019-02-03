package binaryTree;

public class InsertAnElementinBinaryTreeIteravtively {
	
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
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public void insert(TreeNode root, int data){
		if(root == null){
			root = new TreeNode(data);
		} else {
			insertNode(root, data);
		}
	}
	
	public void insertNode(TreeNode root, int data) {
		if(root.getData() >= data) {
			if(root.getLeft() == null) {
				root.setLeft(new TreeNode(data));
			} else {
				insertNode(root.getLeft(), data);
			}
		} else {
			if(root.getRight() == null) {
				root.setRight(new TreeNode(data));
			} else {
				insertNode(root.getRight(), data);
			}
		}
	}
	
	public void preOrderTraversal(TreeNode root) {
		if(root != null){
			System.out.print(root.getData() + " ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		InsertAnElementinBinaryTreeIteravtively tree = new InsertAnElementinBinaryTreeIteravtively();
		
		tree.createBinaryTree();
		System.out.println("Before Inserting ");
		tree.preOrderTraversal(root);
		
		tree.insert(root, 190);
		
		System.out.println("After inserting... ");
		tree.preOrderTraversal(root);
	}

}
