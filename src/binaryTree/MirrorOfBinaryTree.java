package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorOfBinaryTree {

	public static TreeNode root;
	
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
	
	public void levelOrder(){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null) queue.offer(temp.getLeft());
			if(temp.getRight() != null) queue.offer(temp.getRight());
		}
		System.out.println();		
	}
	
	public TreeNode mirrorTree(TreeNode currentNode) {
		TreeNode temp;
		if(currentNode != null){
			mirrorTree(currentNode.getLeft());
			mirrorTree(currentNode.getRight());
			temp = currentNode.getLeft();
			currentNode.setLeft(currentNode.getRight());
			currentNode.setRight(temp);
		}
		return currentNode;
	}
	
	public static void main(String args[]) {
		MirrorOfBinaryTree tree = new MirrorOfBinaryTree();
		tree.createTree();
		System.out.println("Original Tree:");
		tree.levelOrder();
		tree.mirrorTree(root);
		System.out.println();
		System.out.println("Mirrored Tree");
		tree.levelOrder();
	}
	
	
	
	
	
	
}
