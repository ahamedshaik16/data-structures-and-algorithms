package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {

	public static int diameter = 0;
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
//		TreeNode nine = new TreeNode(90);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
		
//		eight.setRight(nine);
	}
	
	public void levelOrderTraversal() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if(temp.getLeft() != null) queue.offer(temp.getLeft());
			if(temp.getRight() != null) queue.offer(temp.getRight());
		}
		
	}
	
	public int diameterOfTree(TreeNode currentNode) {
		int leftDepth, rightDepth;
		if(currentNode == null) return 0;
		leftDepth = diameterOfTree(currentNode.getLeft());
		rightDepth = diameterOfTree(currentNode.getRight());
		if((leftDepth + rightDepth) > diameter)
			diameter = leftDepth + rightDepth;
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	public int diameter(TreeNode currentNode) {
		if(currentNode == null) return 0;
		int length1 = height(currentNode.getLeft()) + height(currentNode.getRight());
		int length2 = Math.max(diameter(currentNode.getLeft()), diameter(currentNode.getRight()));
		return Math.max(length1, length2);
	}
	
	private int height(TreeNode currentNode) {
		if(currentNode == null) return 0;
		int leftDepth = height(currentNode.getLeft());
		int rightDepth = height(currentNode.getRight());
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	public static void main(String args[]) {
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		tree.createTree();
		System.out.println("Tree: ");
		tree.levelOrderTraversal();
		System.out.println();
		
		/**Method 1**/
		tree.diameterOfTree(root);
		System.out.println("Diameter of tree: " + diameter);
		
		/** Method 2**/
		System.out.println("Diameter of tree: " + tree.diameter(root));
	}
}
