package binaryTree;

public class WidthOfBinaryTree {

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
	
	public void inOrderTraversal(TreeNode currentNode) {
		if(currentNode != null) {
			inOrderTraversal(currentNode.getLeft());
			System.out.print(currentNode.getData() + " ");
			inOrderTraversal(currentNode.getRight());
		}
	}
	
	public int maxDepthRecursive(TreeNode currentNode) {
		if(currentNode == null) return 0;
		int leftDepth = maxDepthRecursive(currentNode.getLeft());
		int rightDepth = maxDepthRecursive(currentNode.getRight());
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	public int width(TreeNode currentNode) {
		int max = 0;
		int height = maxDepthRecursive(currentNode);
		for(int k = 0; k < height; k++){
			int temp = width(currentNode, k);
			if(temp > max) max = temp;
		}
		return max;
	}
	
	public int width(TreeNode currentNode, int depth) {
		if(currentNode == null) 
			return 0;
		else {
			if(depth == 0)
				return 1;
			else
				return (width(currentNode.getLeft(), depth -1) + width(currentNode.getRight(), depth-1));
		}
	}
	
	public static void main(String args[]) {
		WidthOfBinaryTree tree = new WidthOfBinaryTree();
		tree.createTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal(root);
		System.out.println();
		System.out.println("Number of nodes in one level: " +tree.width(root));
	}
}
