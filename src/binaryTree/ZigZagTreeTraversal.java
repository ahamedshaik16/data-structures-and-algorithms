package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTreeTraversal {

	public static TreeNode root;
	
	public void createTree() {
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
		
		two.setLeft(seven);
		two.setRight(six);
		
		three.setLeft(five);
		three.setRight(four);
	}
	
	public void levelOrderTraversal() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			System.out.print(currNode.getData() +" ");
			if(currNode.getLeft() != null)
				queue.offer(currNode.getLeft());
			if(currNode.getRight() != null)
				queue.offer(currNode.getRight());
		}
	}
	
	public void zigzagTraversal() {
		Stack<TreeNode> currentLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		boolean leftToRight = true;
		currentLevel.push(root);
		while(!currentLevel.isEmpty()) {
			TreeNode currentNode = currentLevel.pop();
			System.out.print(currentNode.getData() + " ");
			if(leftToRight) {
				if(currentNode.getLeft() != null)
					nextLevel.push(currentNode.getLeft());
				if(currentNode.getRight() != null)
					nextLevel.push(currentNode.getRight());
			} else {
				if(currentNode.getRight() != null)
					nextLevel.push(currentNode.getRight());
				if(currentNode.getLeft() != null)
					nextLevel.push(currentNode.getLeft());
			}
			if(currentLevel.isEmpty()) {
				Stack<TreeNode> tempStack = currentLevel;
				currentLevel = nextLevel;
				nextLevel = tempStack;
				leftToRight = !leftToRight;
			}
			
		}
	}
	
	public static void main(String args[]) {
		ZigZagTreeTraversal tree = new ZigZagTreeTraversal();
		tree.createTree();
		System.out.println("Level Order Traversal: ");
		tree.levelOrderTraversal();
		System.out.println();
		System.out.println("After ZigZag Traversal: ");
		tree.zigzagTraversal();
	}
	
	
	
	
	
	
	
	
}
