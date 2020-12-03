public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean add(int thing) {
        if (root == null) {
            root = new Node(thing);
            return true;
        } else {
            return add(root, thing);
        }
    }

    private boolean add(Node curr, int thing) {
        if (curr.data == thing) {
            return false;
        } else if (thing < curr.data) {
            if (curr.left == null) {
                curr.left = new Node(thing);
                return true;
            } else {
                return add(curr.left, thing);
            }
        } else {
            if (curr.right == null) {
                curr.right = new Node(thing);
                return true;
            } else {
                return add(curr.right, thing);
            }
        }
    }

    public int findMinRec() {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return findMinRec(root);
    }

    private int findMinRec(Node curr) {
        if (curr.left == null) {
            return curr.data;
        } else {
            return findMinRec(curr.left);
        }
    }

    public int findMinIter() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            Node curr = root;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.data;
        }
    }

    public int findMaxRec() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return findMaxRec(root);
    }

    private int findMaxRec(Node curr) {
        if (curr.right == null) {
            return curr.data;
        } else {
            return findMaxRec(curr.right);
        }
    }

    public int findMaxIter() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            Node curr = root;
            while (curr.right != null) {
                curr = curr.right;
            }
            return curr.data;
        }
    }

    public boolean contains(int toFind) {
        if (root == null) {
            return false;
        } else {
            return contains(root, toFind);
        }
    }

    private boolean contains(Node curr, int toFind) {
        if (curr == null) {
            return false;
        } else if (curr.data == toFind) {
            return true;
        } else {
            if (toFind < curr.data) {
                return contains(curr.left, toFind);
            } else {
                return contains(curr.right, toFind);
            }
        }

    }

    public boolean remove(int thing) {
        if (!contains(thing)) {
            return false;
        }
        Node parent = findParent(thing);
        if (parent == null) {
            //root case
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null && root.right == null) {
                //exactly one left child
                int pred = findMaxRec(root.left);
                remove(pred);
                root.data = pred;
            } else {
                //i have at least a right child
                int succ = findMinRec(root.right);
                remove(succ);
                root.data = succ;
            }
            return true;
        } else {
            if (thing > parent.data) {
                //thing is on the right
                Node curr = parent.right;
                if (curr.left == null && curr.right == null) { //leaf case
                    parent.right = null;
                } else if (curr.right == null && curr.left != null) { //one left child
                    parent.right = curr.left;
                } else if (curr.right != null && curr.left == null) { //one right child
                    parent.right = curr.right;
                } else {
                    //we have two childs
                    int predecessor = findMaxRec(curr.left);
                    remove(predecessor);
                    curr.data = predecessor;
                }
            } else {
                Node curr = parent.left;
                if (curr.left == null && curr.right == null) { //leaf case
                    parent.left = null;
                } else if (curr.right == null && curr.left != null) { //one left child
                    parent.left = curr.left;
                } else if (curr.right != null && curr.left == null) { //one right child
                    parent.left = curr.right;
                } else {
                    //we have two childs
                    int predecessor = findMaxRec(curr.left);
                    remove(predecessor);
                    curr.data = predecessor;
                }
            }
            return true;
        }
    }

    public int findParentTester(int data) {
        return findParent(data).data;
    }

    public Node findParent(int data) {
        if (root.data == data) {
            return null;
        } else {
            return findParent(root, data);
        }
    }

    private Node findParent(Node curr, int data) {
        if (data > curr.data) {
            if (curr.right == null) {
                return null;
            } else {
                if (curr.right.data == data) {
                    return curr;
                } else {
                    return findParent(curr.right, data);
                }
            }
        } else if (data < curr.data) {
            if (curr.left == null) {
                return null;
            } else {
                if (curr.left.data == data) {
                    return curr;
                } else {
                    return findParent(curr.left, data);
                }
            }
        } else {
            return null;
        }

    }

    private String toReturn = "";
    public String printLevelOrder() {
        int h = height(root);
        int i;
        int Myheight = h;
        for (i = 0; i < h; i++) {

            for (int j = 0; j < (int) Math.pow(2, (Myheight) + 1) - 4; j++) {

                toReturn += " ";

            }

            printGivenLevel(root, i + 1, Myheight);
            Myheight--;
            toReturn += "\n\n";

        }
        return toReturn;

    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    // public int height(Node node)
    // {
    //     if (node == null)
    //        return 0;
    //     else
    //     {
    //         /* compute  height of each subtree */
    //         int lheight = height(node.left);
    //         int rheight = height(node.right);
    //
    //         /* use the larger one */
    //         if (lheight < rheight)
    //             return(rheight+1);
    //         else return(lheight+1);
    //     }
    // }
    public int height(Node node) {

        if (node == null) {
            return 0;
        } else {





            int hl = (node.left == null) ? 0 : height(node.left);
            int hr = (node.right == null) ? 0 : height(node.right);

            return Math.max(hl, hr) + 1;
        }

    }


    /* Print nodes at the given level */
    private void printGivenLevel(Node node, int level, int Myheight) {
        if (node == null && level == 1) {
            toReturn += "[**]";
            for (int i = 0; i < (int) Math.pow(2, (Myheight) + 2) - 4; i++) {

                toReturn += " ";

            }

            return;
        } else if (node == null && level > 1) {
            node = new Node();


            printGivenLevel(node.left, level - 1, Myheight);
            printGivenLevel(node.right, level - 1, Myheight);

        } else if (level == 1 && node != null) {
            int dat = node.data;
            String sign;
            String sign2;
            if (dat % 2 == 0) {
                sign = "{";
                sign2 = "}";
            } else {
                sign = "[";
                sign2 = "]";
            }

            if (dat > -10 && dat < 10) {
                toReturn += sign + "0" + (node.data) + sign2;
            } else {
                toReturn += sign + (node.data) + sign2;
            }




            for (int i = 0; i < (int) Math.pow(2, (Myheight) + 2) - 4; i++) {

                toReturn += " ";

            }

        } else if (level > 1) {
            printGivenLevel(node.left, level - 1, Myheight);
            printGivenLevel(node.right, level - 1, Myheight);
        }
    }



    public String preOrder() {
        return preOrder(root);
    }

    private String preOrder(Node curr) {
        if (curr == null) {
            return "";
        } else {
            String left = preOrder(curr.left);
            String right = preOrder(curr.right);
            return curr.data + " " + left + right;
        }
    }


    class Node {
        Node left, right;
        int data;
        int color; //0 is red, 1 is black

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
            color = 0;
        }

        public Node() {
            left = null;
            right = null;
        }

        public String toString() {
            return "" + data;
        }
    }
}
