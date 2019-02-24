package binaryTree;

public class LeastCommonAncestorOfTwoNodes {

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
	
	public void preOrderTraversal(TreeNode currentNode) {
		if(currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			preOrderTraversal(currentNode.getLeft());
			preOrderTraversal(currentNode.getRight());
		}
	}
	
	public TreeNode LCA(TreeNode currentNode, TreeNode searchNodeA, TreeNode searchNodeB) {
		TreeNode left, right;
		if(currentNode == null) 
			return currentNode;
		if((currentNode.getData() == searchNodeA.getData()) || (currentNode.getData() == searchNodeB.getData()))
			return currentNode;
		left = LCA(currentNode.getLeft(), searchNodeA, searchNodeB);
		right = LCA(currentNode.getRight(), searchNodeA, searchNodeB);
		if(left != null && right != null)
			return currentNode;
		else {
			return (left != null ? left : right);
		}	
	}
	
	public static void main(String args[]) {
		LeastCommonAncestorOfTwoNodes tree = new LeastCommonAncestorOfTwoNodes();
		tree.createTree();
		System.out.println("Preorder raverrsal:");
		tree.preOrderTraversal(root);
		System.out.println();
		System.out.println("LCA of 50 and 80: " + tree.LCA(root, new TreeNode(50), new TreeNode(80)).getData());
	}
	
}
