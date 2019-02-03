package binaryTree;

public class PostOrderTraversalOfBinaryTree {


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
	
	public void postOrderTraversal(TreeNode root) {
		if(root != null){
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getData() + " ");
	
		}
	}
	
	public static void main(String[] args) {
		PostOrderTraversalOfBinaryTree tree = new PostOrderTraversalOfBinaryTree();
		
		tree.createBinaryTree();
		
		tree.postOrderTraversal(root);
	}

}
