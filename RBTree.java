public class RBTree {
    Node root;
    Node holder;

    /** creates the tree

    */

    public RBTree() {
        root = null;
    }    //0 is left, 1 is right// red is 0, black is 1


    //Start of the Insert method


    /**
   * The add method takes in a nubmer(int) from the user and enters it into our red black tree
   * we use recursion to get down to the level of our data and on our way down we pick up useful
   * information that we will use later when balancing. That is why there are so many different parameters.
   * once we get to were our data needs to be added we call- values - which just prints out the information for our new node,
   * parent color, uncle color, etc. The fixer class uses the values that we collected to unsure that our tree is balanced
   * @param ourData the data that our user wants to enter in to the red black tree
   * @param curr the current node that we are at
   * @param parentPointer tells us if our parent is on the right(1) or the left(0)
   * @param parent our parent Node
   * @param uncle our uncle Node
   * @param sibling our sibling Node
   * @param grandpap our grandfather Node
   * @param papPointer tells us if our grandparent is on the right(1) or the left(0)
   * @param greatPappy our greatgrandfather Node
   * @return we return a boolean, true if the nubmer got added, false if it did not(number was probably already in the list)
   */


    public boolean add(int ourData) {
        if (root == null) {
            root = new Node(ourData, 1);
            values(root, ourData, -1, -1, holder, holder, holder, holder, -1, holder);
            return true;
        } else {
            return add(root, ourData, -1, holder, holder, holder, holder, -1, holder);
        }
    }


    private boolean add(Node curr, int ourData, int parentPointer, Node parent, Node uncle, Node sibling, Node grandpap, int papPointer, Node greatPappy) {
        if (curr.data == ourData) {
            return false;
        } else if (ourData < curr.data) {
            if (curr.left == null) {
                curr.left = new Node(ourData, 0);
                values(curr.left, ourData, parentPointer, 0, curr, curr.right, sibling, parent, papPointer, grandpap);
                fixer(curr.left, ourData, parentPointer, 0, curr, curr.right, sibling, parent, papPointer, grandpap);

                return true;
            } else {

                return add(curr.left, ourData, 0, curr, sibling, curr.right, parent, parentPointer, grandpap);
            }
        } else {
            if (curr.right == null) {
                curr.right = new Node(ourData, 0);
                values(curr.right, ourData, parentPointer, 1, curr, curr.left, sibling, parent, papPointer, grandpap);
                fixer(curr.right, ourData, parentPointer, 1, curr, curr.left, sibling, parent, papPointer, grandpap);
                return true;
            } else {
                return add(curr.right, ourData, 1, curr, sibling, curr.left, parent, parentPointer, grandpap);
            }
        }
    }


    //0 is left, 1 is right// red is 0, black is 1

      /**
       * The fixer method balances the node that we just added to our tree
       * the if statements check for the different cases and change the tree accordingly
       * @param curr the current node that we are at
       * @param data our data
       * @param ourPointer tells us if we are on the right(1) or the left(0)
       * @param parentPointer tells us if our parent is on the right(1) or the left(0)
       * @param parent our parent Node
       * @param uncle our uncle Node
       * @param sibling our sibling Node
       * @param grandpap our grandfather Node
       * @param papPointer tells us if our grandparent is on the right(1) or the left(0)
       * @param greatPappy our greatgrandfather Node
       * @return we return the root, not really needed or used
       */
    public Node fixer(Node curr, int data, int parentPointer, int ourPointer, Node parent, Node sibling, Node uncle, Node grandpap, int papPointer, Node greatPappy) {

        if (curr == root) {
            return root;
        } else if (curr.color == 0 && parent.color == 0 && parentPointer == 0 && ourPointer == 1 && (uncle == null || uncle.color != 0)) {
            leftRight(grandpap); //parent is red, parent is left child, we are a right child
            colorCorrect(grandpap, grandpap.left, grandpap.left.left);
            leftLeft(grandpap, papPointer, greatPappy);
            rootCheck();
            info(false, parent.data);
        } else if (curr.color == 0 && parent.color == 0 && parentPointer == 0 && ourPointer == 0 && (uncle == null || uncle.color != 0)) {
            colorCorrect(grandpap, grandpap.left, grandpap.left.left);
            leftLeft(grandpap, papPointer, greatPappy); //parent is red, parent is left child, we are a left child
            rootCheck();
            info(false, parent.data);
        } else if (curr.color == 0 && parent.color == 0 && parentPointer == 1 && ourPointer == 0 && (uncle == null || uncle.color != 0)) {
            rightLeft(grandpap); //parent is red, parent is right child, we are a left child
            colorCorrect(grandpap, grandpap.right, grandpap.right.right);
            rightRight(grandpap, papPointer, greatPappy);
            rootCheck();
            info(false, parent.data);
        } else if (curr.color == 0 && parent.color == 0 && parentPointer == 1 && ourPointer == 1 && (uncle == null || uncle.color != 0)) {
            colorCorrect(grandpap, grandpap.right, grandpap.right.right);
            rightRight(grandpap, papPointer, greatPappy); //parent is red, parent is right child, we are a right child
            rootCheck();
            info(false, parent.data);
        } else if (curr.color == 0 && parent.color == 0 && uncle != null && uncle.color == 0) {
            parent.color = 1; //Node, parent and uncle are red, push blackness down from the grandpap
            uncle.color = 1;
            grandpap.color = 0;
            rootCheck();
            info(false, grandpap.data);
        } else {
            info(false, parent.data);
        }
        return root;
    }

    /**
    *  The right right method performs a rotation when our
    *   nodes are in a right right formation, meaning they make a straight line
    * going down to the right, parent is red, parent is right child, we are a right child
    * @ param top the highest level node in our rotation
    * @param papPointer determinese wheather our grandparent is on the right or the left
    * @param greatPappy the node of our greatgrandfather
    */

    public void rightRight(Node top, int papPointer, Node greatPappy) {
        Node newTop = top.right;
        top.right = newTop.left;
        newTop.left = top;

        if (greatPappy == null) {

            root = newTop;
        } else {
            if (papPointer == 1) {
                greatPappy.right = newTop;
            } else {
                greatPappy.left = newTop;
            }
        }


    }
    //0 is left, 1 is right// red is 0, black is 1

        /**
        *  The leftLeft method performs a rotation when our
        *   nodes are in a left left formation, meaning they make a straight line
        * going down to the left, parent is red, parent is left child, we are a left child
        * @ param top the highest level node in our rotation
        * @param papPointer determines wheather our grandparent is on the right or the left
        * @param greatPappy the node of our greatgrandfather
        */

    public void leftLeft(Node top, int papPointer, Node greatPappy) {
        Node newTop = top.left;
        top.left = newTop.right;
        newTop.right = top;
        if (greatPappy == null) {
            root = newTop;
        } else {
            if (papPointer == 1) {
                greatPappy.right = newTop;
            } else {
                greatPappy.left = newTop;
            }
        }

    }

        /**
        *  The rightLeft method performs a rotation when our
        *   nodes are in a right left formation, meaning they make a bent line
        * going down to the right then left, parent is red, parent is right child, we are a left child
        * @ param top the highest level node in our rotation
        */

    private void rightLeft(Node top) {
        Node newMid = top.right.left;
        top.right.left = newMid.right;
        newMid.right = top.right;
        top.right = newMid;
    }
        /**
        *  The leftRight method performs a rotation when our
        *   nodes are in a left right formation, meaning they make a bent line
        * going down to the left then right, parent is red, parent is left child, we are a right child
        * @ param top the highest level node in our rotation
        */

    private void leftRight(Node top) {

        Node newMid = top.left.right;
        top.left.right = newMid.left;
        newMid.left = top.left;
        top.left = newMid;

    }

    /**
    *  this method fixes the colors of our nodes from a rightright or a leftleft rotation
    * @param gramp our grandfather node
    * @param pop our father nod
    * @param son our son node
    */

    private void colorCorrect(Node gramp, Node pop, Node son) {
        gramp.color = 0;
        pop.color = 1;
        son.color = 0;
    }

    /**
    *  the rootCheck method checks to see if the root is red and changes it to black if it is
    */

    private void rootCheck() {
        if (root.color == 0) {
            root.color = 1;
        }

        return;
    }



    //Start of the remove method


    /**
    * this method deletes data from our tree, it determines what case we are in and
    * deletes accordingly, uses recursion in most cases, to delete node we set the current node to the value of
    * either the succeccor or the predecessor
    * we then fix any errors in the balancing that occured from deleting the node , in some cases this is simple and we can just do it inside our delete method
    * but in most cases the balaning is very complex so delLeaf method is called to balance our tree
    * @param ourData the data that our user wannt to remove from the tree
    * @return returns true if the data was deleted and false otherwise
    */

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
                Node oldroot = root;
                Node pred = findMaxRec(root.left);
                remove(pred.data);

                oldroot.data = pred.data;

            } else if (root.left != null && root.right != null) {

                Node pred = findMaxRec(root.left);
                Node oldroot = root;
                remove(pred.data);
                oldroot.data = pred.data;
            } else {
                //i have at least a right child
                Node oldroot = root;
                Node succ = findMinRec(root.right);
                remove(succ.data);
                oldroot.data = succ.data;

            }
            return true;
        } else {
            if (ourData > parent.data) {
                //ourData is on the right
                Node curr = parent.right;
                if (curr.left == null && curr.right == null) { //leaf case
                    if (curr.color == 0) {
                        parent.right = null;
                    } else {
                        int parentPointer;

                        Node grandpap = findParent(parent.data);
                        if (grandpap == null) {
                            parentPointer = -1;
                        } else if (parent.data > grandpap.data) {
                            parentPointer = 1;
                        } else {
                            parentPointer = 0;
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

                    if (curr.color == 0) {
                        parent.left = null;
                    } else {
                        int parentPointer;
                        Node grandpap = findParent(parent.data);
                        if (grandpap == null) {
                            parentPointer = -1;
                        } else if (parent.data > grandpap.data) {
                            parentPointer = 1;
                        } else {
                            parentPointer = 0;
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

    /** the delLeaf method is called in more complex balancing cases
    *in some cases we only have to perform one operation to balance the tree
    * in others we have to call the delLeaf method again on our parent to balance the
    * tree, and in the most complex cases we have to call the info method which then enters a recursive
    * loop going up the tree to balance our tree

    @param parent the node of our parent
    @param grandpap the node of our grandfather
    @ param childPointer specifies wheater we are on the right or left
    @ param parentPointer specifies wheater our parent is on the right or left
    */
    private void delLeaf(Node parent, int childPointer, int parentPointer, Node grandpap) {
        Node child;
        Node sibling;
        if (parent == null) {
            return;
        }
        if (childPointer == 1) {
            child = parent.right;
            sibling = parent.left;
        } else {
            child = parent.left;
            sibling = parent.right;
        }
        Node leftNeph = sibling.left;
        Node rightNeph = sibling.right;

        if (nColor(sibling) == 1 && childPointer == 1) {
            if (nColor(leftNeph) == 0) {
                leftLeft(parent, parentPointer, grandpap);
                blackDown(parent, sibling, leftNeph);
            } else if (nColor(rightNeph) == 0) {
                leftRight(parent);
                colorCorrect(parent, rightNeph, sibling);
                if (parent.color == 0 && rightNeph.color == 0 && sibling.color == 1) {
                    rightNeph.color = 1;
                    sibling.color = 0;
                }
                leftLeft(parent, parentPointer, grandpap);
                blackDown(parent, sibling, rightNeph);
            } else {
                //push black up
                if (parent.color == 1) {
                    sibling.color = 0;
                    parent.color = 1;
                    info(true, parent.data);
                } else {
                    sibling.color = 0;
                    parent.color = 1;
                }

            } ////0 is left, 1 is right// red is 0, black is 1
        } else if (nColor(sibling) == 1 && childPointer == 0) {
            if (nColor(rightNeph) == 0) {
                rightRight(parent, parentPointer, grandpap);
                blackDown(parent, sibling, rightNeph);

            } else if (nColor(leftNeph) == 0) {
                rightLeft(parent);
                if (parent.color == 0 && leftNeph.color == 0 && sibling.color == 1) {
                    leftNeph.color = 1;
                    sibling.color = 0;
                }
                rightRight(parent, parentPointer, grandpap);
                blackDown(parent, sibling, leftNeph);
                rootCheck();

            } else {
                if (parent.color == 1) {
                    sibling.color = 0;
                    parent.color = 1;
                    info(true, parent.data);
                } else {
                    sibling.color = 0;
                    parent.color = 1;
                }
            } ////0 is left, 1 is right// red is 0, black is 1
        } else if (nColor(sibling) == 0 && childPointer == 1) {
            leftLeft(parent, parentPointer, grandpap);
            sibling.color = 1;
            parent.color = 0;
            delLeaf(parent, 1, 1, sibling);
            rootCheck();
        } else if (nColor(sibling) == 0 && childPointer == 0) {
            rightRight(parent, parentPointer, grandpap);
            sibling.color = 1;
            parent.color = 0;
            delLeaf(parent, 0, 0, sibling);
            rootCheck();

        }
    }

    /**
      * the black down is called after certain rotatins in our delete method to
      * fix the colors in our tree
      * our parameters are named this way because depending on the rotatins we performed they
      * can be different things but in most cases they mean the following
      @param a the node of the child
      @param b the node of the parent
      @param c the node of the grandparent
    */

    private void blackDown(Node a, Node b, Node c) {
        if (b.color == 1 && ((b.right != null && b.right.color == 0) && (b.left != null && b.left.color == 0))) {
            c.color = 1;
            a.color = 1;
            b.color = 0;
        } else if (c.color == 1 && ((c.right != null && c.right.color == 0) && (c.left != null && c.left.color == 0))) {
            a.color = 1;
            b.color = 1;
            c.color = 0;
        } else {
            a.color = 1;
            b.color = 1;
            c.color = 1;
        }

    }

//Start of the helper methods

    /**
      * the info method is called in the add and delete methods to gather data about a specific node
      * it uses recursion to gather the data as is traverses down from the top of the tree
      * @param del a boolean to determine where the info method was called, and what we need to call next, either the fixer method or the delLeaf method
       * @param ourData, our data
       * @param curr our current node
       * @param ourPointer tells us if we are on the right(1) or the left(0)
       * @param parentPointer tells us if our parent is on the right(1) or the left(0)
       * @param parent our parent Node
       * @param uncle our uncle Node
       * @param sibling our sibling Node
       * @param grandpap our grandfather Node
       * @param papPointer tells us if our grandparent is on the right(1) or the left(0)
       * @param greatPappy our greatgrandfather Node
       * @return returns true when completed successfully
    */

    private boolean info(boolean del, int ourData) {
        if (root.data == ourData) {
            fixer(root, ourData, -1, -1, holder, holder, holder, holder, -1, holder);
            return true;
        } else {
            return info(del, root, ourData, -1, holder, holder, holder, holder, -1, holder);
        }
    }

    private boolean info(boolean del, Node curr, int ourData, int parentPointer, Node parent, Node uncle, Node sibling, Node grandpap, int papPointer, Node greatPappy) {
        if (ourData < curr.data) {
            if (curr.left.data == ourData) {
                if (del) {
                    delLeaf(curr, 0, parentPointer, parent);
                } else {
                    fixer(curr.left, ourData, parentPointer, 0, curr, curr.right, sibling, parent, papPointer, grandpap);
                }
                return true;
            } else {

                return info(del, curr.left, ourData, 0, curr, sibling, curr.right, parent, parentPointer, grandpap);
            }
        } else {
            if (curr.right.data == ourData) {
                if (del) {
                    delLeaf(curr, 1, parentPointer, parent);
                } else {
                    fixer(curr.right, ourData, parentPointer, 1, curr, curr.left, sibling, parent, papPointer, grandpap);
                }
                return true;
            } else {
                return info(del, curr.right, ourData, 1, curr, sibling, curr.left, parent, parentPointer, grandpap);
            }
        }
    }

    /**
    find the minimun of a tree starting at the root or a specific node
    uses recursion
    @param curr the current node
    @return returns the smallest node from a specified tree
    */

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

    /**
    find the maximum of a tree starting at the root or a specific node
    uses recursion
    @param curr the current node
    @return returns the largest node from a specified tree
    */

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

    /**
    tries to find a specific value in our tree
    uses recursion
    @param curr the current node
    @param toFind the value we are looking for
    @return returns true if the value is in our tree, false otherwise
    */

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

    /**
    * finds the parent of a specified data
    * uses recursion
    * @param curr the current node
    * @param data of the node that we are trying to find the parent of
    * @return returns the parent of our node with the specified data
    */

    public Node findParent(int data) {
        if (root.data == data) {
            return holder;
        } else {
            return findParent(root, data);
        }
    }

    private Node findParent(Node curr, int data) {
        if (data > curr.data) {
            if (curr.right == null) {
                return holder;
            } else {
                if (curr.right.data == data) {
                    return curr;
                } else {
                    return findParent(curr.right, data);
                }
            }
        } else if (data < curr.data) {
            if (curr.left == null) {
                return holder;
            } else {
                if (curr.left.data == data) {
                    return curr;
                } else {
                    return findParent(curr.left, data);
                }
            }
        } else {
            return holder;
        }

    }

    /**
    finds the height of our tree
    @return return the height of our tree

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

    /**
    *return the color of a specified node
    *@param node the node we want the color of
  *  @return the color of the node 0 for red 1 for black
    */

    private int nColor(Node node) {
        if (node == null || node.color == 1) {
            return 1;
        } else {
            return 0;
        }
    }

//Start of the toString

  /**
    *first we start at the bottom of our tree, calling levelTraverse to travese each level
    *the for loop with the math formula makes sure the spacing between each number is correct
    *
   *@returns a visualization of our tree, with {} denoting red and [] denoting black
  */

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


  /**
    traverses the level adding each number to the to string with the correct number of spacing
    that was calculaed by the math formula
    recursive and calls self
    dummy nodes have to be added in so that we can travese correctly
    @param node our current node
    @param level our current level
    @param rowHeight, the total nubmer of rows
  */
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

   /**
   creates a string of our tree in preorder
    @param curr our current node
   @return returns a string of the ints in our tree in preOrder
   */

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

    /**
      creates a string of all the info about a specific node and prints it out
       * @param ourData, our data
       * @param curr our current node
       * @param ourPointer tells us if we are on the right(1) or the left(0)
       * @param parentPointer tells us if our parent is on the right(1) or the left(0)
       * @param parent our parent Node
       * @param uncle our uncle Node
       * @param sibling our sibling Node
       * @param grandpap our grandfather Node
       * @param papPointer tells us if our grandparent is on the right(1) or the left(0)
       * @param greatPappy our greatgrandfather Node
       * @return return the string that we created
    */

    public String values(Node curr, int data, int parentPointer, int ourPointer, Node parent, Node sibling, Node uncle, Node grandpap, int papPointer, Node greatPappy) {
        String toReturn = "\n\nOur Data is " + curr.data;

        if (parentPointer == 0) {
            toReturn += "\nThe parent is on the left\n";
        } else if (parentPointer == 1) {
            toReturn += "\nThe parent is on the right\n";
        } else {
            toReturn += ourPointer >= 0 ? "\nOur parent is the root\n" : "\nWe are the root\n";
        }

        if (ourPointer == 0) {
            toReturn += "We are on the left\n";
        } else if (ourPointer == 1) {
            toReturn += "We are on the right\n";
        } else {
            toReturn += "We are the root\n";
        }

        if (parent == null) {
            toReturn += "There is no parent\n";
        } else if (parent.color == 0) {
            toReturn += "The parent is red\n";
        } else {
            toReturn += "The parent is black\n";
        }

        if (uncle == null) {
            toReturn += "There is no uncle\n";
        } else if (uncle.color == 0) {
            toReturn += "The uncle is red\n";
        } else {
            toReturn += "The uncle is black\n";
        }

        if (sibling == null) {
            toReturn += "There is no sibling\n";
        } else if (sibling.color == 0) {
            toReturn += "The sibling is red\n";
        } else {
            toReturn += "The sibling is black\n";
        }

        if (grandpap == null) {
            toReturn += "There is no grandpap\n";
        } else if (grandpap.color == 0) {
            toReturn += "The grandpap is red\n";
        } else {
            toReturn += "The grandpap is black\n";
        }

        if (papPointer == 0) {
            toReturn += "The grandpap  is on the left\n";
        } else if (papPointer == 1) {
            toReturn += "The grandpap is on the right\n";
        } else {
            toReturn += parentPointer >= 0 ? "Our grandpap is the root\n" : "\nWe are the root\n";
        }

        if (greatPappy == null) {
            toReturn += "There is no greatPappy\n";
        } else if (greatPappy.color == 0) {
            toReturn += "The greatPappy is red\n";
        } else {
            toReturn += "The greatPappy is black\n";
        }

        System.out.println(toReturn);

        //change the parent color and the siblig/uncle color to their nodes
        return toReturn;

    }

    class Node {
        Node left, right;
        int data;
        int color; //0 is red, 1 is black

        /**
          creates a new node
          @param data the data of the node
          @color the color of the node
        */
        public Node(int data, int color) {
            this.data = data;
            left = null;
            right = null;
            this.color = color;
        }

        /**
          creates a null node, no pointers, and black
        */

        public Node() {
            left = null;
            right = null;
            color = 1;
        }

        /**
        return the data of a node
        @return return the data of a node
        */

        public String toString() {
            return "" + data;
        }
    }
}
