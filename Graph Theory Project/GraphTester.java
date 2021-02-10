import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class GraphTester{
	public static void main(String[] args){

			ArrayList<Vertex> vertexes = new ArrayList<Vertex>();



			vertexes.add(new Vertex("hi"));
			vertexes.add(new Vertex("alexander"));
			vertexes.add(new Vertex("andrew"));
			vertexes.add(new Vertex("william"));
			vertexes.add(new Vertex("swann"));
			Vertex m = vertexes.get(0);
			Vertex n = vertexes.get(2);
			vertexes.get(0).setName("hello");
			m.addNeighbor(vertexes.get(1), 32);
			m.addNeighbor(vertexes.get(2), 232);
			m.addNeighbor(vertexes.get(3), 320);
			m.addNeighbor(vertexes.get(4), 22);
			m.addNeighbor(vertexes.get(4), 21);
			m.addNeighbor(vertexes.get(0), 22);
			System.out.println(m.AdjacentVerts());
			System.out.println(m.weightNeighbor(n));



  }
}
