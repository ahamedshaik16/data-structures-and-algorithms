package binarySearchTree;

public class CreateBinarySearchTree {

	public static BinarySearchTreeNode root;
	
	public void createBinarySearchTree() {
		BinarySearchTreeNode one = new BinarySearchTreeNode(10);
		BinarySearchTreeNode two = new BinarySearchTreeNode(20);
		BinarySearchTreeNode three = new BinarySearchTreeNode(30);
		BinarySearchTreeNode four = new BinarySearchTreeNode(40);
		BinarySearchTreeNode five = new BinarySearchTreeNode(50);
		BinarySearchTreeNode six = new BinarySearchTreeNode(60);
		BinarySearchTreeNode seven = new BinarySearchTreeNode(70);
		BinarySearchTreeNode eight = new BinarySearchTreeNode(80);
		BinarySearchTreeNode nine = new BinarySearchTreeNode(90);
		BinarySearchTreeNode ten = new BinarySearchTreeNode(100);
		
		root = five;
		
		five.setLeft(three);
		five.setRight(seven);
		
		three.setLeft(two);
		three.setRight(four);
		
		two.setLeft(one);
		
		seven.setLeft(six);
		seven.setRight(nine);
		
		nine.setLeft(eight);
		nine.setRight(ten);
	}
}
