/**
 * Interface for a binary search tree that uses an array
 * @author Ms. Snyder
 * @version 4.0, Updated 5 Oct 2017
 *
 */

public interface BST {

    /**
     * Checks whether the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Makes the array twice as large and moves all the data
     * into the bigger array.
     */
    void expand();

    /**
     * Inserts a new number into the tree
     * @param a number to insert
     */
    void insert(int data);

    /**
     * Compiles a pre-order traversal as a string
     * @return a pre-order traversal as a string
     */
    String preOrder();

    /**
     * Compiles a post-order traversal as a string
     * @return a post-order traversal as a string
     */
    String postOrder();

    /**
     * Compiles a in-order traversal as a string
     * @return a in-order traversal as a string
     */
    String inOrder();


    /**
     * Checks whether a number is in the tree
     * @param the number to check
     * @return true if the number is in the tree, false otherwise
     */
    boolean contains(int data);

    /**
     * Finds the index of a particular number in the tree.
     * If it does not exist, return -1
     * @param the number to look for
     * @return the index where it is located, or -1
     */
    int find(int data);

    /**
     * Finds the minimum of the tree
     * @return the minimum value in the tree
     */
    int min();

    /**
     * Finds the maximum of the tree
     * @return the maximum value in the tree
     */
    int max();


    /**
     * Deletes a number from the tree. DO NOT iterate
     * over the array to find the data. Make sure to
     * maintain the structure of the tree.
     * @param the number to delete
     */
    void delete(int data);
}
