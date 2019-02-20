package binaryTreePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIteratively {
public static BinaryTreeNode root;
	
	public void createBinaryTree() {
		BinaryTreeNode one = new BinaryTreeNode(10);
		BinaryTreeNode two = new BinaryTreeNode(20);
		BinaryTreeNode three = new BinaryTreeNode(30);
		BinaryTreeNode four = new BinaryTreeNode(40);
		BinaryTreeNode five = new BinaryTreeNode(50);
		BinaryTreeNode six = new BinaryTreeNode(60);
		BinaryTreeNode seven = new BinaryTreeNode(70);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public <T> List<Integer> inOrderTraversal() {
		List<Integer> data = new ArrayList<>();
		boolean done = false;
		BinaryTreeNode currentNode = root;
		Stack<BinaryTreeNode> stack = new Stack<>();
		while(!done) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				if(stack.isEmpty())
					done = true;
				else {
					currentNode = stack.pop();
					data.add((Integer) currentNode.getData());
					currentNode = currentNode.getRight();
				}
			}
		}
		
		
		return data;
	}
	
	public static void main(String args[]) {
		InOrderTraversalIteratively tree = new InOrderTraversalIteratively();
		tree.createBinaryTree();
		List<Integer> list = tree.inOrderTraversal();
		for(Integer each: list)
			System.out.print(each + " ");
	}
}
