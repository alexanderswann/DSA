import java.util.*;
  public class NodeComparator implements Comparator<Node>{
    public int compare(Node a, Node b){
      return a.freq  - b.freq;
    }
  }
