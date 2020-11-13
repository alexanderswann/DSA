import java.util.*;
import java.io.*;
public class HuffmanCoding {
  public static void main(String[] args){
    String phrase = "hooray we are state champs";
    HashMap<String, Integer> frequencies = findFrequencies(phrase);
    Set<String> keys = frequencies.keySet();
    for(String key : keys){
      System.out.println(key + ", " + frequencies.get(key));
    }

    System.out.println("-----");

    NodeComparator comp = new NodeComparator();
    PriorityQueue<Node> q = new PriorityQueue<Node>(keys.size(), comp);

    for (String key : keys) {
      Node curr = new Node(key, frequencies.get(key));
      q.add(curr);
    }

    // while (q.peek() != null){
    //   Node curr = q.poll();
    //   System.out.println(curr.letter + ", " + curr.freq);
    // }

    Node curr = makeTree(q);

    FileWriter writer = null;
    try {
      writer = new FileWriter("../../codes.txt");
    }catch (IOException e){
      System.out.println("Messed up");
      e.printStackTrace();
    }

    // 0 is left, 1 is right
    makeCodes(curr, "", writer);

    try {
      writer.close();
    } catch(IOException e) {
      System.out.println("couldnt close");
      e.printStackTrace();
    }


  }
  public static void makeCodes(Node curr, String codeSoFar, FileWriter writer){
    if(curr == null){
      return;
    }else if (curr.letter != null){
      System.out.println(curr.letter + ": " + codeSoFar);
        try {
          writer.write(curr.letter + "," + codeSoFar + "\n");
        }catch(IOException e){
          System.out.println("cant write");
        }catch(NullPointerException e2){
          System.out.println("NullPointerException");
        }
    }else{
      makeCodes(curr.right, codeSoFar + "1", writer);
      makeCodes(curr.left, codeSoFar + "0", writer);
    }

  }

  public static Node makeTree(PriorityQueue<Node> q){
    while(q.size() > 1){
      Node smaller = q.poll();
      Node other = q.poll();

      int totalFreq = smaller.freq + other.freq;

      Node parent = new Node(null, totalFreq);
      parent.right = smaller;
      parent.left = other;
      q.add(parent);

    }
      return q.poll();
  }

  public static HashMap<String, Integer> findFrequencies(String phrase){
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0;i < phrase.length() ;i++) {
        String letter = phrase.substring(i, i+1);
        if(map.get(letter) == null){
          map.put(letter, 1);
        }else{
          int f = map.get(letter);
          map.replace(letter, f+1);
        }
    }
      return map;
  }



}
