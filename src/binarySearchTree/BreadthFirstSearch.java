package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

public static BinarySearchTreeNode root;
	
	public void createTree() {
		BinarySearchTreeNode one = new BinarySearchTreeNode(1);
		BinarySearchTreeNode two = new BinarySearchTreeNode(2);
		BinarySearchTreeNode three = new BinarySearchTreeNode(3);
		BinarySearchTreeNode four = new BinarySearchTreeNode(4);
		BinarySearchTreeNode five = new BinarySearchTreeNode(5);
		BinarySearchTreeNode six = new BinarySearchTreeNode(6);
		BinarySearchTreeNode seven = new BinarySearchTreeNode(7);
		BinarySearchTreeNode eight = new BinarySearchTreeNode(8);
		BinarySearchTreeNode nine = new BinarySearchTreeNode(9);
		BinarySearchTreeNode ten = new BinarySearchTreeNode(10);
		BinarySearchTreeNode eleven = new BinarySearchTreeNode(11);
		BinarySearchTreeNode twelve = new BinarySearchTreeNode(12);
		
		root = one;
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		four.setLeft(eight);
		four.setRight(nine);
		
		six.setLeft(ten);
		six.setRight(eleven);
		
		seven.setRight(twelve);
		
	}
	
	public void levelOrder(BinarySearchTreeNode currentNode) {
		Queue<BinarySearchTreeNode> queue = new LinkedList<>();
		queue.offer(currentNode);
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			System.out.print(currentNode.getData() + " ");
			if(currentNode.getLeft() != null)
				queue.offer(currentNode.getLeft());
			if(currentNode.getRight() != null)
				queue.offer(currentNode.getRight());
		}
	}
	public static void main(String args[]) {
		BreadthFirstSearch tree = new BreadthFirstSearch();
		tree.createTree();
		System.out.println("Level order traversal: ");
		tree.levelOrder(root);
		System.out.println();
	}
	
	
	
	
}
