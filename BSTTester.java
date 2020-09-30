public class BSTTester {
    public static void main(String[] args) {
        ArrayBST arrTree = new ArrayBST();


        //System.out.println(arrTree.isEmpty());

        arrTree.insert(8);
        arrTree.insert(10);
        arrTree.insert(5);
        arrTree.insert(12);
        arrTree.insert(11);
        arrTree.insert(6);
        arrTree.insert(7);
        arrTree.insert(7);





        System.out.println(arrTree.preOrder());

        //System.out.println(arrTree.ind(arrTree.findParent(4)));
        System.out.println("remove 8");
        arrTree.delete(8);
        arrTree.delete(8);
        System.out.print("parent of 12 is ");
        System.out.println(arrTree.ind(arrTree.findParent(12)));
        System.out.print("items in list ");
        System.out.println(arrTree.ind(0));

        //System.out.println(arrTree);




        System.out.println(arrTree.preOrder());
        //System.out.println(arrTree.postOrder());
        //System.out.println(arrTree.inOrder());

        //System.out.println(arrTree.ind(arrTree.findParent(4)));

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

        System.out.println("___________\nTest Against the tree");

        BinarySearchTree tree = new BinarySearchTree();

        tree.add(8);
        tree.add(10);
        tree.add(5);
        tree.add(12);
        tree.add(11);
        tree.add(6);
        tree.add(7);

        System.out.println(tree.preOrder());

        //System.out.println(tree.findParent(4));
        System.out.println("remove 8");
        tree.remove(8);

        System.out.print("parent of 12 is ");
        System.out.println(tree.findParent(12));


        System.out.println(tree.preOrder());

        //System.out.println(tree.findParent(4));
    }

}
