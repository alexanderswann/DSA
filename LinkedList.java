public class LinkedList{
	private Node head, tail;
	private int length;

	public LinkedList(){
		head = null;
		tail = null;
		length = 0;
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
			tail = toAdd;
		} else if (head.next == null) { //1 case
			head.next = toAdd;
			tail = head.next;
		} else { //many case
			/*Node curr = head;
			while (curr.next != null){
				curr = curr.next;
			}
			curr.next = toAdd;
			*/
			tail.next = toAdd;
			tail = tail.next;
		}
		length++;
	}

	public String get(int index){
		if (index < 0 || index >=length){
			return null;
		}
		if (index == length -1 ){
			return tail.data;
		}
		Node curr = head;
		for (int i = 0 ; i < index; i++){
			curr = curr.next;
		}
		//when I'm done with this loop, who is curr pointing at?
		return curr.data;
	}

	public void add2Index(int index, String data){
		if (index < 0 || index > length){
			System.out.println("invalid index");
			return;
		}

		Node toAdd = new Node(data);
		Node curr = head;
		if (head == null){
			head = toAdd;
			tail = head;
		}else if (index == 0){
			toAdd.next = head;
			head = toAdd;
		} else if (index == length){
			tail.next = toAdd;
			tail = toAdd;
		} else {
			//many case
			for (int i = 0; i < index - 1; i++){
				curr = curr.next;
			}
			toAdd.next = curr.next;
			curr.next = toAdd;
		}

		length++;

	}

	public String remove(int index){
		if (index < 0 || index >=length){
			return null;
		} else {
			if (index == 0){ //removing head;
				String dataToReturn = head.data;
				head = head.next;
				if (length == 1){
					tail = null;
				}
				length--;
				return dataToReturn;
			} else if (index == length - 1){ //removing tail
				Node curr = head;
				for (int i = 0 ; i < index - 1; i++){
					curr = curr.next;
				}
				String dataToReturn = tail.data;
				tail = curr;
				curr.next = null;
				length--;
				return dataToReturn;
			} else { //removing middle
				Node curr = head;
				for (int i = 0; i < index - 1; i++){
					curr = curr.next;
				}
				//save data
				String dataToSave = curr.next.data;
				//mess with pointers
				curr.next = curr.next.next;
				length--;
				//return data
				return dataToSave;

			}
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
