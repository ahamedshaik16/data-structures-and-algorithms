package binaryTree;

import java.util.List;
import java.util.ArrayList;

public class CheckTheSumInRootToLeafPaths {

	public static TreeNode root;
	
	public static List<Integer> list = new ArrayList<>();
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
	
	public List<Integer> sumExists(TreeNode root){
		int[] paths = new int[256];
		return rootPaths(root, paths, 0);
	}
	
	public List<Integer> rootPaths(TreeNode root, int[] paths, int pathLength) {
		if(root == null) return null;
		paths[pathLength] = (Integer) root.getData();
		pathLength++;
		int result = 0;
		if(root.getLeft() == null && root.getRight() == null) {
			result = eachPath(paths, pathLength);
				list.add(result);
		} else {
			rootPaths(root.getLeft(), paths, pathLength);
			rootPaths(root.getRight(), paths, pathLength);
		}
		
		return list;
	}
	
	
	public int eachPath(int[] paths, int pathLength) {
		boolean result = false;
		int sum = 0;
		for(int i = 0; i < pathLength; i++) {
			System.out.print(paths[i] + " ");
			sum = sum + paths[i];
		}
		System.out.println("  :: Sum:: " + sum);
//		if(sum == givenSum)
//			return true;
		return sum;
	}
	
	public static void main(String args[]) {
		CheckTheSumInRootToLeafPaths tree = new CheckTheSumInRootToLeafPaths();
		tree.createTree();
		System.out.println("Tree:: ");
		tree.inOrderTraversal(root);
		System.out.println();
		List<Integer> resultList = tree.sumExists(root);
		System.out.println("220 sum exists ? " + resultList.contains(220));
		System.out.println("190 sum exists ? " + resultList.contains(190));
		System.out.println("70 sum exists ? " + resultList.contains(70));
	}
	
	
	
	
}
