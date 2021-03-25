import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class GraphTester{
	public static void main(String[] args){

			ArrayList<Vertex> vertexes = new ArrayList<Vertex>();



			vertexes.add(new Vertex("r"));
			vertexes.add(new Vertex("f"));
			vertexes.add(new Vertex("d"));
			vertexes.add(new Vertex("b"));
			vertexes.add(new Vertex("c"));
			Vertex m = vertexes.get(0);
			Vertex n = vertexes.get(2);
			vertexes.get(0).setName("a");
			m.addNeighbor(vertexes.get(1), 32);
			m.addNeighbor(vertexes.get(2), 232);
			m.addNeighbor(vertexes.get(3), 320);
			m.addNeighbor(vertexes.get(4), 22);
			m.addNeighbor(vertexes.get(4), 21);
			m.addNeighbor(vertexes.get(0), 22);
			n.addNeighbor(vertexes.get(1), 03);
			vertexes.get(1).addNeighbor(vertexes.get(3), 93);
			vertexes.get(3).addNeighbor(vertexes.get(4), 91);
			System.out.println(m.AdjacentVerts());
			System.out.println(m.weightNeighbor(n));
			System.out.println("-----");
			System.out.println(m);
			System.out.println(n);
			System.out.println("-----");

			Path newPath = new Path(m);
			Path newPath2 = new Path(m);



			newPath.addVertex(n);
			newPath.addVertex(vertexes.get(1));
			newPath.addVertex(vertexes.get(3));
			newPath.addVertex(vertexes.get(4));

			newPath2.addVertex(n);
			newPath2.addVertex(vertexes.get(1));
			newPath2.addVertex(vertexes.get(3));



			System.out.println(newPath);
			System.out.println(vertexes);
			System.out.println(newPath.getpathDistance());
			System.out.println(newPath.pathList());
			System.out.println(newPath.getLastWeight());
			System.out.println(newPath.getTotalLength());
			System.out.println(newPath.getByIndex(3));
			System.out.println(newPath.getLastVertex());
			System.out.println(newPath.toString());
			System.out.println("-------------");
			System.out.println(vertexes);
			System.out.println("-------------");

			MyStack<Vertex> stack = new MyStack<Vertex>();
			System.out.println(stack.isEmpty());
			stack.add(vertexes.get(0));
			stack.add(vertexes.get(1));
			stack.add(vertexes.get(2));
			stack.add(vertexes.get(3));
			System.out.println(stack.toString());
			stack.remove();
			System.out.println(stack.isEmpty());
			System.out.println(stack.toString());

			System.out.println("-------------");

			MyQ<Vertex> q = new MyQ<Vertex>();
			System.out.println(q.isEmpty());
			q.add(vertexes.get(0));
			q.add(vertexes.get(1));
			q.add(vertexes.get(2));
			q.add(vertexes.get(3));
			System.out.println(q.toString());
			q.remove();


			System.out.println(q.isEmpty());
			System.out.println(q.toString());

			System.out.println("-------------");

			MyPQ<Path> pq = new MyPQ<Path>(new DijkstraComparator());
			System.out.println(pq.isEmpty());
			pq.add(newPath);
			pq.add(newPath2);

			System.out.println(pq.toString());
			pq.remove();


			System.out.println(pq.isEmpty());
			System.out.println(pq.toString());

			System.out.println("-------------");


					//aL.getVertex("A").setName("Y");
					//aL.reset();

			// MyPQ<Path> pq2 = new MyPQ<Path>(new PrimComparator());
			// System.out.println(pq2.isEmpty());
			// pq2.add(newPath);
			// pq2.add(newPath2);
			//
			// System.out.println(pq2.toString());
			// pq2.remove();
			//
			// System.out.println(pq2.isEmpty());
			// System.out.println(pq2.toString());
			// GraphTraverser trav = new GraphTraverser();
			// trav.traverse( new MyQ<Path>() , aL, "A" );
			// System.out.println(trav.printPaths());

			// GraphTraverser trav = new GraphTraverser();
			// trav.traverse( new MyPQ<Path>(new DijkstraComparator()) , aL, "A" );
			// System.out.println(trav.printPaths());
System.out.println("----------------");
			 GraphTraverser trav = new GraphTraverser();
			// trav.traverse( new MyStack<Path>(), aL, "P" );
			// System.out.println("----------------");
			// System.out.println(trav.printPaths());

			// GraphTraverser trav = new GraphTraverser();
			// trav.traverse(  new MyPQ<Path>(new PrimComparator()), aL, "P" );
			// System.out.println("----------------");
			// System.out.println(trav.printPaths());
			// System.out.println(trav.printEdges());


			System.out.println("pick a graph file: 1, 2, or 3");
			Scanner scan = new Scanner(System.in);
			int i = scan.nextInt();


				AdjacencyList aL = null;
				try {
					aL = new AdjacencyList("graph" + i + ".txt");
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println(aL.toString());

				System.out.println("which algorithm?: 1 for DFS, 2 for BFS, 3 for Dijkstra, 4 for Prims");
				Scanner scan2 = new Scanner(System.in);

			int i2 = scan2.nextInt();

			System.out.println("what vertex do you want to start at?");
			Scanner scan3 = new Scanner(System.in);

		String s = scan3.next();
		System.out.println("would you like a path or edge list: 1 for path, 2 for edge");
		Scanner scan4 = new Scanner(System.in);

	int i3 = scan4.nextInt();

			if(i2 ==1){
				//GraphTraverser trav = new GraphTraverser();
				trav.traverse(  new MyStack<Path>(), aL, s );
			}else if(i2 ==2){
				//GraphTraverser trav = new GraphTraverser();
				trav.traverse(  new MyQ<Path>(), aL, s );
			}else if(i2 == 3){
				//GraphTraverser trav = new GraphTraverser();
				trav.traverse(  new MyPQ<Path>(new DijkstraComparator()), aL, s );
			}else if(i2 ==4){
				//1GraphTraverser trav = new GraphTraverser();
				trav.traverse(  new MyPQ<Path>(new PrimComparator()), aL, s );
			}

			if(i3 == 1){
				System.out.println("__________________");
				System.out.println(trav.printPaths());
			}else if(i3 == 2){
				System.out.println("__________________");
				System.out.println(trav.printEdges());
			}






  }
}
