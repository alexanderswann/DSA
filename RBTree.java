public class RBTree {
    Node root;

    public RBTree() {
        root = null;
    }


    //0 is left, 1 is right// red is 0, black is 1

    public boolean add(int ourData) {
        if (root == null) {
            root = new Node(ourData, 1);
            values(ourData, -1,-1,-1,-1,-1);
            return true;
        } else {
            return add(root, ourData, -1, 1, -1, -1);
        }
    }


    private boolean add(Node curr, int ourData, int parentPointer, int parentcolor, int uncleColor, int siblingColor) {
        if (curr.data == ourData) {
            return false;
        } else if (ourData < curr.data) {
            if (curr.left == null) {
                curr.left = new Node(ourData, 0);
                values(ourData, parentPointer,0, curr.color,curr.right != null ? curr.right.color : -1, siblingColor);
                return true;
            } else {

                return add(curr.left, ourData, 0, curr.color, siblingColor, curr.right != null ? curr.right.color : -1);
            }
        } else {
            if (curr.right == null) {
                curr.right = new Node(ourData, 0);
                values(ourData, parentPointer,1, curr.color,curr.left != null ? curr.left.color : -1, siblingColor);
                return true;
            } else {
                return add(curr.right, ourData,1, curr.color,siblingColor, curr.left != null ? curr.left.color : -1);
            }
        }
    }

    public String values (int data, int parentPointer, int ourPointer, int parentColor, int siblingColor,int uncleColor) {
      String toReturn = "\n\nOur Data is " + data;

      if(parentPointer == 0){
        toReturn += "\nThe parent is on the left\n";
      }else if(parentPointer == 1){
        toReturn += "\nThe parent is on the right\n";
      }else{
        toReturn += ourPointer >=0 ?"\nOur parent is the root\n":"\nWe are the root\n";
      }

      if(ourPointer == 0){
        toReturn += "We are on the left\n";
      }else if(ourPointer == 1){
        toReturn += "We are on the right\n";
      }else{
        toReturn += "We are the root\n";
      }

      if(parentColor == 0){
        toReturn += "The parent is red\n";
      }else if(parentColor == 1){
        toReturn += "The parent is black\n";
      }else{
        toReturn += "There is no parent\n";
      }


      if(uncleColor == 0){
        toReturn += "The uncle is red\n";
      }else if(uncleColor == 1){
        toReturn += "The uncle is black\n";
      }else{
        toReturn += "There is no uncle\n";
      }

      if(siblingColor == 0){
        toReturn += "The sibling is red\n";
      }else if(siblingColor == 1){
        toReturn += "The sibling is black\n";
      }else{
        toReturn += "There is no sibling\n";
      }

      System.out.println(toReturn);

      return toReturn;

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

    public boolean remove(int ourData) {
        if (!contains(ourData)) {
            return false;
        }
        Node parent = findParent(ourData);
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
            if (ourData > parent.data) {
                //ourData is on the right
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
    // private int state(Node node){
    //   if(node.color == null){
    //     return -1;
    //   }else if(node.color == 1){
    //     return 1;
    //   }
    // }

      /*
    private boolean acessData(Node curr, int ourData, int parentPointer, int parentcolor, int uncleColor, int siblingcolor){
      if (curr.data == ourData) {
          return true;
      } else if (ourData < curr.data) {
          if (curr.left == null) {
              curr.left = new Node(ourData, 0);
              return true;
          } else {
              return add(curr.left, ourData, 0, curr.color, curr.right.color);
          }
      } else {
          if (curr.right == null) {
              curr.right = new Node(ourData, 0);
              return true;
          } else {
              return add(curr.right, ourData,1, curr.color, curr.left.color);
          }
      }

    }

    private void miniRight(){

    }

    private void miniLeft(){

    }

    private void BigLeft(){

    }

    private void BigRight(){

    }

    private int rotateType(Node 1, Node 2){

    }

    private int unc(Node node){

    }

    private int parentColor(Node node){

    }

    private void testRoot(){

    }
    */

    public int height(Node node) {

        if (node == null) {
            return 0;
        } else {

            int hl = (node.left == null) ? 0 : height(node.left);
            int hr = (node.right == null) ? 0 : height(node.right);

            return Math.max(hl, hr) + 1;
        }

    }

    private String toReturn = "";
    public String levelOrder() {
        int h = height(root);
        int i;
        int rowHeight = h;
        for (i = 0; i < h; i++) {

            for (int j = 0; j < (int) Math.pow(2, (rowHeight) + 1) - 4; j++) {

                toReturn += " ";

            }

            levelTraverse(root, i + 1, rowHeight);
            rowHeight--;
            toReturn += "\n\n";

        }
        return toReturn;

    }



    private void levelTraverse(Node node, int level, int rowHeight) {
        if (node == null && level == 1) {
            toReturn += "[**]";
            for (int i = 0; i < (int) Math.pow(2, (rowHeight) + 2) - 4; i++) {

                toReturn += " ";

            }

            return;
        } else if (node == null && level > 1) {
            node = new Node();


            levelTraverse(node.left, level - 1, rowHeight);
            levelTraverse(node.right, level - 1, rowHeight);

        } else if (level == 1 && node != null) {
            int dat = node.data;
            String sign;
            String sign2;
            if (node.color == 0) {
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




            for (int i = 0; i < (int) Math.pow(2, (rowHeight) + 2) - 4; i++) {

                toReturn += " ";

            }

        } else if (level > 1) {
            levelTraverse(node.left, level - 1, rowHeight);
            levelTraverse(node.right, level - 1, rowHeight);
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

        public Node(int data, int color) {
            this.data = data;
            left = null;
            right = null;
            this.color = color;

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
    //
