public class AVL {
  private Node root;
  public AVL(){
    root = null;
  }

  public AVL(int initialData){
    root = new Node(initialData);
  }
  public void add(int newValue){
    if(root = null){
      root = new Node(newValue);
    }else{
      add(root, newValue);
    }
  }
  private void add(Node curr, int newValue){
      if (curr.data == newValue) {
          return;
      } else if (newValue < curr.data) {
          if (curr.left == null) {
              curr.left = new Node(newValue);
          } else {
              return add(curr.left, newValue);
          }
      } else {
          if (curr.right == null) {
              curr.right = new Node(newValue);
          } else {
              return add(curr.right, newValue);
          }
      }
      curr = balance(curr);
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
    int data;
    Node left, right

    public Node(int data){
      this.data = data;
      right = null;
      left = null;
    }
    // pseudo code for delete
    // 3 cases when removing
    //   remove leaft
    //     find parent then set child to null
    //
    //   parent points to the grandchild
    //
    //   curr = balance of curr

    private  Node rotateLeft(Node top){
      Node newTop = top.right;
      top.right = newTop.left;
      newTop.left = top;
      return newTop;
    }

    private  Node rotateRight(Node top){
      Node newTop = top.left;
      top.left = newTop.right;
      newTop.right = top;
      return newTop;
    }


    private Node balance(Node top){
      int bf = top.bf();
      if(bf >= 2){
        if (top.right.bf() < 0){
          top.right = rotateRight(top.right);
        }
        top = rotateLeft(top);
      } else if (bf <= -2){
          if(top.left.bf() < 0){
            top.left = rotateLeft(top.left);
          }
          top = rotateRight(top);
      }

      return top;
    }
    /*
    take in a Node
    find the balance factor
    test it
      if >=2
        if node.right.bf < 0
          mini rotateRight
        left rotate
      if <= -2
        if node.left.bf > 0
          mini left
        right rotate


    */

    public int height(){
      // int hl;
      // if(left == null){
      //   hl = 0;
      // }else{
      //   h1 = left.height();
      // }

      int hl = (left == null) ? 0 : left.height();
      int hr = (right == null) ? 0 : right.height();

      return Math.max(hl, hr) + 1;

    }

    public int bf(){
      int hl = (left == null) ? 0 : left.height();
      int hr = (right == null) ? 0 : right.height();
      return hr - hl;
    }
  }
}
