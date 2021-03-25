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

			//System.out.println(vert1 +"|" + vert2 +"|"+ weight);//this was used to make sure i was parsing correctly


			Vertex temp1 = new Vertex(vert1);
			Vertex temp2 = new Vertex(vert2);

			Boolean t1 = true;
			Boolean t2 = true;

			for (Vertex v: vertexes) {
				if(v.getName().equals(temp1.getName())){
					t1 = false;
					temp1 = v;
				}
				if (v.getName().equals(temp2.getName())) {
					t2 = false;
					temp2 = v;
				}
			}

			if(t1){
				vertexes.add(temp1);
			}

			if(t2){
				vertexes.add(temp2);
			}

			temp1.addNeighbor(temp2, weight);
			temp2.addNeighbor(temp1, weight);

		}
	}

	public Vertex getVertex(String name){
		for (Vertex v: vertexes) {
			if(v.getName().equals(name)){
				return v;
			}
		}
		System.out.println("the vertex you are searching for is not in the list");
		return null;
	}

	public void reset(){
		for (Vertex v: vertexes) {
			v.setFlag(false);
		}
	}

	public int size(){
		return vertexes.size();
	}

	public String toString(){
		String toReturn = "";
		for (Vertex v: vertexes) {
			toReturn += v.AdjacentVerts2() + "\n";
		}
		return toReturn;
	}

	public static void main(String[] args){
		AdjacencyList aL = null;
		try {
			aL = new AdjacencyList("graph2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(aL.toString());
		System.out.println(aL.getVertex("A"));
		aL.getVertex("A").setName("Y");
		//aL.reset();
		System.out.println(aL.toString());

	}
}
