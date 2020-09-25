public class BSTTester{
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();

		tree.add(8);
		tree.add(10);
		tree.add(5);

		System.out.println(tree.preOrder());
	}

}
