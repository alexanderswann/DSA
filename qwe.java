public class qwe {
    public static void main(String[] args) {
        RBTree tree = new RBTree();

        System.out.println("\n\n\n");

        int[] toAdd = {9,34,65,1,5,65,32,22, 54,23,87,66,43,67,54,12,74,45,98,12,14,23,34,45,74,93,17,19,43,06,54,8,4,6,73,92,67,34,59,30,33,22,99,32,13,9,87,86,85,84,83,82,45,43,23,34,35,36,37,38,39,65,43,43,42,41,40,80,70,60,34,42,54,43,12,32,77,90,84,93,35,75,82,82,82,82,82,38,1,54,43, 34, 33, 32, 99,65,22,23, 9 ,5, 77, 66, 87};
        int[] toRemove = {1,54,43, 34, 33, 32, 99,65,22,23, 9 ,5, 77, 66, 87,34,33,32,22,99,9,87,86,85,84,83,82,45,43,23,34,35,36,37,38,39,65,43,43,42,41,40,80,70,74};
         //int[] toAdd = {34,30,45,38,59,23,32,33,35,42};
         //int[] toRemove = {34,33};

        for (int i = 0; i < toAdd.length; i++ ) {
            System.out.println(tree.add(toAdd[i]));
        }
        System.out.println(tree.levelOrder());
        //
        // System.out.println(tree.levelOrder());

        for (int i = 0; i < toRemove.length; i++ ) {
          System.out.println("removing " + toRemove[i] +tree.levelOrder());
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
