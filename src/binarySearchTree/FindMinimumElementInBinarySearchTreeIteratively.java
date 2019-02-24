package binarySearchTree;

import java.util.Stack;

public class FindMinimumElementInBinarySearchTreeIteratively extends CreateBinarySearchTree{

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
		System.out.println();
	}
	
	public BinarySearchTreeNode findMin() {
		if(root == null)
			return null;
		while(root.getLeft() != null)
			root = root.getLeft();
		return root;
	}
	
	public static void main(String args[]) {
		FindMinimumElementInBinarySearchTreeIteratively tree = new FindMinimumElementInBinarySearchTreeIteratively();
		tree.createBinarySearchTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal();
		System.out.println();
		System.out.println("Min Element: " + tree.findMin().getData());
	}
}
