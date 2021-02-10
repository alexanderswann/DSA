import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class AdjacencyList {

	private ArrayList<Vertex> vertexes;

	public AdjacencyList(String fn) throws IOException{ //takes in the file you want to be read

		vertexes = new ArrayList<Vertex>();

		Scanner fscan = new Scanner(new File(fn)); //initiates file scanner
		while(fscan.hasNextLine()){ //while there are still lines left in the file
			String line = fscan.nextLine(); //read one in
			String vert1 = line.substring(0, line.indexOf(" "));
			line = line.substring(line.indexOf(" ")+ 1, line.length());
			String vert2 = line.substring(0, line.indexOf(" "));
			int weight =  Integer.parseInt(line.substring(line.indexOf(" ")+1, line.length()));

			System.out.println(vert1 +"|" + vert2 +"|"+ weight);


			Vertex temp1 = new Vertex(vert1);
			Vertex temp2 = new Vertex(vert2);


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
