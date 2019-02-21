package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckTheSumInRootToLeafPathsRecursively {

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
	
	public void levelOrder(TreeNode currentNode) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null) queue.offer(temp.getLeft());
			if(temp.getRight() != null) queue.offer(temp.getRight());
		}
	}
	
	public boolean hasSumInPaths(TreeNode currentNode, int sum) {
		if(currentNode == null) return false;
		if((currentNode.getLeft() == null) && (currentNode.getRight() == null) && ((Integer) currentNode.getData() == sum)) return true;
		return hasSumInPaths(currentNode.getLeft(), sum - (Integer) currentNode.getData()) || hasSumInPaths(currentNode.getRight(), sum - (Integer) currentNode.getData());
	}

	public static void main(String args[]) {
		CheckTheSumInRootToLeafPathsRecursively tree = new CheckTheSumInRootToLeafPathsRecursively();
		tree.createTree();
		System.out.println("Tree:");
		tree.levelOrder(root);
		System.out.println();
		System.out.println("220 sum exists: " + tree.hasSumInPaths(root, 220));
		System.out.println("190 sum exists: " + tree.hasSumInPaths(root, 190));
		System.out.println("100 sum exists: " + tree.hasSumInPaths(root, 100));
	}
	
	
}
