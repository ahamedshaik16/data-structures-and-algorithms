package binaryTreePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SizeOfTree {

	public static BinaryTreeNode root;
	
	public void createTree(){
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
	
	public void levelOrderTraversal() {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			result.add(temp.getData());
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		
		for(Integer each : result) 
			System.out.print(each + " ");
		
	}
	
	public int size(BinaryTreeNode root) {
		int leftCount = root.getLeft() == null ? 0 : size(root.getLeft());
		int rightCount = root.getRight() == null ? 0 : size(root.getRight());
		return 1 + leftCount + rightCount;
	}
	
	
	public static void main(String args[]) {
		SizeOfTree tree = new SizeOfTree();
		tree.createTree();
		System.out.println("Tree: ");
		tree.levelOrderTraversal();
		System.out.println();
		System.out.println("Size: " + tree.size(root));
	}
}
