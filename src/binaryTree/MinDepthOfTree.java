package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfTree {

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
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public void levelOrderTraversal() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			System.out.print(currentNode.getData() + " ");
			if(currentNode.getLeft() != null)
				queue.offer(currentNode.getLeft());
			if(currentNode.getRight() != null)
				queue.offer(currentNode.getRight());
		}		
	}
	
	public int minDepth(){
		int count = 1;
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			if(currentNode != null) {
				if(currentNode.getLeft() == null || currentNode.getRight() == null)
					return count;
				if(currentNode.getLeft() != null)
					queue.offer(currentNode.getLeft());
				if(currentNode.getRight() != null)
					queue.offer(currentNode.getRight());
			} else {
				if(!queue.isEmpty()) {
					count++;
//					queue.offer(null);
				}
			}
		}
		
		return count;
	}
	
	public static void main(String args[]) {
		MinDepthOfTree tree = new MinDepthOfTree();
		tree.createTree();
		System.out.println("Tree: ");
		tree.levelOrderTraversal();
		System.out.println();
		System.out.println("Min Depth: " + tree.minDepth());
	}
	
	
	
	
	
	
	
}
