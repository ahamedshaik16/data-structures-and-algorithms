package binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

import binaryTree.TreeNode;

public class FindElementInBinarySearchTree extends CreateBinarySearchTree{

	public ArrayList inorderTraversalIteratively(){
		ArrayList<Integer> tree = new ArrayList<>();
		Stack<BinarySearchTreeNode> stack = new Stack<>();
		BinarySearchTreeNode currentNode = root;
		boolean done = false;
		while(!done) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				if(stack.isEmpty()){
					done = true;
				} else {
					currentNode = stack.pop();
					tree.add(currentNode.getData());
					currentNode = currentNode.getRight();					
				}
			}
		}
		
		for(Integer each: tree) {
			System.out.print(each + " ");
		}
		return tree;
	}
	
	public BinarySearchTreeNode findEle(BinarySearchTreeNode currentNode, int data) {
		if(currentNode == null) 
			return null;
		if(data < currentNode.getData())
			return findEle(currentNode.getLeft(), data);
		if(data > currentNode.getData())
			return findEle(currentNode.getRight(), data);
		return currentNode;
	}
	
	public static void main(String args[]) {
		FindElementInBinarySearchTree tree = new FindElementInBinarySearchTree();
		tree.createBinarySearchTree();
		System.out.println("BinarySearchTree: ");
		tree.inorderTraversalIteratively();
		System.out.println();
		System.out.println("Search 100: " + tree.findEle(root, 50).getData());
	}
}
