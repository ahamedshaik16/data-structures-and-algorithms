package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertAnElementInBinaryTree {

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
	
	public TreeNode insertAnElement(int data){
		TreeNode newNode = new TreeNode(data);
		if(root == null)
			root = newNode;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp != null) {
				if(temp.getLeft() != null){
					queue.offer(temp.getLeft());
				} else {
					temp.setLeft(newNode);
					return root;
				}
				if(temp.getRight() != null) {
					queue.offer(temp.getRight());
				} else {
					temp.setRight(temp.getRight());
					return root;
				}
			}
		}
		return root;
	}
	
	public void postOrderTraversal(TreeNode root) {
		if(root != null) {
			postOrderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			postOrderTraversal(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		InsertAnElementInBinaryTree tree = new InsertAnElementInBinaryTree();
		
		tree.createBinaryTree();
		System.out.println("Before Inserting ");
		tree.postOrderTraversal(root);
		
		tree.insertAnElement(180);
		System.out.println("After inserting ");
		tree.postOrderTraversal(root);
		

	}

}
