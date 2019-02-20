package binaryTreePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIteratively {

	public static BinaryTreeNode root;
	
	public void createTree() {
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
	
	public List<Integer> postOrder() {
		List<Integer> result = new ArrayList<>();
		
		BinaryTreeNode prev = null;
		
		
		Stack<BinaryTreeNode> stack = new Stack();
		stack.push(root);
		while(!stack.isEmpty()) {
			BinaryTreeNode curr = stack.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
				if(curr.getLeft() != null)
					stack.push(curr.getLeft());
				else if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else if(curr.getLeft() == prev){
				if(curr.getRight() != null)
					stack.push(curr.getRight());
			} else {
				result.add((Integer) curr.getData());
				stack.pop();
			}
			prev = curr;
		}
		
		return result;
	}
	
	
	public static void main(String args[]) {
		PostOrderTraversalIteratively tree = new PostOrderTraversalIteratively();
		tree.createTree();
		List<Integer> list = tree.postOrder();
		for(Integer each : list)
			System.out.print(each + " ");
	}
}
