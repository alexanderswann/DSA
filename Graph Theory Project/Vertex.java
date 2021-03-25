import java.util.*;
public class Vertex{
    String name;
    boolean isVisited;


    public Vertex(String name){
      this.name = name;
      isVisited = false;

    }

    HashMap<Vertex, Integer> neighbors = new HashMap<Vertex, Integer>();

    public void addNeighbor(Vertex v, int edge_weight){
        if(v.name.equals(name)){
          System.out.println("you are trying to add a vertex to its own adjacency list");
        }else{
          neighbors.put(v, edge_weight);
          //v.addNeighbor(vert, edge_weight);
        }

    }



    public Vertex getNeighbor(String v){
      for (Vertex key: neighbors.keySet()) {
        if(key.name.equals(v)){
          return key;
        }
      }
      return null;
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
      Boolean c = false;
      for (Vertex key: neighbors.keySet()) {
        if(key.name.equals(n)){
          c = true;
        }
      }
      if (c){
        System.out.println("chose a different name");
      }else{
        name = n;
        System.out.println("Name was set to " + n);
      }


    }

    public String AdjacentVerts2(){
      String toReturn = name + ": ";
      for (Vertex key: neighbors.keySet()) {
          toReturn += "<" + key.name + ", " + neighbors.get(key) + "> ";

      }
      return toReturn;
    }

    public ArrayList<Vertex> AdjacentVerts(){
      ArrayList<Vertex> toReturn = new ArrayList<Vertex>();
      for (Vertex key: neighbors.keySet()) {
          toReturn.add(key);

      }
      return toReturn;
    }

    public String toString(){
      String toReturn = name + ": ";
      for (Vertex key: neighbors.keySet()) {
          toReturn += "<" + key.name + ", " + neighbors.get(key) + "> ";

      }
      return name;
    }


}
