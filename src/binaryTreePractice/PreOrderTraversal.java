package binaryTreePractice;

public class PreOrderTraversal {

	private static BinaryTreeNode root;
	
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
	
	public void preOrderTraversal(BinaryTreeNode currentNode) {
		if(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			preOrderTraversal(currentNode.getLeft());
			preOrderTraversal(currentNode.getRight());
		}
	}
	
	public static void main(String args[]) {
		PreOrderTraversal tree = new PreOrderTraversal();
		tree.createBinaryTree();
		tree.preOrderTraversal(root);
	}
	
}
