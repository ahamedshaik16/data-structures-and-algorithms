package binaryTree;

public class SumOfElementsInBinaryTreeRecursively {

	public static TreeNode<Integer> root;
	
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
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
	}
	
	public void inOrderTraversal(TreeNode currentNode){
		if(currentNode == null) {
			inOrderTraversal(currentNode.getLeft());
			System.out.print(currentNode.getData() + " ");
			inOrderTraversal(currentNode.getRight());
		}
	}
	
	public int sumOfAllElements(TreeNode currentNode) {
		if(currentNode == null) return 0;
		else 
			return (((Integer) currentNode.getData()) + (sumOfAllElements(currentNode.getLeft()) + (sumOfAllElements(currentNode.getRight()))));
	}
	
	public static void main(String args[]) {
		SumOfElementsInBinaryTreeRecursively tree = new SumOfElementsInBinaryTreeRecursively();
		tree.createTree();
		System.out.println("Tree: ");
		tree.inOrderTraversal(root);
		System.out.println();
		System.out.println("Sum of all elements: " + tree.sumOfAllElements(root));
	}
}
