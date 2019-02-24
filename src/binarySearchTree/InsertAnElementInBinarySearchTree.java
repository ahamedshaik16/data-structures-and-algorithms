package binarySearchTree;

import java.util.Stack;

public class InsertAnElementInBinarySearchTree extends CreateBinarySearchTree{

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
				else{
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + " ");
					currentNode = currentNode.getRight();
				}
			}
		}
	}
	
	public BinarySearchTreeNode insert(BinarySearchTreeNode currentNode, int data) {
		if(currentNode == null) {
			currentNode = new BinarySearchTreeNode(data);
		} else {
			if(data < currentNode.getData())
				currentNode.setLeft(insert(currentNode.getLeft(), data));
			else if(data > currentNode.getData())
				currentNode.setRight(insert(currentNode.getRight(), data));
		}
		return currentNode;
	}
	
	public static void main(String args[]) {
		InsertAnElementInBinarySearchTree tree = new InsertAnElementInBinarySearchTree();
		tree.createBinarySearchTree();
		System.out.println("Traversal: ");
		tree.inOrderTraversal();
		System.out.println();
		tree.insert(root, 35);
		System.out.println("After inserting 35: ");
		tree.inOrderTraversal();
		System.out.println();
		tree.insert(root, 85);
		System.out.println("After inserting 85: ");
		tree.inOrderTraversal();
	}
	
	
	
}
