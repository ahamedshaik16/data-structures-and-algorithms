package binaryTree;

public class SizeOfBinaryTree {

	public static TreeNode root;
	
	public void createBinaryTree(){
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
	
	public int size(TreeNode root) {
		int leftCount = root.getLeft() == null ? 0 : size(root.getLeft());
		int rightCount = root.getRight() == null ? 0 : size(root.getRight());
		return 1 + leftCount + rightCount;
	}
	
	public static void main(String[] args) {
		SizeOfBinaryTree tree = new SizeOfBinaryTree();
		tree.createBinaryTree();
		
		System.out.println("Size: " + tree.size(root));
	}

}
