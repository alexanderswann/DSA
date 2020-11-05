import java.util.*;
public class HuffmanCoding {
  public static void main(String[] args){
    String phrase = "hooray weve been state champs";
    HashMap<String, Integer> frequencies = findFrequencies(phrase);
    Set<String> keys = frequencies.keySet();
    for(String key : keys){
      System.out.println(key + ", " + frequencies.get(key));
    }

    NodeComparator comp = new NodeComparator();
    PriorityQueue<Node> q = new PriorityQueue<Node>(keys.size(), comp);

    for (String key : keys) {
      Node curr = new Node(key, frequencies.get(key));
      q.add(curr);
    }

    while (q.peek() != null){
      Node curr = q.poll();
      System.out.println(curr.letter + ", " + curr.freq);
    }
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
