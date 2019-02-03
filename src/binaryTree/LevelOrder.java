package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

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
	
	public <T> ArrayList<T> levelOrder() {
		ArrayList<T> finalList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp != null) {
				finalList.add((T)temp.getData());
				if(temp.getLeft() != null)
					queue.offer(temp.getLeft());
				if(temp.getRight() != null)
					queue.offer(temp.getRight());
			}
		}
		
		queue.offer(null);
		
		return finalList;
		
	}
	
	public static void main(String[] args) {
		LevelOrder tree = new LevelOrder();
		
		tree.createBinaryTree();
		
		ArrayList<Integer> list = tree.levelOrder();
		
		for(Integer i : list)
			System.out.print(i + " ");
	}

}
