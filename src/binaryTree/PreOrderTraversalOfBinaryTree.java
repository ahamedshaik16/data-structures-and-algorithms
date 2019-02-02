package binaryTree;

public class PreOrderTraversalOfBinaryTree {

	private static TreeNode root;
	
	public void createBinaryTree() {
		
		TreeNode first = new TreeNode(10);
		TreeNode second = new TreeNode(20);
		TreeNode third = new TreeNode(30);
		TreeNode fourth = new TreeNode(40);
		TreeNode fifth = new TreeNode(50);
		TreeNode sixth = new TreeNode(60);
		TreeNode seventh = new TreeNode(70);
		
		root = first;
		first.setLeft(second);
		first.setRight(third);
		
		second.setLeft(fourth);
		second.setRight(fifth);
		
		third.setLeft(sixth);
		third.setRight(seventh);
	}
	
	/** PreOrder (DLR) traversal, first root node(D), then process 
	 * left sub tree (L) and then process right sub tree (R). **/
	public void preOrder(TreeNode root){
		if(root!=null){
			System.out.print(root.getData() + " ");
			preOrder(root.getLeft());
			
			preOrder(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		PreOrderTraversalOfBinaryTree tree = new PreOrderTraversalOfBinaryTree();
		tree.createBinaryTree();
		tree.preOrder(root);
		
	}

}
