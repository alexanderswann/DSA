import java.util.*;
public class Vertex{
    String name;
    boolean isVisited;

    public Vertex(String name){
      this.name = name;
    }

    HashMap<Vertex, Integer> neighbors = new HashMap<Vertex, Integer>();

    public void addNeighbor(Vertex v, int edge_weight){
        if(v.name.equals(name)){
          System.out.println("you are trying to add a vertex to its own adjacency list");
        }else{
          neighbors.put(v, edge_weight);
        }

    }

    public int weightNeighbor(Vertex v){
      return neighbors.get(v);
    }

    public String getName(){
      return name;
    }

    public Boolean getFlag(){
      return isVisited;
    }

    public int setFlag(boolean b){
      if(isVisited == b){
        System.out.println("the flag of "+name +" was already " + (b?"true":"false")+ " and you tried to set it to that");
        return -1;
      }else {
        isVisited = b;
        System.out.println("the flag of "+name +" was set to" + (b?"true":"false"));
        return 1;
      }

    }

    public void setName(String n){
      name = n;
      System.out.println("Name was set to " + n);
    }

    public String AdjacentVerts(){
      String toReturn = name + ": ";
      for (Vertex key: neighbors.keySet()) {
          toReturn += "<" + key.name + ", " + neighbors.get(key) + "> ";

      }
      return toReturn;
    }


}
