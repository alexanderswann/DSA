public class qwe {
    public static void main(String[] args) {
        RBTree tree = new RBTree();

        System.out.println("\n\n\n");

        int[] toAdd = {9,34,65,1,5, 54,65,23,87,66,33,22,99,0,43,12,32,77};
        int[] toRemove = {1,0,54,43, 34, 33};//,34,33,32,22,99};


        for (int i = 0; i < toAdd.length; i++ ) {
            tree.add(toAdd[i]);
        }

        System.out.println(tree.levelOrder());

        for (int i = 0; i < toRemove.length; i++ ) {
            tree.remove(toRemove[i]);
        }

// tree.add(66);
// tree.remove(7);
// tree.remove(90);
// tree.remove(65);
// tree.add(75);
// tree.add(98);
// tree.add(22);
// tree.add(23);
// tree.add(82);
// tree.add(2);
// tree.remove(2);
// tree.remove(23);

        System.out.println(tree.levelOrder());
        System.out.print(tree.preOrder());





        // tree.add(40);
        // tree.add(98);
        // tree.add(99);
        // tree.add(70);
        // tree.add(75);
        // System.out.println(tree.levelOrder());
        // tree.add(20);
        // System.out.println(tree.levelOrder());
        // tree.add(93);
        // tree.add(20);
        // System.out.println(tree.levelOrder());
        // tree.add(12);
        // //tree.add(10);
        // System.out.println(tree.levelOrder());
        // tree.add(14);
        // System.out.println(tree.levelOrder());
        // tree.add(16);
        // System.out.println(tree.levelOrder());
        // tree.add(18);
        // System.out.println(tree.levelOrder());
        // //tree.add(20);
        // //System.out.println(tree.levelOrder());
        // tree.add(9);
        // System.out.println(tree.levelOrder());
        // tree.add(4);
        // System.out.println(tree.levelOrder());
        // tree.add(16);
        // System.out.println(tree.levelOrder());
        // tree.add(15);
        // System.out.println(tree.levelOrder());
        // tree.add(90);
        // System.out.println(tree.levelOrder());
        // tree.add(44);
        // System.out.println(tree.levelOrder());
        // tree.add(56);
        // System.out.println(tree.levelOrder());
        // //tree.add(13);
        // System.out.println(tree.levelOrder());
        // tree.add(70);
        // System.out.println(tree.levelOrder());
        // tree.add(30);
        // System.out.println(tree.levelOrder());
        // //tree.add(20);
        // System.out.println(tree.levelOrder());
        // tree.add(35);
        // System.out.println(tree.levelOrder());
        // //tree.add(25);
        // System.out.println(tree.levelOrder());
        // tree.add(27);
        // System.out.println(tree.levelOrder());
        // tree.add(28);
        //
        // tree.add(13);
        // System.out.println(tree.levelOrder());

    }

}
