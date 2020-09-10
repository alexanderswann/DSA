import java.util.ArrayList;
public class DoublyLinkedList {
  private Node head,
  tail;
  private int length;

  public DoublyLinkedList() {
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

  public void add2End(String data) {
    Node toAdd = new Node(data);

    if (tail == null && head == null) {
      toAdd.next = null;
      toAdd.prev = null;
      tail = toAdd;
      head = toAdd;
      length++;
			System.out.println("monkey shits");
      return;
    }

    toAdd.next = null;
    toAdd.prev = tail;

    tail.next = toAdd;

    tail = toAdd;

    length++;

  }
	public Node rH(){
		return head;
	}
	public Node rT(){
		return tail;
	}

  public void add2Front(String data) {
    Node toAdd = new Node(data);

    if (tail == null && head == null) {
      toAdd.next = null;
      toAdd.prev = null;
      tail = toAdd;
      head = toAdd;
      length++;
			System.out.println("monkey shit2s");
      return;
    }

    toAdd.prev = null;
    toAdd.next = head;

    head.prev = toAdd;

    head = toAdd;
    length++;

  }

  public Boolean add2Index(int index, String data) {
		if(length -1 >= index) {
			if(index == 0){
				add2Front(data);
				return true;
			}else if(length == 1){
				add2Front(data);
				return true;
			}else{
				Node toAdd = new Node(data);
				if (length / 2 >= index) {
					Node curr = head;
					for (int i = 0; i < index -1 ; i++) {
						curr = curr.next;
					}

					 toAdd.next = curr.next;
					 curr.next = toAdd;
					 toAdd.prev = curr;
					 toAdd.next.prev = toAdd;
					 length++;
					return true;


				} else {

					Node curr = tail;
					for (int i = length-index; i  > 0; i--) {
						curr = curr.prev;
						System.out.println("from the back");
					}
						toAdd.next = curr.next;
						curr.next = toAdd;
						toAdd.prev = curr;
						toAdd.next.prev = toAdd;
						length++;

						return true;


				}
			}
		}else if(length == 0) {
			add2Front(data);
			return true;
		}else{
			return false;
		}
  }

	public ArrayList<Integer> removeAll(String data){
		ArrayList<Integer> ind = new ArrayList<Integer>();
		Node curr1 = head;
		int count1 = 0;
		Node curr2 = tail;
		int count2 = length;
		if (length % 2 == 1){
			if(curr1.data.equals(data)){
				ind.add(count1);
				remove(0);
			}
			count1++;
			curr1 = curr1.next;
		}

		for(int i = 0; i< length/2; i++){

			if(curr1.data.equals(data)){
				ind.add(count1);
				remove(i);
			}

			if(curr2.data.equals(data)){
				ind.add(count2);
				remove(length-i);
			}

			count1++;
			count2--;
			curr1 = curr1.next;
			curr2 = curr2.prev;
		}
		return ind;

	}

	public Node findMiddle(){
		Node curr = head;
		if (length % 2 == 0){
			for (int i = 0; i < (length/2)-1 ; i++) {
				curr = curr.next;
			}
			return curr;
		}else{
			for (int i = 0; i < (length/2) ; i++) {
				curr = curr.next;
			}
			return curr;
		}
	}

  public String toString() {
    String toReturn = "";
    Node curr = head;
    while (curr != null) {
      toReturn += curr.toString();
      curr = curr.next;
    }
    return toReturn;
  }

	public int size(){
		return length;
	}
	public void bounce(){
		add2Front(tail.data);
		remove(length -1);

	}
	public String remove(int index){
		if (index > length -1){
			return null;
		}else{
			if(length == 0){
				System.out.println("no items to remove");
				return null;
			}else if(length == 1){
				Node curr = head ;
				String toReturn = "";
				toReturn += curr.toString();

				head = null;
				tail = null;
				length--;
				return toReturn;
			}else{

				if (length / 2 > index) {
					Node curr = head;
					for (int i = 0; i < index ; i++) {
						curr = curr.next;
					}
					length--;
					String toReturn = "";
					toReturn += curr.toString();

					if (curr.prev == null){
						head = curr.next ;
						curr.next.prev = null;
					}else{
						curr.next.prev = curr.prev;
						curr.prev.next = curr.next;
					}


					System.out.println("index " + index + " was removed");
					return toReturn;
					//remove

				} else {
					Node curr = tail;
					for (int i = length-index-1; i > 0; i--) {
						curr = curr.prev;
						System.out.println("from the back");
					}
					length--;
					String toReturn = "";
					toReturn += curr.toString();
					if (curr.next == null){
						tail = curr.prev ;
						curr.prev.next = null;

					}else{
						curr.next.prev = curr.prev;
						curr.prev.next = curr.next;
					}


					System.out.println("index " + index + " was removed");
					return toReturn;

				}
		}


		}
	}

	public String reverseToString(){
		String toReturn = "";
    Node curr = tail;
    while (curr != null) {
      toReturn += curr.toString();
      curr = curr.prev;
    }
    return toReturn;
	}

  class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data) {
      this.data = data;
      next = null;
      prev = null;
    }

    public String toString() {
      return data + " > ";
    }
  }

}
