import java.util.*;
public class GraphTraverser{

  ArrayList<Path> vL = new ArrayList<Path>();//visitedList
  public GraphTraverser(){

  }
  public ArrayList<Path> traverse(DataStructure<Path> ds, AdjacencyList graph, String startName){
    ds.add(new Path(graph.getVertex(startName)));
    while(ds.isEmpty() == false){
       Path v = new Path(ds.remove());
       System.out.println(v);
       if(vL.size()< graph.size() && v.getLastVertex().getFlag() == false ){
      vL.add(v);
    }
      if(v.getLastVertex().getFlag() == false){
        v.getLastVertex().setFlag(true);

        for (Vertex n : v.getLastVertex().AdjacentVerts() ) {
          if(n.getFlag() == false){
            ds.add(new Path(v, n));
          }
        }
      }
    }
    return vL;
  }

  public String printPaths(){
    String toReturn = "";
    for (Path p : vL) {
      toReturn += p.toString() + "\n";
    }
    return toReturn;
  }

  public String printEdges(){
    EdgeList toReturn = new EdgeList();
    int w;
    int tot = 0;
    for (int i = 1; i < vL.size(); i++) {
      Vertex v = vL.get(i).getLastVertex();
      Vertex v2 = vL.get(i).get2LastVertex();
      w = vL.get(i).getLastWeight();
      Edge e = new Edge(v, v2, w);
      toReturn.addEdge(e);
      tot += w;
    }
    return toReturn.toString() + "total weight: " + tot;
  }
}
