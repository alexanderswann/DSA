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

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        public String toString() {
            return "" + data;
        }
    }
}
