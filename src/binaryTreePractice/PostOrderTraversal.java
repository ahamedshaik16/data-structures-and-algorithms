package binaryTreePractice;

public class PostOrderTraversal {

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
	
	public void postOrder(BinaryTreeNode currentNode) {
		if(currentNode != null) {
			postOrder(currentNode.getLeft());
			postOrder(currentNode.getRight());
			System.out.print(currentNode.getData() + " ");
		}
	}
	
	public static void main(String args[]) {
		PostOrderTraversal tree =  new PostOrderTraversal();
		
		tree.createTree();
		tree.postOrder(root);
	}
}
