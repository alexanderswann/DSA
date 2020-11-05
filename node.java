import java.util.*;
  public class Node {
    Node right, left;
    int freq;
    String letter;

    public Node (String letter, int freq){
      this.letter = letter;
      this.freq = freq;
    }
  }
