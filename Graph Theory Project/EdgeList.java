import java.util.*;
public class EdgeList{
  ArrayList<Edge> newList = new ArrayList<Edge>();
  public EdgeList(){
    
  }
  public void addEdge(Edge e){
    newList.add(e);
  }
  public String toString(){
    String toReturn = "";

    for(Edge e : newList){
      toReturn += e + "\n";
    }
    return toReturn;
  }
}
