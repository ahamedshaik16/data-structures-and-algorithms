package binarySearchTree;

import java.util.Stack;

public class FindElementInBinarySearchTreeIteratively extends CreateBinarySearchTree{

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
	}
	
	public BinarySearchTreeNode findEle(BinarySearchTreeNode node, int data) {
		if(node == null)
			return null;
		if(node.getData() == data)
			return node;
		while(node != null) {
			if(node.getData() == data) return node;
			if(data > node.getData()) 
				node = node.getRight();
			else 
				node = node.getLeft();
		}
		return null;
	}
	
	public static void main(String args[]) {
		FindElementInBinarySearchTreeIteratively tree = new FindElementInBinarySearchTreeIteratively();
		tree.createBinarySearchTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal();
		System.out.println();
		System.out.println("Search 90: " + tree.findEle(root, 90).getData());
	}
}
