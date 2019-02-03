package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTreeWithourRecursion {

	public static TreeNode root;
	
	public void createBinaryTree(){
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
	
	public int size() {
		Queue<TreeNode> queue = new LinkedList<>();
		int count = 0;
		queue.offer(root);
		
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			count++;
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		return count;
	}
	
	public static void main(String args[]){
		SizeOfBinaryTreeWithourRecursion tree = new SizeOfBinaryTreeWithourRecursion();
		tree.createBinaryTree();
		System.out.println("Size:: " + tree.size());
	}
}
