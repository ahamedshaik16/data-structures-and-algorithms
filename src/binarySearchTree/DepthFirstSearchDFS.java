package binarySearchTree;

public class DepthFirstSearchDFS {

	public static BinarySearchTreeNode root;
	
	public void createTree() {
		BinarySearchTreeNode one = new BinarySearchTreeNode(1);
		BinarySearchTreeNode two = new BinarySearchTreeNode(2);
		BinarySearchTreeNode three = new BinarySearchTreeNode(3);
		BinarySearchTreeNode four = new BinarySearchTreeNode(4);
		BinarySearchTreeNode five = new BinarySearchTreeNode(5);
		BinarySearchTreeNode six = new BinarySearchTreeNode(6);
		BinarySearchTreeNode seven = new BinarySearchTreeNode(7);
		BinarySearchTreeNode eight = new BinarySearchTreeNode(8);
		BinarySearchTreeNode nine = new BinarySearchTreeNode(9);
		BinarySearchTreeNode ten = new BinarySearchTreeNode(10);
		BinarySearchTreeNode eleven = new BinarySearchTreeNode(11);
		BinarySearchTreeNode twelve = new BinarySearchTreeNode(12);
		
		root = one;
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		four.setLeft(eight);
		four.setRight(nine);
		
		six.setLeft(ten);
		six.setRight(eleven);
		
		seven.setRight(twelve);
		
	}
	
	public void inOrderTraversal(BinarySearchTreeNode currentNode) {
		if(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			inOrderTraversal(currentNode.getLeft());
			inOrderTraversal(currentNode.getRight());
		}
	}
	public void DFS(BinarySearchTreeNode currentNode) {
		System.out.print(currentNode.getData() + " ");
		if(currentNode.getLeft() != null)
			DFS(currentNode.getLeft());
		if(currentNode.getRight() != null)
			DFS(currentNode.getRight());
	}
	
	public static void main(String args[]) {
		DepthFirstSearchDFS tree = new DepthFirstSearchDFS();
		tree.createTree();
		System.out.println("Inorder Traversal:");
		tree.inOrderTraversal(root);
		System.out.println();
		System.out.println("DFS Traversal");
		tree.DFS(root);
	}
}
