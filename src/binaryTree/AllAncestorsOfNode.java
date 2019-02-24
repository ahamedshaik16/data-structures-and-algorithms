package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class AllAncestorsOfNode {

	public static TreeNode root;
	public static TreeNode searchNode;
	
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
		searchNode = seven;
		
		seven.setLeft(eight);
	}
	
	public void levelOrder(){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null) queue.offer(temp.getLeft());
			if(temp.getRight() != null) queue.offer(temp.getRight());
		}
		System.out.println();		
	}
	
	public void printPath(TreeNode root, TreeNode searchNode) {
		int[] paths = new int[256];
		printpath(root, searchNode, paths, 0);
	}
	
	public boolean printpath(TreeNode root, TreeNode searchNode, int[] paths, int pathLength) {
		if(root == null) return false;
		paths[pathLength] = (Integer) root.getData();
		pathLength++;
//		if(root.getLeft() == null && root.getRight() == null) {
			if(root.getData() == searchNode.getData()) {
				printArray(paths, pathLength);
			}
//		}
		else {
			printpath(root.getLeft(), searchNode, paths, pathLength);
			printpath(root.getRight(), searchNode, paths, pathLength);
		}
		return false;
	}
	
	public void printArray(int[] paths, int pathLength) {
		for(int i = 0; i < pathLength; i++) 
			System.out.print(paths[i] + " ");
		System.out.println();
	}
	
	public static void main(String args[]) {
		AllAncestorsOfNode tree = new AllAncestorsOfNode();
		tree.createTree();
		System.out.println("Tree:");
		tree.levelOrder();
		System.out.println();
		System.out.println("Path of node 70:");
		tree.printPath(root, searchNode);
		
		System.out.println("Path of node 80:");
		tree.printPath(root, new TreeNode(80));
	}
}
