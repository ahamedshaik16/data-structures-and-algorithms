package binaryTreePractice;

public class SearchElementWithRecursion {

	public static BinaryTreeNode root;
	
	public void createTree() {
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
	
	public boolean findElement(BinaryTreeNode currentNode, int data) {
		if(currentNode == null)
			return false;
		if(currentNode.getData() == data)
			return true;
		return (findElement(currentNode.getLeft(), data) || (findElement(currentNode.getRight(), data)));
	}
	
	public void preOrderTraversal(BinaryTreeNode currentNode) {
		if(currentNode != null){
			System.out.print(currentNode.getData() + " ");
			preOrderTraversal(currentNode.getLeft());
			preOrderTraversal(currentNode.getRight());
		}
	}
	
	public static void main(String args[]) {
		SearchElementWithRecursion tree = new SearchElementWithRecursion();
		
		tree.createTree();
		System.out.println("Binary Tree PreOrderTraversal:");
		tree.preOrderTraversal(root);
		System.out.println();
		System.out.println("70 Exists: " + tree.findElement(root, 70));
		System.out.println("90 Exists: " + tree.findElement(root, 90));
	}
}
