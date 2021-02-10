import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AdjacencyListTemplate {

	private ArrayList<Vertex> vertexes;

	HM <Vertex, Integer> ~~~~;
	map = new HM <V,X>();
	map.put(vertex, weight);
	map.get(vertex);
	map.keySet();
	-> set<vertex>

	public AdjacencyListTemplate(String fn) throws IOException{ //takes in the file you want to be read

		vertexes = new ArrayList<Vertex>();

		Scanner fscan = new Scanner(new File(fn)); //initiates file scanner
		while(fscan.hasNextLine()){ //while there are still lines left in the file
			String line = fscan.nextLine(); //read one in

			//process (parse) string

			//make vertex(es)

			//add vertex to list, being careful about duplicates

		}
	}

	public Vertex getVertex(String name){
		return null;
	}

	public void reset(){
	}

	public String toString(){
		return "";

	}

	public static void main(String[] args){
		AdjacencyList aL = null;
		try {
			aL = new AdjacencyList("graph1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(aL.toString());
		System.out.println(aL.getVertex("A"));
	}
}
