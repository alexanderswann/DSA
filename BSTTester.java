public class BSTTester{
	public static void main(String[] args){
    ArrayBST arrTree = new ArrayBST();


    //System.out.println(arrTree.isEmpty());

		arrTree.insert(9);
		arrTree.insert(0);
		arrTree.insert(3);
		arrTree.insert(10);
		arrTree.insert(4);
		arrTree.insert(2);





		System.out.println(arrTree.preOrder());

		System.out.println(arrTree.tranm(arrTree.findParent(4)));

		arrTree.remove(0);



    // System.out.println(arrTree.inOrder());
    System.out.println(arrTree.preOrder());
    // System.out.println(arrTree.postOrder());

		System.out.println(arrTree.tranm(arrTree.findParent(4)));

    // System.out.println(arrTree.max());
    // System.out.println(arrTree.min());
    //
    // System.out.println(arrTree.find(4));
    // System.out.println(arrTree.find(5));
    //
    // System.out.println(arrTree.contains(4));
    // System.out.println(arrTree.contains(5));
    // System.out.println(arrTree.isEmpty());
    // System.out.println("index " +arrTree.findParent(4));

		BinarySearchTree tree = new BinarySearchTree();

    tree.add(9);
    tree.add(0);
    tree.add(3);
    tree.add(10);
    tree.add(4);
		tree.add(2);

		System.out.println(tree.preOrder());

    System.out.println(tree.findParent(4));

    tree.remove(0);


		System.out.println(tree.preOrder());

		System.out.println(tree.findParent(4));
	}

}
