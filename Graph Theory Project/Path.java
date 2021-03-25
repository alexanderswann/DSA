import java.util.*;
public class Path{
    ArrayList<Vertex> newPath = new ArrayList<Vertex>();
    int pathDistance;
    int lastWeight;

    public Path(Vertex v){
        newPath.add(v);
        pathDistance  = 0;
        lastWeight = 0;

    }

    public Path(Path p){
        for (Vertex v: p.pathList()) {
          newPath.add(v);
        }
        pathDistance = p.getpathDistance();
        lastWeight =   p.getLastWeight();
    }

    public Path(Path p, Vertex V){
        for (Vertex v: p.pathList()) {
          newPath.add(v);
        }
        pathDistance = p.getpathDistance();
        lastWeight =   p.getLastWeight();

        addVertex(V);
    }

    public void addVertex(Vertex v){
      newPath.add(v);
      System.out.println(newPath);
      System.out.println(newPath.get(newPath.size()-1));
      System.out.println(v);
      int tempint = (newPath.get(newPath.size()-2)).weightNeighbor(v);

      System.out.println("hello " + newPath.get(newPath.size()-2) + "bro");


      pathDistance += tempint;
      lastWeight = tempint;
      return;

    }

    public int getpathDistance(){
      return pathDistance;
    }

    public ArrayList<Vertex> pathList(){
      return newPath;
    }

    public int getLastWeight(){
      return lastWeight;
    }

    public int getTotalLength(){
      return newPath.size();
    }

    public Vertex getByIndex(int j){
      return newPath.get(j);
    }
    public Vertex get2LastVertex(){
      return newPath.get(newPath.size()-2);
    }

    public Vertex getLastVertex(){
      return newPath.get(newPath.size()-1);
    }

    public String toString(){
      String toReturn = "Path: ";
      for(Vertex v: newPath){
        toReturn += v.getName() + "->";
      }
      toReturn += "Distance: " + pathDistance;
      return toReturn;
    }

}
