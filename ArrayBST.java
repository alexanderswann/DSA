public class ArrayBST {

  Integer arr[];

  public ArrayBST () {
    arr = new Integer[8];
    arr[0] = 0;
  }

  private int case(int i){
    if(lV(i) > 0 && rV(i) > 0) {//2 case
      return 2;
    }else if(lV(i) > 0 && rV(i) =< 0){//left no right
      return 1;
    }else if(lV(i) =< 0 && rV(i) > 0){//right no left
      return 0;
    }else if(lV(i) =< 0 && rV(i) =< 0){//leaf case
      return -1;
    }
  }

  private int lV(int i){
    if((2*i) + 1 < arr.length)){
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
    if((2*i) < arr.length)){
      if(arr[2*i] == null){
        return 0;
      }else{
        return 1;
      }
    }else{
      return -1;
    }
  }

  public boolean add(int i){
    if(arr[1] == null){
      arr[1] = i
    }else{
      return add(curr, i);
    }
  }
  //currleft = arr[(2 * i) + 1]
  //currright = arr[2 * i]
  private boolean add(int curr, int i){
    if(arr[curr] == i){
      return false;

    }else if (i < arr[curr]) {

      if(lV(curr) == 0){// if left exists but is empty
        arr[(2 * curr) + 1] = i;
        return true;
      }else if(lV(curr) == -1){
        resize();
        arr[(2 * curr) + 1] = i;
        return true;
      } else{
        return add((2 * curr) + 1, i)
      }

    }else{
      if(rV(curr) == 0){
        arr[2 * curr] = i;
        return true;
      }else if (rV(curr) == -1) {
        resize();
        arr[2 * curr] = i;
        return true;
      }else{
        return add(2 * curr, i)
      }
    }
  }

  private void resize(){
    Integer[] arr2 = new Integer[arr.length * 2];

    for(int i = 0; i< arr.length;i++){
      if(arr[i] != null){
        arr2[i] = arr[i];
      }
    }

    arr = arr2;
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
  	// boolean contains(int data);
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
