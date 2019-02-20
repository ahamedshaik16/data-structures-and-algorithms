package binaryTree;

import java.util.Stack;

public class DepthOfTreeRecursion {

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
	
	public void inOrderTraversal(TreeNode currentNode) {
		if(currentNode != null) {
			inOrderTraversal(currentNode.getLeft());
			System.out.print(currentNode.getData() + " ");
			inOrderTraversal(currentNode.getRight());
		}
	}
	
	public int depth(){
		int maxDepth =  0;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode prev = null;
		while(!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr){
				if(curr.getLeft() != null)
					stack.push(curr.getLeft());
				else if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else if(curr.getLeft() == prev) {
				if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else {
				stack.pop();
			}
			prev = curr;
			if(stack.size() > maxDepth)
				maxDepth = stack.size();
		}
		
		
		return maxDepth;
	}
	
	public static void main(String args[]) {
		DepthOfTreeRecursion tree = new DepthOfTreeRecursion();
		tree.createTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal(root);
		System.out.println();
		System.out.println("Depth: " + tree.depth());
	}
	
	
	
	
}
