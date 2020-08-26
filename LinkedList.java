public class LinkedList{
	private Node head;

	public LinkedList(){
		head = null;
	}

	/*
	we always need to account for:
		0 case
		1 case
		many case	
	*/

	public void add(String data){
		Node toAdd = new Node(data);

		//0 case
		if (head == null){
			head = toAdd;
		} else if (head.next == null) { //1 case
			head.next = toAdd;
		} else { //many case
			Node curr = head;
			while (curr.next != null){
				curr = curr.next;
			}
			curr.next = toAdd;
		}
	}

	public String get(int index){
		//assume valid index
		Node curr = head;
		for (int i = 0 ; i < index; i++){
			curr = curr.next;
		}
		//when I'm done with this loop, who is curr pointing at?
		return curr.data;
	}

	public void add2Index(int index, String data){
		Node toAdd = new Node(data);
		Node curr = head;
		if (head == null){
			if (index == 0){
				head = toAdd;
			} else {
				System.out.println("invalid index");
			}
		}else if (index == 0){
			toAdd.next = head;
			head = toAdd;
		} else {
			//many case
			for (int i = 0; i < index - 1; i++){
				curr = curr.next;
			}
			toAdd.next = curr.next;
			curr.next = toAdd;
		}

	}
	
	public String toString(){
		String toReturn = "";
		Node curr = head;
		while (curr != null){
			toReturn += curr.toString();
			curr = curr.next;
		}
		return toReturn;
	}

	class Node {
		String data;
		Node next;

		public Node(String data){
			this.data = data;
			next = null;
		}

		public String toString(){
			return data + "-> ";
		}
	}

}