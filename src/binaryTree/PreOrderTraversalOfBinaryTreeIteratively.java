package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversalOfBinaryTreeIteratively {

	private static TreeNode root;
	
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
	
	public <T> ArrayList<T> preorderTraversal(TreeNode root){
		ArrayList<T> treeList =  new ArrayList<T>();
		if(root == null) 
			return treeList;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			treeList.add((T) temp.getData());
			
			if(temp.getRight() != null)
				stack.push(temp.getRight());
			if(temp.getLeft() != null)
				stack.push(temp.getLeft());
		}
		
		return treeList;
	}
	
	public static void main(String[] args) {
		PreOrderTraversalOfBinaryTreeIteratively tree = new PreOrderTraversalOfBinaryTreeIteratively();
		
		tree.createBinaryTree();
		
		ArrayList<Integer> list = tree.preorderTraversal(root);
		
		for(Integer i : list)
			System.out.print(i + " ");
	}

}
