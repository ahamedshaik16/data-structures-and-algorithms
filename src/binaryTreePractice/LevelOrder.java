package binaryTreePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

	public static BinaryTreeNode root;
	
	public void createTree() {
		BinaryTreeNode one = new BinaryTreeNode(10);
		BinaryTreeNode two = new BinaryTreeNode(20);
		BinaryTreeNode three = new BinaryTreeNode(30);
		BinaryTreeNode four = new BinaryTreeNode(40);
		BinaryTreeNode five = new BinaryTreeNode(50);
		BinaryTreeNode six = new BinaryTreeNode(60);
		BinaryTreeNode seven = new BinaryTreeNode(70);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
	}
	
	public List<Integer> levelOrder(){
		List<Integer> result = new ArrayList<>();
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if(temp != null) {
				result.add((Integer) temp.getData());
				if(temp.getLeft() != null) 
					queue.offer(temp.getLeft());
				if(temp.getRight() != null)
					queue.offer(temp.getRight());
			}
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		LevelOrder tree = new LevelOrder();
		tree.createTree();
		List<Integer> list = tree.levelOrder();
		for(Integer each : list)
			System.out.print(each +  " ");
	}
	
}
