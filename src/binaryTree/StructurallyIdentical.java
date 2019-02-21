package binaryTree;

public class StructurallyIdentical {

	public static TreeNode root1;
	public static TreeNode root2;
	public static TreeNode root3;
	
	public TreeNode createTree1(TreeNode baseRoot) {
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		
		baseRoot = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		
		return baseRoot;
	}
	
	public TreeNode createTree2(TreeNode baseRoot) {
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		
		baseRoot = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		
		return baseRoot;
	}
	
	public TreeNode createTree3(TreeNode baseRoot) {
		TreeNode one = new TreeNode(10);
		TreeNode two = new TreeNode(20);
		TreeNode three = new TreeNode(30);
		TreeNode four = new TreeNode(40);
		TreeNode five = new TreeNode(50);
		TreeNode six = new TreeNode(60);
		TreeNode seven = new TreeNode(70);
		TreeNode eight = new TreeNode(80);
		
		baseRoot = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		
		three.setLeft(six);
		three.setRight(seven);
		
		seven.setLeft(eight);
		
		return baseRoot;
	}
	
	public static boolean isStructurallyIdentical(TreeNode baseRoot1, TreeNode baseRoot2) {
		if(baseRoot1 == null && baseRoot2 == null)
			return true;
		if(baseRoot1 == null || baseRoot2 == null)
			return false;
		return ((baseRoot1.getData() == baseRoot2.getData()) && (isStructurallyIdentical(baseRoot1.getLeft(), baseRoot2.getLeft()) && (isStructurallyIdentical(baseRoot1.getRight(), baseRoot2.getRight()))));
	}
	
	public static void main(String args[]) {
		StructurallyIdentical tree1 = new StructurallyIdentical();
		root1 = tree1.createTree1(root1);
		
		StructurallyIdentical tree2 = new StructurallyIdentical();
		root2 = tree2.createTree2(root2);
		
		StructurallyIdentical tree3 = new StructurallyIdentical();
		root3= tree3.createTree3(root3);
		
		System.out.println("Are Tree1 and Tree2 identical: " + isStructurallyIdentical(root1, root2));
		System.out.println("Are Tree1 and Tree3 identical: " + isStructurallyIdentical(root1, root3));
	}
}
