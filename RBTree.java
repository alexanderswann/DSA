public class RBTree {
    Node root;
    Node holder;

    public RBTree() {
        root = null;
    }


    //0 is left, 1 is right// red is 0, black is 1

    public boolean add(int ourData) {
        if (root == null) {
            root = new Node(ourData, 1);
            values(root, ourData,-1, -1, holder, holder, holder, holder, -1, holder);
            return true;
        } else {
            return add(root, ourData, -1, holder, holder, holder, holder, -1 , holder);
        }
    }


    private boolean add(Node curr, int ourData, int parentPointer, Node parent, Node uncle, Node sibling, Node grandpap, int papPointer, Node greatPappy) {
        if (curr.data == ourData) {
            return false;
        } else if (ourData < curr.data) {
            if (curr.left == null) {
                curr.left = new Node(ourData, 0);
                values(curr.left, ourData, parentPointer,0, curr ,curr.right, sibling, parent, papPointer, grandpap);
                fixer(curr.left, ourData, parentPointer,0, curr ,curr.right, sibling, parent, papPointer, grandpap);

                return true;
            } else {

                return add(curr.left, ourData, 0, curr, sibling, curr.right, parent, parentPointer, grandpap);
            }
        } else {
            if (curr.right == null) {
                curr.right = new Node(ourData, 0);
                values(curr.right, ourData, parentPointer,1, curr, curr.left, sibling, parent, papPointer, grandpap);
                fixer(curr.right, ourData, parentPointer,1, curr, curr.left, sibling, parent, papPointer, grandpap);
                return true;
            } else {
                return add(curr.right, ourData,1, curr, sibling, curr.left, parent, parentPointer, grandpap);
            }
        }
    }

    public String values (Node curr, int data, int parentPointer, int ourPointer, Node parent, Node sibling, Node uncle, Node grandpap, int papPointer, Node greatPappy) {
      String toReturn = "\n\nOur Data is " + curr.data;

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

       if(parent == null){
        toReturn += "There is no parent\n";
      }else if(parent.color == 0){
        toReturn += "The parent is red\n";
      }else{
        toReturn += "The parent is black\n";
      }

       if(uncle == null){
        toReturn += "There is no uncle\n";
      }else if(uncle.color == 0){
        toReturn += "The uncle is red\n";
      }else{
        toReturn += "The uncle is black\n";
      }


       if(sibling == null){
        toReturn += "There is no sibling\n";
      }else if(sibling.color == 0){
        toReturn += "The sibling is red\n";
      }else{
        toReturn += "The sibling is black\n";
      }

      if(grandpap == null){
       toReturn += "There is no grandpap\n";
     }else if(grandpap.color == 0){
       toReturn += "The grandpap is red\n";
     }else{
       toReturn += "The grandpap is black\n";
     }

      if(greatPappy == null){
       toReturn += "There is no greatPappy\n";
     }else if(greatPappy.color == 0){
       toReturn += "The greatPappy is red\n";
     }else{
       toReturn += "The greatPappy is black\n";
     }

     if(papPointer == 0){
       toReturn += "The grandpap  is on the left\n";
     }else if(parentPointer == 1){
       toReturn += "The grandpap is on the right\n";
     }else{
       toReturn += parentPointer >=0 ?"Our grandpap is the root\n":"\nWe are the root\n";
     }



      System.out.println(toReturn);


      //change the parent color and the siblig/uncle color to their nodes
      return toReturn;

    }
          //0 is left, 1 is right// red is 0, black is
  //fixer(curr,  data,  parentPointer,  ourPointer,  parent,  sibling,  uncle,  grandpap);
    public Node fixer(Node curr, int data, int parentPointer, int ourPointer, Node parent, Node sibling, Node uncle, Node grandpap, int papPointer, Node greatPappy){

      if (curr == root) {
          return root;
      } else if (curr.color ==0 && parent.color == 0 && parentPointer == 0 && ourPointer == 1 &&(uncle == null || uncle.color != 0)){
        leftRight(grandpap); //parent is red, parent is left child, we are a right child
        leftLeft(grandpap, papPointer, greatPappy);
        rootCheck();
        info(parent.data);
      }else if (curr.color ==0&&parent.color == 0 && parentPointer == 0 && ourPointer == 0 && (uncle == null || uncle.color != 0)){
        leftLeft(grandpap, papPointer, greatPappy);//parent is red, parent is left child, we are a left child
        rootCheck();
        info(parent.data);
      }else if (curr.color ==0&&parent.color == 0 && parentPointer == 1 && ourPointer == 0 && (uncle == null || uncle.color != 0)) {
        rightLeft(grandpap);//parent is red, parent is right child, we are a left child
        rightRight(grandpap, papPointer, greatPappy);
        rootCheck();
        info(parent.data);
      }else if (curr.color ==0&&parent.color == 0 && parentPointer == 1 && ourPointer == 1 && (uncle == null || uncle.color != 0)) {

        rightRight(grandpap, papPointer, greatPappy); //parent is red, parent is right child, we are a right child
        rootCheck();
        info(parent.data);
      }else if (curr.color ==0 &&parent.color == 0 && uncle != null && uncle.color == 0) {
        //Node, parent and uncle are red, push blackness down from the grandpap
        parent.color = 1;
        uncle.color = 1;
        grandpap.color = 0;
        rootCheck();
        info(grandpap.data);
        System.out.println(grandpap.data);
      }else{
        info(parent.data);
      }
      return root;
    }

    public void rootCheck(){
      if (root.color == 0) {
          root.color = 1;
      }
      return;
    }



        public void leftRight(Node top){

          Node newMid = top.left.right;
          top.left.right = newMid.left;
          newMid.left = top.left;
          top.left = newMid;


        }

        public void rightRight(Node top, int papPointer, Node greatPappy){
          Node newTop = top.right;
          top.color = 0;
          newTop.color = 1;
          top.right = newTop.left;
          newTop.left = top;

          if(greatPappy ==null){

            root =  newTop;
          }else{
            if(papPointer == 1){
              greatPappy.right = newTop;
            }else{
              greatPappy.left = newTop;
            }
          }

          //return newTop;
        }
            //0 is left, 1 is right// red is 0, black is

        public void leftLeft(Node top, int papPointer, Node greatPappy){
          Node newTop = top.left;
          top.color = 0;
          newTop.color = 1;
          top.left = newTop.right;
          newTop.right = top;
          if(greatPappy ==null){
            root =  newTop;
          }else{
            if(papPointer == 1){
              greatPappy.right = newTop;
            }else{
              greatPappy.left = newTop;
            }
          }
          //top =  newTop;
          //return newTop;
        }

        public void rightLeft(Node top){
              Node newMid = top.right.left;
              top.right.left = newMid.right;
              newMid.right = top.right;
              top.right = newMid;
        }


public boolean info(int ourData) {
    if (root.data == ourData) {
        fixer(root, ourData,-1, -1, holder, holder, holder, holder, -1 , holder);
        return true;
    } else {
        return info(root, ourData, -1, holder, holder, holder, holder, -1, holder);
    }
}

private boolean info(Node curr, int ourData, int parentPointer, Node parent, Node uncle, Node sibling, Node grandpap, int papPointer, Node greatPappy) {
    if (ourData < curr.data) {
        if (curr.left.data == ourData) {
            fixer(curr.left, ourData, parentPointer,0, curr ,curr.right, sibling, parent, papPointer, grandpap);

            return true;
        } else {

            return info(curr.left, ourData, 0, curr, sibling, curr.right, parent, parentPointer, grandpap);
        }
    } else {
        if (curr.right.data == ourData) {
            fixer(curr.right, ourData, parentPointer,1, curr, curr.left, sibling, parent, papPointer, grandpap);
            return true;
        } else {
            return info(curr.right, ourData,1, curr, sibling, curr.left, parent, parentPointer, grandpap);
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



    // public int findParentTester(int data) {
    //     return findParent(data).data;
    // }

    // public Node fixer (Node curr){
    //   if()
    // }

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

      ///*
    // private boolean acessData(Node curr, int ourData, int parentPointer, int parentcolor, int uncleColor, int siblingcolor){
    //   if (curr.data == ourData) {
    //       return true;
    //   } else if (ourData < curr.data) {
    //       if (curr.left == null) {
    //           curr.left = new Node(ourData, 0);
    //           return true;
    //       } else {
    //           return add(curr.left, ourData, 0, curr.color, curr.right.color);
    //       }
    //   } else {
    //       if (curr.right == null) {
    //           curr.right = new Node(ourData, 0);
    //           return true;
    //       } else {
    //           return add(curr.right, ourData,1, curr.color, curr.left.color);
    //       }
    //   }
    //
    // }


    // private int rotateType(Node 1, Node 2){
    //
    // }
    //
    // private int unc(Node node){
    //
    // }
    //
    // private int parentColor(Node node){
    //
    // }
    //
    // private void testRoot(){
    //
    // }
    //*/

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
        toReturn = "";
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
