public class BSTTester{
	public static void main(String[] args){
    ArrayBST arrTree = new ArrayBST();

    arrTree.insert(9);
    arrTree.insert(0);
    arrTree.insert(3);
    arrTree.insert(10);
    arrTree.insert(4);



    System.out.println(arrTree);
    System.out.println(arrTree.preOrder());

    System.out.println(arrTree.max());
    System.out.println(arrTree.min());

    System.out.println(arrTree.find(4));
    System.out.println(arrTree.find(5));

    System.out.println(arrTree.contains(4));
    System.out.println(arrTree.contains(5));

		BinarySearchTree tree = new BinarySearchTree();

    tree.add(9);
    tree.add(0);
    tree.add(3);
    tree.add(10);
    tree.add(4);


		System.out.println(tree.preOrder());
	}

}
