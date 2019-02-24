package binarySearchTree;

import java.util.Stack;

public class InOrderSuccessorInBinarySearchTree extends CreateOtherBinarySearchTree{

	public void inOrderTraversal() {
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		BinarySearchTreeNode currentNode = root;
		boolean done = false;
		while(!done) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				if(stack.isEmpty())
					done = true;
				else {
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + " ");
					currentNode = currentNode.getRight();
				}
			}
		}
	}
	
	public BinarySearchTreeNode findElement(BinarySearchTreeNode currentNode, int data) {
		if(currentNode == null) return null;
		if(data < currentNode.getData())
			return findElement(currentNode.getLeft(), data);
		if(data > currentNode.getData())
			return findElement(currentNode.getRight(), data);
		return currentNode;
	}
	
	public BinarySearchTreeNode inOrderSuccessor(BinarySearchTreeNode currentNode, BinarySearchTreeNode searchNode) {
		BinarySearchTreeNode foundElement = findElement(currentNode, searchNode.getData());
		BinarySearchTreeNode successor = null;
		if(foundElement.getRight() != null) {
			successor = foundElement.getRight();
			while(successor.getLeft() != null)
				successor = successor.getLeft();
			return successor;
		} else {
			BinarySearchTreeNode storeLeft = null;
			while(searchNode.getData() != currentNode.getData()) {
				if(searchNode.getData() < currentNode.getData()){
					storeLeft = currentNode;
					currentNode = currentNode.getLeft();
				} else {
					currentNode = currentNode.getRight();
				}
			}
			successor = storeLeft;
			return successor;
		}
	}
	
	public static void main(String args[]) {
		InOrderSuccessorInBinarySearchTree tree = new InOrderSuccessorInBinarySearchTree();
		tree.createTree();
		System.out.println("Inorder Traversal:");
		tree.inOrderTraversal();
		System.out.println();
		System.out.println("find 85: " + tree.findElement(root, 85).getData());
		BinarySearchTreeNode successor = tree.inOrderSuccessor(root, new BinarySearchTreeNode(36));
		if(successor != null)	System.out.println("successor of 37: " + successor.getData());
		else System.out.println("successor of 37: " + successor);
		successor = tree.inOrderSuccessor(root, new BinarySearchTreeNode(79));
		if(successor != null)	System.out.println("successor of 79: " + successor.getData());
		else System.out.println("successor of 79: " + successor);
	}
}
