package binarySearchTree;

public class CreateOtherBinarySearchTree {

	public static BinarySearchTreeNode root;
	
	public void createTree() {
		BinarySearchTreeNode one = new BinarySearchTreeNode(50);
		BinarySearchTreeNode two = new BinarySearchTreeNode(16);
		BinarySearchTreeNode three = new BinarySearchTreeNode(90);
		BinarySearchTreeNode four = new BinarySearchTreeNode(14);
		BinarySearchTreeNode five = new BinarySearchTreeNode(10);
		BinarySearchTreeNode six = new BinarySearchTreeNode(15);
		BinarySearchTreeNode seven = new BinarySearchTreeNode(5);
		BinarySearchTreeNode eight = new BinarySearchTreeNode(40);
		BinarySearchTreeNode nine = new BinarySearchTreeNode(35);
		BinarySearchTreeNode ten = new BinarySearchTreeNode(45);
		BinarySearchTreeNode eleven = new BinarySearchTreeNode(32);
		BinarySearchTreeNode twelve = new BinarySearchTreeNode(36);
		BinarySearchTreeNode thirteen = new BinarySearchTreeNode(37);
		BinarySearchTreeNode fourteen = new BinarySearchTreeNode(78);
		BinarySearchTreeNode fifteen = new BinarySearchTreeNode(100);
		BinarySearchTreeNode sixteen = new BinarySearchTreeNode(75);
		BinarySearchTreeNode seventeen = new BinarySearchTreeNode(82);
		BinarySearchTreeNode eighteen = new BinarySearchTreeNode(81);
		BinarySearchTreeNode nineteen = new BinarySearchTreeNode(85);
		BinarySearchTreeNode twenty = new BinarySearchTreeNode(79);
		BinarySearchTreeNode twentyone = new BinarySearchTreeNode(87);
		
		root = one;
		
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(eight);
		
		four.setLeft(five);
		four.setRight(six);
		
		five.setLeft(seven);
		
		eight.setLeft(nine);
		eight.setRight(ten);
		
		nine.setLeft(eleven);
		nine.setRight(twelve);
		
		twelve.setRight(thirteen);
		
		three.setLeft(fourteen);
		three.setRight(fifteen);
		
		fourteen.setLeft(sixteen);
		fourteen.setRight(seventeen);
		
		seventeen.setLeft(eighteen);
		seventeen.setRight(nineteen);
		
		eighteen.setLeft(twenty);
		
		nineteen.setRight(twentyone);
		
	}
}
