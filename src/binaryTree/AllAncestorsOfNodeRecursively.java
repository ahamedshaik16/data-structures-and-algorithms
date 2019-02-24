package binaryTree;

import java.util.Stack;

public class AllAncestorsOfNodeRecursively {

	public static TreeNode root;
	
	public void createTree(){
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
	
	public void postOrderTraversalIteratively() {
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		TreeNode prev = null;
		while(!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				if(curr.getLeft() != null)
					stack.push(curr.getLeft());
				else if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else if(curr.getLeft() == prev){
				if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else {
				TreeNode temp = stack.pop();
				System.out.print(temp.getData() + " ");
			}
			prev = curr;
		}
		
	}
	
	public boolean ancestorsOfANode(TreeNode currentNode, TreeNode searchNode) {
		if(currentNode == null) return false;
		if((currentNode.getLeft() != null && currentNode.getLeft().getData() == searchNode.getData()) 
				|| (currentNode.getRight() != null && currentNode.getRight().getData() == searchNode.getData()) 
				|| ancestorsOfANode(currentNode.getLeft(), searchNode) || ancestorsOfANode(currentNode.getRight(), searchNode)) {
			System.out.print(currentNode.getData() + " ");
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		AllAncestorsOfNodeRecursively tree = new AllAncestorsOfNodeRecursively();
		tree.createTree();
		System.out.println("Post order traversal:");
		tree.postOrderTraversalIteratively();
		System.out.println();
		System.out.println("Ancestors of 80");
		tree.ancestorsOfANode(root, new TreeNode(80));
		
	}
	
	
	
	
	
	
	
	
	
}
