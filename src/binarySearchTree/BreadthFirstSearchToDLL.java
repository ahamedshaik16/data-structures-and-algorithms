package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchToDLL extends CreateBinarySearchTree{
	public BinarySearchTreeNode head, prev;

	public void levelOrder() {
		Queue<BinarySearchTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		BinarySearchTreeNode currentNode;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			System.out.print(currentNode.getData() + " ");
			if(currentNode.getLeft() != null)
				queue.offer(currentNode.getLeft());
			if(currentNode.getRight() != null)
				queue.offer(currentNode.getRight());
		}
	}
	
	public void BFSToDLL() {
		Queue<BinarySearchTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		BinarySearchTreeNode currentNode;
		while(!queue.isEmpty()) {
			currentNode = queue.poll();
			BinarySearchTreeNode newNode = new BinarySearchTreeNode(currentNode.getData());
			if(prev == null) 
				head = newNode;
			else {
				prev.setRight(newNode);
				newNode.setLeft(prev);
			}
			prev = newNode;
			if(currentNode.getLeft() != null)
				queue.offer(currentNode.getLeft());
			if(currentNode.getRight() != null)
				queue.offer(currentNode.getRight());
		}
	}
	
	public void printList() {
		BinarySearchTreeNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getRight();
		}
	}
	
	public static void main(String args[]) {
		BreadthFirstSearchToDLL tree = new BreadthFirstSearchToDLL();
		tree.createBinarySearchTree();
		System.out.println("Level order traversal:");
		tree.levelOrder();
		tree.BFSToDLL();
		System.out.println();
		System.out.println("Doubly linked list");
		tree.printList();
	}
	
	
	
	
	
}
