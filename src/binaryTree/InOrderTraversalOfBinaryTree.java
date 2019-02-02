package binaryTree;

public class InOrderTraversalOfBinaryTree {

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
	
	
	/** 
	 * InOrder Traversal (LDR)
	 * 1. Traverse the left subtree in InOrder (L)
	 * 2. Visit the root (D)
	 * 3. Traverse the right subtree in InOrder (R)
	 * 
	 */
	public void inorderTraversal(TreeNode root) {
		if(root != null) {	
			inorderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderTraversal(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		InOrderTraversalOfBinaryTree tree = new InOrderTraversalOfBinaryTree();
		
		tree.createBinaryTree();
		
		tree.inorderTraversal(root);
	}

}
