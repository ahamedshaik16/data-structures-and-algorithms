package binarySearchTree;

public class CountNumberOfPossibleTreesInBinarySearchTreeWithNNodes {

	public int numberOfPossibleTrees(int numberOfNodes) {
		int N[] = new int[50];
		N[0] = N[1] = 1;
		for(int i = 2; i <= numberOfNodes; i++) {
			N[i] = 0;
			for(int j = 0; j < i; j++) {
				N[i] += N[j] * N[i - j -1];
			}
		}
		return N[numberOfNodes];
	}
	
	public static void main(String args[]) {
		CountNumberOfPossibleTreesInBinarySearchTreeWithNNodes tree = new CountNumberOfPossibleTreesInBinarySearchTreeWithNNodes();
		System.out.println("Possible trees with 2 nodes: " + tree.numberOfPossibleTrees(2));
		System.out.println("Possible trees with 3 nodes: " + tree.numberOfPossibleTrees(3));
		System.out.println("Possible trees with 4 nodes: " + tree.numberOfPossibleTrees(4));
		System.out.println("Possible trees with 5 nodes: " + tree.numberOfPossibleTrees(5));
	}
	
}
