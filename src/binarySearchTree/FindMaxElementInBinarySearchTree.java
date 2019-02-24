package binarySearchTree;

import java.util.Stack;

public class FindMaxElementInBinarySearchTree extends CreateBinarySearchTree{

	public void inOrderTraversal() {
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		BinarySearchTreeNode currentNode = root;
		boolean done = false;
		while(!done) {
			if(currentNode != null){
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
		System.out.println();
	}
	
	public BinarySearchTreeNode findMaxRecursively(BinarySearchTreeNode currentNode) {
		if(currentNode == null)
			return null;
		if(currentNode.getRight() == null)
			return currentNode;
		return findMaxRecursively(currentNode.getRight());
	}
	
	public BinarySearchTreeNode findMaxIteratively(BinarySearchTreeNode currentNode) {
		if(root == null)
			return null;
		while(currentNode.getRight() != null)
			currentNode = currentNode.getRight();
		return currentNode;
	}
	
	public static void main(String args[]) {
		FindMaxElementInBinarySearchTree tree = new FindMaxElementInBinarySearchTree();
		tree.createBinarySearchTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal();
		System.out.println("find by recursive: " + tree.findMaxRecursively(root).getData());
		System.out.println("Find by iteratively: " + tree.findMaxIteratively(root).getData());
	}
}
