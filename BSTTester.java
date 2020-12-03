public class BSTTester {
    public static void main(String[] args) {
        AVL arrTree = new AVL();


        System.out.println(arrTree.isEmpty());

        arrTree.insert(7);
				System.out.println(arrTree.isEmpty());
				arrTree.delete(7);
				System.out.println(arrTree.isEmpty());
				arrTree.insert(1);
				arrTree.insert(0);
				arrTree.insert(3);
				arrTree.insert(2);
				arrTree.insert(5);
				arrTree.insert(4);
				arrTree.insert(6);
				arrTree.insert(9);
				arrTree.insert(8);
				arrTree.insert(10);
        arrTree.insert(12);
        arrTree.insert(11);
        arrTree.insert(6);
        arrTree.insert(7);
        arrTree.insert(7);
				System.out.println(arrTree);


				        arrTree.insert(4);
								arrTree.insert(2);
								arrTree.insert(3);
								arrTree.insert(4);
								arrTree.insert(5);
								arrTree.insert(6);

								System.out.println(arrTree.find(4));






        System.out.println(arrTree.preOrder());

        System.out.println(arrTree.ind(arrTree.findParent(4)));
        System.out.println("remove 12, -20");
        arrTree.delete(12);
        arrTree.delete(0);
				arrTree.delete(1);
				arrTree.delete(1);
				arrTree.delete(6);

        System.out.print("parent of 10 is ");
        System.out.println(arrTree.ind(arrTree.findParent(10)));
        System.out.print("items in list ");
        System.out.println(arrTree.ind(0));
				arrTree.insert(6);
        System.out.println(arrTree);

				System.out.println(arrTree.Ncase(1));
				System.out.println(arrTree.Ncase(3));
				System.out.println(arrTree.Ncase(6));
				System.out.println(arrTree.Ncase(7));
				System.out.println(arrTree.Ncase(8));

				System.out.println("items in list ");
				System.out.println(arrTree.find(-5));
//test all the leaf cases



        System.out.println(arrTree.preOrder());
        System.out.println(arrTree.postOrder());
        System.out.println(arrTree.inOrder());

        System.out.println(arrTree.ind(arrTree.findParent(4)));
				System.out.println("max and min");
        System.out.println(arrTree.max());
        System.out.println(arrTree.min());

        System.out.println(arrTree.find(4));
        System.out.println(arrTree.find(5));

        System.out.println(arrTree.contains(4));
        System.out.println(arrTree.contains(5));
        System.out.println(arrTree.isEmpty());
        System.out.println("index " +arrTree.findParent(4));

        // System.out.println("___________\nTest Against the tree");
				//
        // BinarySearchTree tree = new BinarySearchTree();
				//
        // tree.add(7);
        // tree.add(1);
        // tree.add(0);
        // tree.add(3);
        // tree.add(2);
        // tree.add(5);
        // tree.add(4);
				// tree.add(6);
				// tree.add(9);
				// tree.add(8);
				// tree.add(10);
				//
        // System.out.println(tree.preOrder());
				//
        // //System.out.println(tree.findParent(4));
        // System.out.println("remove 8");
        // tree.remove(8);
				//
        // System.out.print("parent of 12 is ");
        // System.out.println(tree.findParent(12));
				//
				//
        // System.out.println(tree.preOrder());
				//
        // System.out.println(tree.findParent(4));
    }

}
