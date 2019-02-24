package binarySearchTree;

import java.util.Stack;

public class LeastCommonAncestorInBinarySearchTree extends CreateBinarySearchTree{

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
	
	
	public BinarySearchTreeNode LCA(BinarySearchTreeNode currentNode, BinarySearchTreeNode searchNodeA, BinarySearchTreeNode searchNodeB) {
		if(currentNode == null)
			return null;
		if(currentNode == searchNodeA || currentNode == searchNodeB) 
			return currentNode;
		if(searchNodeA.getData() < currentNode.getData() && searchNodeB.getData() < currentNode.getData()) 
			return LCA(currentNode.getLeft(), searchNodeA, searchNodeB);
		if(searchNodeA.getData() > currentNode.getData() && searchNodeB.getData() > currentNode.getData())
			return LCA(currentNode.getRight(), searchNodeA, searchNodeB);
		return currentNode;
	}
	
	public static void main(String args[]) {
		LeastCommonAncestorInBinarySearchTree tree = new LeastCommonAncestorInBinarySearchTree();
		tree.createBinarySearchTree();
		System.out.println("Inorder traversal for Binary search tree will sorted list:");
		tree.inOrderTraversal();
		System.out.println("LCA of 80 and 100: " + tree.LCA(root, new BinarySearchTreeNode(80), new BinarySearchTreeNode(100)).getData());
		System.out.println("LCA of 40 and 90: " + tree.LCA(root, new BinarySearchTreeNode(90), new BinarySearchTreeNode(40)).getData());
		System.out.println("LCA of 70 and 100: " + tree.LCA(root, new BinarySearchTreeNode(70), new BinarySearchTreeNode(100)).getData());
	}
}
