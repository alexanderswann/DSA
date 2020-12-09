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

     if(papPointer == 0){
       toReturn += "The grandpap  is on the left\n";
     }else if(papPointer == 1){
       toReturn += "The grandpap is on the right\n";
     }else{
       toReturn += parentPointer >=0 ?"Our grandpap is the root\n":"\nWe are the root\n";
     }

      if(greatPappy == null){
       toReturn += "There is no greatPappy\n";
     }else if(greatPappy.color == 0){
       toReturn += "The greatPappy is red\n";
     }else{
       toReturn += "The greatPappy is black\n";
     }





      System.out.println(toReturn);


      //change the parent color and the siblig/uncle color to their nodes
      return toReturn;

    }
          //0 is left, 1 is right// red is 0, black is 1
  //fixer(curr,  data,  parentPointer,  ourPointer,  parent,  sibling,  uncle,  grandpap);
    public Node fixer(Node curr, int data, int parentPointer, int ourPointer, Node parent, Node sibling, Node uncle, Node grandpap, int papPointer, Node greatPappy){

      if (curr == root) {
          return root;
      } else if (curr.color == 0 && parent.color == 0 && parentPointer == 0 && ourPointer == 1 &&(uncle == null || uncle.color != 0)){
        leftRight(grandpap); //parent is red, parent is left child, we are a right child
        colorCorrect(grandpap, grandpap.left, grandpap.left.left);

        leftLeft(grandpap, papPointer, greatPappy);
        rootCheck();
        info(false, parent.data);
      }else if (curr.color == 0 && parent.color == 0 && parentPointer == 0 && ourPointer == 0 && (uncle == null || uncle.color != 0)){
        colorCorrect(grandpap, grandpap.left, grandpap.left.left);
        leftLeft(grandpap, papPointer, greatPappy);//parent is red, parent is left child, we are a left child
        rootCheck();
        info(false, parent.data);
      }else if (curr.color == 0 && parent.color == 0 && parentPointer == 1 && ourPointer == 0 && (uncle == null || uncle.color != 0)) {
        rightLeft(grandpap);//parent is red, parent is right child, we are a left child
        colorCorrect(grandpap, grandpap.right, grandpap.right.right);
        rightRight(grandpap, papPointer, greatPappy);
        rootCheck();
        info(false, parent.data);
      }else if (curr.color == 0 && parent.color == 0 && parentPointer == 1 && ourPointer == 1 && (uncle == null || uncle.color != 0)) {
        colorCorrect(grandpap, grandpap.right, grandpap.right.right);
        rightRight(grandpap, papPointer, greatPappy); //parent is red, parent is right child, we are a right child
        rootCheck();
        info(false, parent.data);
      }else if (curr.color == 0 && parent.color == 0 && uncle != null && uncle.color == 0) {
        parent.color = 1; //Node, parent and uncle are red, push blackness down from the grandpap
        uncle.color = 1;
        grandpap.color = 0;
        rootCheck();
        info(false, grandpap.data);
      }else{
        info(false, parent.data);
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

      public void colorCorrect(Node gramp, Node pop, Node son){
        gramp.color = 0;
        pop.color = 1;
        son.color = 0;
      }

        public void rightRight(Node top, int papPointer, Node greatPappy){
          Node newTop = top.right;
          // top.color = 0;
          // newTop.color = 1;
          // top.right.right.color = 0;
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


        }
            //0 is left, 1 is right// red is 0, black is 1

        public void leftLeft(Node top, int papPointer, Node greatPappy){
          Node newTop = top.left;
          // top.color = 0;
          // newTop.color = 1;
          // top.left.left.color = 0;
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

        }

        public void rightLeft(Node top){
              Node newMid = top.right.left;
              top.right.left = newMid.right;
              newMid.right = top.right;
              top.right = newMid;
        }


public boolean info(boolean del, int ourData) {
    if (root.data == ourData) {
        fixer(root, ourData,-1, -1, holder, holder, holder, holder, -1 , holder);
        return true;
    } else {
        return info(del, root, ourData, -1, holder, holder, holder, holder, -1, holder);
    }
}

private boolean info(boolean del, Node curr, int ourData, int parentPointer, Node parent, Node uncle, Node sibling, Node grandpap, int papPointer, Node greatPappy) {
    if (ourData < curr.data) {
        if (curr.left.data == ourData) {
            if(del){

              delLeaf(curr, 0, parentPointer, parent);
            }else{
              fixer(curr.left, ourData, parentPointer,0, curr ,curr.right, sibling, parent, papPointer, grandpap);
            }
            return true;
        } else {

            return info(del, curr.left, ourData, 0, curr, sibling, curr.right, parent, parentPointer, grandpap);
        }
    } else {
        if (curr.right.data == ourData) {
          if (del) {
            delLeaf(curr, 1, parentPointer, parent);
          }else{
            fixer(curr.right, ourData, parentPointer,1, curr, curr.left, sibling, parent, papPointer, grandpap);
          }
            return true;
        } else {
            return info(del, curr.right, ourData,1, curr, sibling, curr.left, parent, parentPointer, grandpap);
        }
    }
}



    public Node findMinRec() {
        if (root == null) {
            return holder;
        }
        return findMinRec(root);
    }

    private Node findMinRec(Node curr) {
        if (curr.left == null) {
            return curr;
        } else {
            return findMinRec(curr.left);
        }
    }



    public Node findMaxRec() {
        if (root == null) {
            return holder;
        }
        return findMaxRec(root);
    }

    private Node findMaxRec(Node curr) {
        if (curr.right == null) {
            return curr;
        } else {
            return findMaxRec(curr.right);
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

    // private boolean fix2(Node curr){
    //   return true;
    //   if(deletedNode Node
    // }
//deteted node red
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
                Node pred = findMaxRec(root.left);
                remove(pred.data);
                root.data = pred.data;

            } else if (root.left != null && root.right != null) {
              Node pred = findMaxRec(root.left);
              remove(pred.data);
              root.data = pred.data;
            }else {
                //i have at least a right child
                Node succ = findMinRec(root.right);
                remove(succ.data);
                root.data = succ.data;

            }
            return true;
        } else {
            if (ourData > parent.data) {
                //ourData is on the right
                Node curr = parent.right;
                if (curr.left == null && curr.right == null) { //leaf case
                    if(curr.color == 0){
                      parent.right = null;
                    }else{
                      int parentPointer;

                      Node grandpap = findParent(parent.data);
                      if(grandpap == null){
                        parentPointer = -1;
                      }else if(parent.data > grandpap.data){
                        parentPointer = 1;
                      }else{
                        parentPointer= 0 ;
                      }
                      parent.right = null;
                      delLeaf(parent, 1, parentPointer, grandpap);
                    }


                } else if (curr.right == null && curr.left != null) { //one left child
                    parent.right = curr.left;
                    parent.right.color = 1;
                } else if (curr.right != null && curr.left == null) { //one right child
                    parent.right = curr.right;
                    parent.right.color = 1;
                    //possible?
                } else {
                    //we have two childs
                    Node predecessor = findMaxRec(curr.left);
                    remove(predecessor.data);
                    curr.data = predecessor.data;


                }
            } else {
                Node curr = parent.left;
                //curr is getting deleted
                if (curr.left == null && curr.right == null) { //leaf case

                    if(curr.color == 0){
                      parent.left = null;
                    }else{
                      int parentPointer;

                      Node grandpap = findParent(parent.data);
                      if(grandpap == null){
                        parentPointer = -1;
                      }else if(parent.data > grandpap.data){
                        parentPointer = 1;
                      }else{
                        parentPointer= 0 ;
                      }
                      parent.left = null;
                      delLeaf(parent, 0, parentPointer, grandpap);
                    }
                } else if (curr.right == null && curr.left != null) { //one left child
                    parent.left = curr.left;
                    parent.left.color = 1;

                } else if (curr.right != null && curr.left == null) { //one right child
                    parent.left = curr.right;
                    parent.left.color = 1;

                    //possible??


                } else {
                    //we have two childs
                    Node predecessor = findMaxRec(curr.left);
                    remove(predecessor.data);
                    curr.data = predecessor.data;
                }
            }
            return true;
        }
    }
////0 is left, 1 is right// red is 0, black is 1
  public void delLeaf(Node parent, int childPointer, int parentPointer, Node grandpap){
      Node child;
      Node sibling;
      if(parent == null){
        return;
      }
      if(childPointer == 1){
        child = parent.right;
        sibling = parent.left;
      }else{
        child = parent.left;
        sibling = parent.right;
      }
      Node leftNeph = sibling.left;
      Node rightNeph= sibling.right;

      if(nColor(sibling) ==1 && childPointer == 1){
        if(nColor(leftNeph) == 0){
          leftLeft(parent, parentPointer, grandpap);
          blackDown(parent, sibling, leftNeph);

        }else if (nColor(rightNeph )== 0) {
          leftRight(parent);
          leftLeft(parent, parentPointer, grandpap);
          blackDown(parent, sibling, rightNeph);
        }else{
          //push black up
          if (parent.color == 1) {

            sibling.color = 0;
            parent.color = 1;
            System.out.println("8037402374732");
            info(true, parent.data);
          }else{
          sibling.color = 0;
          parent.color = 1;
        }


        }////0 is left, 1 is right// red is 0, black is 1
      }else if (nColor(sibling) ==1 && childPointer == 0) {
        if (nColor(rightNeph) == 0) {
          rightRight(parent, parentPointer, grandpap);
          blackDown(parent, sibling, rightNeph);
        }else if (nColor(leftNeph)== 0) {
          rightLeft(parent);
          rightRight(parent, parentPointer, grandpap);
          blackDown(parent, sibling, leftNeph);
        }else {
          if (parent.color == 1) {

            //System.out.println("hleloseoreo");
            sibling.color = 0;
            parent.color = 1;
            System.out.println("9087678");
            info(true, parent.data);

          }else{
          sibling.color = 0;
          parent.color = 1;
        }
        }////0 is left, 1 is right// red is 0, black is 1
      }else if(nColor(sibling) == 0 && childPointer == 1){
        leftLeft(parent, parentPointer, grandpap);
        parent.color = 0;
        //blackDown(parent, sibling, leftNeph);
        sibling.right.left.color = 0;
        parent.color = 1;
        rootCheck();
      }else if (nColor(sibling) == 0 && childPointer == 0) {

        //rightLeft(parent);
        rightRight(parent, parentPointer, grandpap);
        parent.color = 0;
        //blackDown(parent, sibling, leftNeph);

        sibling.left.right.color = 0;
        parent.color = 1;
        rootCheck();
        //info(true, parent.data);
        //leftRight(parent);
      }
  }


//
//
// if(deleted node is red){
//   nothing
// }else if(child of deleted Node is double black && has black sibling && deleted is right child){
//     if(left nephew is red){
//       left left
//       push black donw
//     }else if(right nephew is red){
//       leftRight
//       leftLeft
//       push black donw
//     }else{//both nephews are black
//       push black up
//     }
//
// }else if(child of deleted Node is double black && has black sibling && deleted is left child){
//   if(right nephew is red){
//     right right
//     push black donw
//   }else if(left nephew is red){
//     rightleft
//     right right
//     push black donw
//   }else{//both nephews are black
//     push black up
//   }
// }else if(child of deleted node is double black && has red sibling){
//   if(we are right child){
//        right left
//         recall this method
// //   }else{
//       left right
// }
// }

public void blackDown(Node a, Node b, Node c){
  a.color = 1;
  b.color = 1;
  c.color = 1;
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

    public int height(Node node) {

        if (node == null) {
            return 0;
        } else {

            int hl = (node.left == null) ? 0 : height(node.left);
            int hr = (node.right == null) ? 0 : height(node.right);

            return Math.max(hl, hr) + 1;
        }

    }

    public int nColor (Node node){
      if (node == null || node.color == 1) {
        return 1;
      }else{
        return 0;
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
            color = 1;


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
        //
        //
        // public int findMaxIter() {
        //     if (root == null) {
        //         return Integer.MIN_VALUE;
        //     } else {
        //         Node curr = root;
        //         while (curr.right != null) {
        //             curr = curr.right;
        //         }
        //         return curr.data;
        //     }
        // }
        //
        //     public int findMinIter() {
        //         if (root == null) {
        //             return Integer.MAX_VALUE;
        //         } else {
        //             Node curr = root;
        //             while (curr.left != null) {
        //                 curr = curr.left;
        //             }
        //             return curr.data;
        //         }
        //     }


        // private int state(Node node){
        //   if(node.color == null){
        //     return -1;
        //   }else if(node.color == 1){
        //     return 1;
        //   }
        // }
        // public int findParentTester(int data) {
        //     return findParent(data).data;
        // }

        // public Node fixer (Node curr){
        //   if()
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
