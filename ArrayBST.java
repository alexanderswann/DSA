public class ArrayBST {

  Integer arr[];
  public ArrayBST() {
    arr = new Integer[8];
    arr[0] = 0;
  }

  private int Ncase(int i){
    if(lV(i) > 0 && rV(i) > 0) {//2 case
      return 2;
    }else if(lV(i) > 0 && rV(i) <= 0){//left no right
      return 1;
    }else if(lV(i) <= 0 && rV(i) > 0){//right no left
      return 0;
    }else if(lV(i) <= 0 && rV(i) <= 0){//leaf case
      return -1;
    }else{
      return -3;
    }
  }

  private int lV(int i){
    if((2*i) + 1 < arr.length){
      if(arr[(2*i) + 1] == null){
        return 0;
      }else{
        return 1;
      }
    }else{
      return -1;
    }
  }

  private int rV(int i){
    if((2*i) < arr.length){
      if(arr[2*i] == null){
        return 0;
      }else{
        return 1;
      }
    }else{
      return -1;
    }
  }

  public boolean insert(int i){
    if(arr[1] == null){
      arr[1] = i;
      arr[0]++;
      return true;
    }else{
      return insert(1, i);
    }
  }
  //currleft = arr[(2 * i) + 1]
  //currright = arr[2 * i]
  private boolean insert(int curr, int i){
    if(arr[curr] == i){
      return false;

    }else if (i < arr[curr]) {

      if(lV(curr) == 0){// if left exists but is empty
        arr[(2 * curr) + 1] = i;
        arr[0]++;
        return true;
      }else if(lV(curr) == -1){
        expand();
        arr[(2 * curr) + 1] = i;
        arr[0]++;
        return true;
      } else{
        return insert((2 * curr) + 1, i);
      }

    }else{
      if(rV(curr) == 0){
        arr[2 * curr] = i;
        arr[0]++;
        return true;
      }else if (rV(curr) == -1) {
        expand();
        arr[2 * curr] = i;
        arr[0]++;
        return true;
      }else{
        return insert(2 * curr, i);
      }
    }
  }

  private void expand(){
    Integer[] arr2 = new Integer[arr.length * 2];

    for(int i = 0; i< arr.length;i++){
      if(arr[i] != null){
        arr2[i] = arr[i];
      }
    }

    arr = arr2;

    return;
  }

  public String preOrder(){
    return preOrder(1);
  }

  private String preOrder(int curr){
    if(curr >= arr.length || arr[curr] == null){
      return "";
    }else{
      String left = preOrder((2 * curr) + 1);
      String right = preOrder(2 * curr);
      return arr[curr]+ " "  + left + right;
    }
  }


  public String inOrder(){
    return inOrder(1);
  }

  private String inOrder(int curr){
    if(curr >= arr.length || arr[curr] == null){
      return "";
    }else{
      String left = inOrder((2 * curr) + 1);
      String right = inOrder(2 * curr);
      return  left + arr[curr]+ " "   + right;
    }
  }

  public String postOrder(){
    return postOrder(1);
  }

  private String postOrder(int curr){
    if(curr >= arr.length || arr[curr] == null){
      return "";
    }else{
      String left = postOrder((2 * curr) + 1);
      String right = postOrder(2 * curr);
      return  left  + right+ arr[curr] + " " ;
    }
  }

  public String toString(){
    String toRet = "";

    for(int i = 0; i< arr.length;i++){
      toRet += arr[i] + " ";
    }

    return toRet;
  }

  public boolean isEmpty(){
    return arr[0] == 0;
  }

  public int max(){
    if(arr[1] == null){
      return Integer.MIN_VALUE;
    }
    return max(1);
  }

  private int max(int curr){
    if(rV(curr) <= 0){
      return arr[curr];
    } else{
      return max(2 * curr);
    }
  }

  public int min(){
    if(arr[1] == null){
      return Integer.MAX_VALUE;
    }
    return min(1);
  }

  private int min(int curr){
    if(lV(curr) <= 0){
      return arr[curr];
    } else{
      return min((2 * curr) + 1);
    }
  }

  public int find(int i){
    if(arr[1] == null){
      return -1;
    } else {
      return find(1, i);
    }
  }

  private int find (int curr, int i){
    if(arr[1] == null){
      return -1;
    }else if (arr[curr] == i){
      return curr;
    }else{
      if(i < arr[curr]){
        if(lV(curr) <= 0){
          return -1;
        }else{
          return find((2 * curr) + 1, i);
        }
      }else{
        if(rV(curr) <= 0){
          return -1;
        }else{
          return find(2 * curr, i);
        }
      }
    }
  }

  public boolean contains(int i){
    return find(i) >= 0;
  }

  public int findParent(int i){
    if(arr[1] == null){
      return -1;
    }else {
      return findParent(1, i);
    }
  }

  public int findParent(int curr, int i){
    if(curr >= arr.length || arr[curr] == null){
      return -1;
    }else if(rV(curr)>0 && arr[2 * curr] == i){
      return curr;
    }else if (lV(curr) > 0 && arr[(2 * curr) +1 ]==i){
      return curr;
    }else if (i > arr[curr]){
      return findParent((2 * curr), i);
    }else{
      return findParent(((2 * curr) +1), i);
    }
  }


    //
  	// /**
    //     * Checks whether the tree is empty
    //     * @return true if the tree is empty, false otherwise
    //     */
  	// boolean isEmpty();
    //
  	// /**
    //     * Makes the array twice as large and moves all the data
    //     * into the bigger array.
    //     */
  	// void expand();
    //
    //     /**
    //     * Inserts a new number into the tree
    //     * @param a number to insert
    //     */
    //     void insert(int data);
    //
    //     /**
    //     * Compiles a pre-order traversal as a string
    //     * @return a pre-order traversal as a string
    //     */
    //     String preOrder();
    //
    //     /**
    //     * Compiles a post-order traversal as a string
    //     * @return a post-order traversal as a string
    //     */
    //     String postOrder();
    //
    //     /**
    //     * Compiles a in-order traversal as a string
    //     * @return a in-order traversal as a string
    //     */
    //     String inOrder();
    //
    //
  	// /**
    //     * Checks whether a number is in the tree
    //     * @param the number to check
    //     * @return true if the number is in the tree, false otherwise
    //     */
  	// boolean find(int data);
    //
  	// /**
    //     * Finds the index of a particular number in the tree.
    //     * If it does not exist, return -1
    //     * @param the number to look for
    //     * @return the index where it is located, or -1
    //     */
  	// int find(int data);
    //
  	// /**
    //     * Finds the minimum of the tree
    //     * @return the minimum value in the tree
    //     */
  	// int min();
    //
  	// /**
    //     * Finds the maximum of the tree
    //     * @return the maximum value in the tree
    //     */
  	// int max();
    //
    //
  	// /**
    //     * Deletes a number from the tree. DO NOT iterate
    //     * over the array to find the data. Make sure to
    //     * maintain the structure of the tree.
    //     * @param the number to delete
    //     */
  	// void delete(int data);



}
