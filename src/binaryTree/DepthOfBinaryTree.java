package binaryTree;

public class DepthOfBinaryTree {

	public static TreeNode root;
	
	public void createBinaryTree(){
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		TreeNode five = new TreeNode(50);
		TreeNode six = new TreeNode(60);
		TreeNode seven = new TreeNode(70);
		TreeNode eight = new TreeNode(80);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
	}
	
	public void preOrderTraversal(TreeNode root) {
		if(root != null) {
			preOrderTraversal(root.getLeft());
			
			preOrderTraversal(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		int leftDepth = maxDepth(root.getLeft());
		int rightDepth = maxDepth(root.getRight());
		return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
	}
	
	public static void main(String args[]) {
		DepthOfBinaryTree tree = new DepthOfBinaryTree();
		
		tree.createBinaryTree();
		
		tree.preOrderTraversal(root);
		System.out.println();
		System.out.println("depth : "+tree.maxDepth(root));
	}
	
}
