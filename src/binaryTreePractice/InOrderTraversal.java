package binaryTreePractice;

public class InOrderTraversal {

	public static BinaryTreeNode root;
	
	public void createBinaryTree() {
		BinaryTreeNode one = new BinaryTreeNode(10);
		BinaryTreeNode two = new BinaryTreeNode(20);
		BinaryTreeNode three = new BinaryTreeNode(30);
		BinaryTreeNode four = new BinaryTreeNode(40);
		BinaryTreeNode five = new BinaryTreeNode(50);
		BinaryTreeNode six = new BinaryTreeNode(60);
		BinaryTreeNode seven = new BinaryTreeNode(70);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public void inOrderTraversal(BinaryTreeNode root) {
		if(root != null) {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrderTraversal(root.getRight());
		}
	}
	
	public static void main(String args[]) {
		InOrderTraversal tree = new InOrderTraversal();
		tree.createBinaryTree();
		tree.inOrderTraversal(root);
	}
}
