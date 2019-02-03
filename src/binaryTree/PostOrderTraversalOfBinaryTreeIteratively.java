package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalOfBinaryTreeIteratively {

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
	
	public <T> ArrayList<T> postOrderTraversal(){
		ArrayList<T> res = new ArrayList<>();
		
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
			} else if(curr.getLeft() == prev){
				if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else {
				res.add((T) curr.getData());
				stack.pop();
			}
			prev = curr;
		}
		
		
		return res;
	}
	
	public static void main(String[] args) {
		PostOrderTraversalOfBinaryTreeIteratively tree = new PostOrderTraversalOfBinaryTreeIteratively();
		
		tree.createBinaryTree();
		
		ArrayList<Integer> list = tree.postOrderTraversal();
		for(Integer i : list)
			System.out.print(i + " ");
	}

}
