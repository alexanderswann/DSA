public class ArrayBST implements BST {

    private Integer arr[];
    public ArrayBST() {
        arr = new Integer[8];
        arr[0] = 0;
    }

    public boolean isEmpty() {
        return arr[0] == 0;
    }

    public void expand() {
        Integer[] arr2 = new Integer[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                arr2[i] = arr[i];
            }
        }

        arr = arr2;

        return;
    }

    public void insert(int i) {
        if (arr[1] == null) {
            arr[1] = i;
            arr[0]++;
            return;
        } else {
            insert(1, i);
        }
    }
    //currleft = arr[(2 * i) + 1]
    //currright = arr[2 * i]
    private void insert(int curr, int i) {
        if (arr[curr] == i) {
            System.out.println(i + " is already in the tree");
            return;

        } else if (i < arr[curr]) {

            if (lV(curr) == 0) { // if left exists but is empty
                arr[(2 * curr) + 1] = i;
                arr[0]++;
                return;
            } else if (lV(curr) == -1) {
                expand();
                arr[(2 * curr) + 1] = i;
                arr[0]++;
                return;
            } else {
                insert((2 * curr) + 1, i);
            }

        } else {
            if (rV(curr) == 0) {
                arr[2 * curr] = i;
                arr[0]++;
                return;
            } else if (rV(curr) == -1) {
                expand();
                arr[2 * curr] = i;
                arr[0]++;
                return;
            } else {
                insert(2 * curr, i);
            }
        }
    }

    public String preOrder() {
        return preOrder(1);
    }

    private String preOrder(int curr) {
        if (curr >= arr.length || arr[curr] == null) {
            return "";
        } else {
            String left = preOrder((2 * curr) + 1);
            String right = preOrder(2 * curr);
            return arr[curr] + " " + left + right;
        }
    }

    public String postOrder() {
        return postOrder(1);
    }

    private String postOrder(int curr) {
        if (curr >= arr.length || arr[curr] == null) {
            return "";
        } else {
            String left = postOrder((2 * curr) + 1);
            String right = postOrder(2 * curr);
            return left + right + arr[curr] + " ";
        }
    }

    public String inOrder() {
        return inOrder(1);
    }

    private String inOrder(int curr) {
        if (curr >= arr.length || arr[curr] == null) {
            return "";
        } else {
            String left = inOrder((2 * curr) + 1);
            String right = inOrder(2 * curr);
            return left + arr[curr] + " " + right;
        }
    }

    public boolean contains(int i) {
        return find(i) >= 0;
    }
    public int find(int i) {
        if (arr[1] == null) {
            return -1;
        } else {
            return find(1, i);
        }
    }

    private int find(int curr, int i) {
        if (arr[1] == null) {
            return -1;
        } else if (arr[curr] == i) {
            return curr;
        } else {
            if (i < arr[curr]) {
                if (lV(curr) <= 0) {
                    return -1;
                } else {
                    return find((2 * curr) + 1, i);
                }
            } else {
                if (rV(curr) <= 0) {
                    return -1;
                } else {
                    return find(2 * curr, i);
                }
            }
        }
    }

    public int min() {
        if (arr[1] == null) {
            return Integer.MAX_VALUE;
        }
        return min(1);
    }

    private int min(int curr) {
        if (lV(curr) <= 0) {
            return arr[curr];
        } else {
            return min((2 * curr) + 1);
        }
    }
    public int max() {
        if (arr[1] == null) {
            return Integer.MIN_VALUE;
        }
        return max(1);
    }

    private int max(int curr) {
        if (rV(curr) <= 0) {
            return arr[curr];
        } else {
            return max(2 * curr);
        }
    }

    public void delete(int i) {

        int curr = find(i);
        if (curr == -1) {
            System.out.println(i + " is not in the tree");
            return;
        } else {
            if (Ncase(curr) == -1) {
                arr[curr] = null;
                arr[0]--;
            } else if (Ncase(curr) == 2 || Ncase(curr) == 0) { //right and 2 case

                int pred = min(2 * curr);
                int data = pred;
                delete(pred);
                arr[curr] = data;

                return;
            } else if (Ncase(curr) == 1) { //left
                int sc = max(2 * curr + 1);
                int data = sc;
                delete(sc);
                arr[curr] = data;
                return;
            } else {
                System.out.println("you should not be here");
                return;
            }
        }

    }

    public int findParent(int i) {
        if (arr[1] == null) {
            return -1;
        } else {
            return findParent(1, i);
        }
    }

    public int findParent(int curr, int i) {
        if (curr >= arr.length || arr[curr] == null) {
            return -1;
        } else if (rV(curr) > 0 && arr[2 * curr] == i) {
            return curr;
        } else if (lV(curr) > 0 && arr[(2 * curr) + 1] == i) {
            return curr;
        } else if (i > arr[curr]) {
            return findParent((2 * curr), i);
        } else {
            return findParent(((2 * curr) + 1), i);
        }
    }

    private int Ncase(int i) {
        if (lV(i) > 0 && rV(i) > 0) { //2 case
            return 2;
        } else if (lV(i) > 0 && rV(i) <= 0) { //left no right
            return 1;
        } else if (lV(i) <= 0 && rV(i) > 0) { //right no left
            return 0;
        } else if (lV(i) <= 0 && rV(i) <= 0) { //leaf case
            return -1;
        } else {
            return -3;
        }
    }

    private int lV(int i) {
        if ((2 * i) + 1 < arr.length) {
            if (arr[(2 * i) + 1] == null) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

    private int rV(int i) {
        if ((2 * i) < arr.length) {
            if (arr[2 * i] == null) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

    public String ind(int i) {
        if (i < arr.length && i >= 0) {
            return arr[i] + "";
        } else {
            return "index out of bounds";
        }
    }


    public String toString() {
        String toRet = "";

        for (int i = 0; i < arr.length; i++) {
            toRet += arr[i] + " ";
        }

        return toRet;
    }

}
