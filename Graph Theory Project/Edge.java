import java.util.*;
public class Edge{

  Vertex vert1;
  Vertex vert2;
  int weight;

  public Edge(Vertex v1, Vertex v2, int w1){
      vert1 = v1;
      vert2 = v2;
      weight = w1;

  }

  public void setWeight(int w){
    weight = w;
  }

  public int getWeight(){
    return weight;
  }

  public String toString(){
    return vert1 + "<->" + vert2 + " " + weight;
  }

}
