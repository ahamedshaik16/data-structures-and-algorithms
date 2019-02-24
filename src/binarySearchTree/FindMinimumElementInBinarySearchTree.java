package binarySearchTree;

import java.util.Stack;

public class FindMinimumElementInBinarySearchTree extends CreateBinarySearchTree{

	public void inOrderTraversal() {
		if(root == null) return;
		Stack<BinarySearchTreeNode> stack = new Stack();
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
	
	public BinarySearchTreeNode findMin(BinarySearchTreeNode currentNode) {
		if(currentNode == null) 
			return null;
		if(currentNode.getLeft() == null)
			return currentNode;
		return findMin(currentNode.getLeft());
	}
	
	public static void main(String args[]) {
		FindMinimumElementInBinarySearchTree tree = new FindMinimumElementInBinarySearchTree();
		tree.createBinarySearchTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal();
		System.out.println();
		System.out.println("Min Element: " + tree.findMin(root).getData());
	}
}
