package binaryTreePractice;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfTreeIteratively {

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
	
	public void inOrderTraversal(BinaryTreeNode currentNode) {
		if(currentNode != null){
			inOrderTraversal(currentNode.getLeft());
			System.out.print(currentNode.getData() + " ");
			inOrderTraversal(currentNode.getRight());
		}
	}
	
	public int size() {
		int count = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			count++;
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		return count;	
	}
	
	public static void main(String args[]) {
		SizeOfTreeIteratively tree = new SizeOfTreeIteratively();
		tree.createTree();
		System.out.println("Tree:");
		tree.inOrderTraversal(root);
		System.out.println();
		System.out.println("Size: " + tree.size());
	}
	
	
	
}
