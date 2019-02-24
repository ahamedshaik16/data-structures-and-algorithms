package binarySearchTree;

public class DepthFirstSearchToDLL extends CreateBinarySearchTree{

	private static BinarySearchTreeNode prev = null;
	private static BinarySearchTreeNode head = null;
	
	public void inOrderTraversal(BinarySearchTreeNode currentNode) {
		if(currentNode != null) {
			inOrderTraversal(currentNode.getLeft());
			System.out.print(currentNode.getData() + " " );
			inOrderTraversal(currentNode.getRight());
		}
	}
	
	public void DFSToDLL(BinarySearchTreeNode currentNode) {
		if(currentNode == null)
			return;
		DFSToDLL(currentNode.getLeft());
		if(prev == null)
			head = currentNode;
		else {
			currentNode.setLeft(prev);
			prev.setRight(currentNode);
		}
		prev = currentNode;
		DFSToDLL(currentNode.getRight());
	}
	
	public void printList() {
		BinarySearchTreeNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getRight();
		}
	}
	
	public static void main(String args[]) {
		DepthFirstSearchToDLL tree = new DepthFirstSearchToDLL();
		tree.createBinarySearchTree();
		System.out.println("Inorder traversal:: ");
		tree.inOrderTraversal(root);
		System.out.println();
		System.out.println("Doubly linked list: ");
		tree.DFSToDLL(root);
		tree.printList();
	}
}
