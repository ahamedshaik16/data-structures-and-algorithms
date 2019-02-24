package binarySearchTree;

import java.util.Stack;

public class InOrderPredecessorInBinarySearchTree extends CreateOtherBinarySearchTree{

	public void inOrderTraversal() {
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		BinarySearchTreeNode currentNode = root;
		boolean done = false;
		while(!done) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				if(stack.isEmpty()) {
					done = true;
				} else {
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + " ");
					currentNode = currentNode.getRight();
				}
			}
		}
		System.out.println();
	}
	
	public BinarySearchTreeNode findElement(BinarySearchTreeNode currentNode, int data) {
		if(currentNode == null) return null;
		while(currentNode != null) {
			if(currentNode.getData() == data) return currentNode;
			if(data < currentNode.getData())
				currentNode = currentNode.getLeft();
			if(data > currentNode.getData())
				currentNode = currentNode.getRight();
		}
		return currentNode;
	}
	
	public BinarySearchTreeNode inOrderPredecessor(BinarySearchTreeNode currentNode, BinarySearchTreeNode searchNode) {
		BinarySearchTreeNode foundElement = findElement(currentNode, searchNode.getData());
		BinarySearchTreeNode predecessor = null;
		if(foundElement.getLeft() != null) {
			 predecessor = foundElement.getLeft();
			while(predecessor.getRight() != null) {
				predecessor = predecessor.getRight();
			}
			return predecessor;
		} else {
			BinarySearchTreeNode storeRight = null;
			while(searchNode.getData() != currentNode.getData()) {
				if(searchNode.getData() > currentNode.getData()) {
					storeRight = currentNode;
					currentNode = currentNode.getRight();
				} else {
					currentNode = currentNode.getLeft();
				}
			}
			predecessor = storeRight;
			return predecessor;
		}
	}
	
	public static void main(String args[]) {
		InOrderPredecessorInBinarySearchTree tree = new InOrderPredecessorInBinarySearchTree();
		tree.createTree();
		System.out.println("InOrder Traversal: ");
		tree.inOrderTraversal();
		System.out.println("Find 78: " + tree.findElement(root, 78).getData());
		BinarySearchTreeNode predecessor = tree.inOrderPredecessor(root, new BinarySearchTreeNode(85));
		if(predecessor != null)	System.out.println("Predecessor of 85: " + predecessor.getData());
		else System.out.println("Predecessor of 85: " + predecessor);
		predecessor = tree.inOrderPredecessor(root, new BinarySearchTreeNode(40));
		if(predecessor != null)	System.out.println("Predecessor of 40: " + predecessor.getData());
		else System.out.println("Predecessor of 40: " + predecessor);
	}
	
}
