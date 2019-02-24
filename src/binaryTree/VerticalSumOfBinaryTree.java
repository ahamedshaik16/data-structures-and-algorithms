package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class VerticalSumOfBinaryTree {

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
	
	public void inOrderTraversal(TreeNode currentNode) {
		if(currentNode != null) {
			inOrderTraversal(currentNode.getLeft());
			System.out.print(currentNode.getData() + " ");
			inOrderTraversal(currentNode.getRight());
		}
	}
	
	public void verticalSum(TreeNode root) {
		if(root == null) return;
		Map<Integer, Integer> hashMap = new HashMap<>();
		 verticalSum(hashMap, root, 0);
		 for(int k : hashMap.keySet()) {
			 System.out.println("pos: " + k + " sum " + hashMap.get(k));
		 }
	}
	
	
	public void verticalSum(Map<Integer, Integer> hashMap, TreeNode currentNode, int horizontalDistance) {
		if(currentNode == null) return;
		if(currentNode.getLeft() != null) 
			verticalSum(hashMap, currentNode.getLeft(), horizontalDistance - 1);
		if(currentNode.getRight() != null)
			verticalSum(hashMap, currentNode.getRight(), horizontalDistance + 1);
		int data = 0;
		if(hashMap.containsKey(horizontalDistance))
			data = hashMap.get(horizontalDistance);
		hashMap.put(horizontalDistance, (Integer) currentNode.getData() + data);
	}
	
	public static void main(String args[]) {
		VerticalSumOfBinaryTree tree =  new VerticalSumOfBinaryTree();
		tree.createTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal(root);
		System.out.println();
		tree.verticalSum(root);
	}
}
