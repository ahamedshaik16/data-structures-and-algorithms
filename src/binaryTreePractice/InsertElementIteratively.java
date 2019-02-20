package binaryTreePractice;

public class InsertElementIteratively {

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
	
	public void postOrderTraversal(BinaryTreeNode currentNode) {
		if(currentNode != null) {
			postOrderTraversal(currentNode.getLeft());
			postOrderTraversal(currentNode.getRight());
			System.out.print(currentNode.getData() + " ");
		}
	}
	
	public void insert(int data) {
		if(root == null) {
			root = new BinaryTreeNode(data);
		} else {
			insertAnElement(root, data);
		}
	}
	
	public void insertAnElement(BinaryTreeNode currentNode, int data) {
		if(currentNode.getData() > data) {
			if(currentNode.getLeft() == null)
				currentNode.setLeft(new BinaryTreeNode(data));
			else {
				insertAnElement(currentNode.getLeft(), data);
			}
		} else {
			if(currentNode.getRight() == null)
				currentNode.setRight(new BinaryTreeNode(data));
			else
				insertAnElement(currentNode.getRight(), data);
		}
	}
	
	
	public static void main(String args[]) {
		InsertElementIteratively tree = new InsertElementIteratively();
		tree.createTree();
		System.out.println("Before insertion of node:");
		tree.postOrderTraversal(root);
		tree.insert(80);
		System.out.println();
		System.out.println("After insertion of node");
		tree.postOrderTraversal(root);
	}
	
	
	
	
	
	
}
