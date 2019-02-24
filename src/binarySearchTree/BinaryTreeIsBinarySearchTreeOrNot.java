package binarySearchTree;

import java.util.Stack;

public class BinaryTreeIsBinarySearchTreeOrNot extends CreateBinarySearchTree{

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
	
	public static Integer findMin(BinarySearchTreeNode currentNode) {
		if(currentNode == null)
			return null;
		if(currentNode.getLeft() == null)
			return currentNode.getData();
		return findMin(currentNode.getLeft());
	}
	
	public static Integer findMax(BinarySearchTreeNode currentNode) {
		if(currentNode == null)
			return null;
		while(currentNode.getRight() != null)
			currentNode = currentNode.getRight();
		return currentNode.getData();
	}
	
	public boolean IsBST(BinarySearchTreeNode currentNode) {
		if(currentNode == null)
			return true;
		if(currentNode.getLeft() != null && findMax(currentNode.getLeft()) > currentNode.getData())
			return false;
		if(currentNode.getRight() != null && findMin(currentNode.getRight()) < currentNode.getData())
			return false;
		if((!IsBST(currentNode.getLeft()))|| (!IsBST(currentNode.getRight())))
			return false;
		return true;
			
	}
	
	public static void main(String args[]) {
		BinaryTreeIsBinarySearchTreeOrNot tree = new BinaryTreeIsBinarySearchTreeOrNot();
		tree.createBinarySearchTree();
		System.out.println("Inorder traversal of Binary search tree will be sorted list");
		tree.inOrderTraversal();
		System.out.println("Is tree a BST ? " + tree.IsBST(root)) ;
	}
}
