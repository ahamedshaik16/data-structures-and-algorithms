package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeOfBinaryTree {

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
		TreeNode nine = new TreeNode(90);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
		
		eight.setRight(nine);
	}
	
	public void levelOrderTraversal() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
	}
	
	public TreeNode deepestNode() {
		TreeNode temp = null;
		if(root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		return temp;
	}
	
	public static void main(String args[]) {
		DeepestNodeOfBinaryTree tree = new DeepestNodeOfBinaryTree();
		tree.createTree();
		System.out.println("Tree:: ");
		tree.levelOrderTraversal();
		System.out.println();
		System.out.println("Deepest node: " + tree.deepestNode().getData());
		
	}
}
