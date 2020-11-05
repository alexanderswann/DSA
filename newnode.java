public class Node {
	private Node next;
	private Dt data;
	public Node(dT data){
		this.data = data;
		next = null;
	}
	public dT getData(){
		return data;
	}

	public Node getNext(){
		return next;
	}

	public void setData(dt newData){
		data = newData;
	}

	public void setNext(Node nextNode){
		next = nextNode;
	}
	public String toString(){
		return data + "->"
	}
}
