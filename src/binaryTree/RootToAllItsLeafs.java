package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RootToAllItsLeafs {

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
	
	public void levelOrderTraversal() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null) queue.offer(temp.getLeft());
			if(temp.getRight() != null) queue.offer(temp.getRight());
		}
		
	}
	
	public void printPaths(TreeNode root) {
		int[] paths = new int[256];
		printPaths(root, paths, 0);
	}
	
	public void printPaths(TreeNode root, int[] path, int pathLength) {
		if(root == null) return;
		path[pathLength] = (Integer) root.getData();
		pathLength++;
		if(root.getLeft() == null && root.getRight() == null)
			printArray(path, pathLength);
		else {
			printPaths(root.getLeft(), path, pathLength);
			printPaths(root.getRight(), path, pathLength);
		}
	}
	
	public void printArray(int[] path, int pathLength) {
		for(int i = 0; i < pathLength; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}
	
	public static void main(String args[]) {
		RootToAllItsLeafs tree  = new RootToAllItsLeafs();
		tree.createTree();
		System.out.println("Tree: ");
		tree.levelOrderTraversal();
		System.out.println();
		System.out.println("Paths:");
		tree.printPaths(root);
	}
	
	
	
	
}
