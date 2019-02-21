package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumSumInLevelOfBinaryTree {

	public static TreeNode root;
	
	public void createTree() {
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		TreeNode five = new TreeNode(50);
		TreeNode six = new TreeNode(60);
		TreeNode seven = new TreeNode(70);
		TreeNode eight = new TreeNode(80);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
	}
	
	public void inOrderTraversal() {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;
		boolean done = false;
		while(!done) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			}else {
				if(stack.isEmpty())
					done = true;
				else {
					currentNode = stack.pop();
					result.add((Integer) currentNode.getData());
					currentNode = currentNode.getRight();
				}
			}
		}
		
		for(Integer each: result)
			System.out.print(each + " ");
		System.out.println();
	}
	
	public int height(TreeNode currentNode) {
		if(currentNode == null) return 0;
		int leftDepth = height(currentNode.getLeft());
		int rightDepth = height(currentNode.getRight());
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	public int maximumSumInLevel(TreeNode currentNode) {
		if(currentNode == null)
			return 0;
		int maxSum = 0;
		int height = height(currentNode);
		for(int k = 0; k < height; k++){
			int currentSum = maxSum(currentNode, k);
			if(currentSum > maxSum) maxSum = currentSum;
		}
		return maxSum;
	}
	
	public int maxSum(TreeNode currentNode, int depth) {
		if(currentNode == null) return 0;
		if(depth == 0) return (Integer) currentNode.getData();
		return (maxSum(currentNode.getLeft(), depth -1) + maxSum(currentNode.getRight(), depth -1));
	}
	
	public static void main(String args[]) {
		MaximumSumInLevelOfBinaryTree tree = new MaximumSumInLevelOfBinaryTree();
		tree.createTree();
		System.out.println("Tree:");
		tree.inOrderTraversal();
		System.out.println("Max sum in levels: " + tree.maximumSumInLevel(root));
	}
	
	
	
	
	
	
	
	
	
}
