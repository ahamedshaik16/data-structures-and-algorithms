package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversalOfBinaryTreeIteratively {

	public static TreeNode root;
	
	public void createBinaryTree() {
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		TreeNode five = new TreeNode(50);
		TreeNode six = new TreeNode(60);
		TreeNode seven = new TreeNode(70);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public <T> ArrayList<T> inorderTraversalIteratively(){
		ArrayList<T> tree = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;
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
					tree.add((T) currentNode.getData());
					currentNode = currentNode.getRight();					
				}
			}
		}
		
		
		return tree;
	}
	
	public static void main(String[] args) {
		InOrderTraversalOfBinaryTreeIteratively tree = new InOrderTraversalOfBinaryTreeIteratively();
		tree.createBinaryTree();
		ArrayList<Integer> treeList = tree.inorderTraversalIteratively();
		for(Integer i : treeList)
			System.out.print(i + " ");
	}

}
