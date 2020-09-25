import java.util.ArrayList;
public class DoublyLinkedList <E extends Comparable<E>>{
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

  public void add2End(E data) {
    Node toAdd = new Node(data);

    if (tail == null && head == null) {
      toAdd.next = null;
      toAdd.prev = null;
      tail = toAdd;
      head = toAdd;
      length++;

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

  public void add2Front(E data) {
    Node toAdd = new Node(data);

    if (tail == null && head == null) {
      toAdd.next = null;
      toAdd.prev = null;
      tail = toAdd;
      head = toAdd;
      length++;

      return;
    }

    toAdd.prev = null;
    toAdd.next = head;

    head.prev = toAdd;

    head = toAdd;
    length++;

  }

  public Boolean add2Index(int index, E data) {
		if(length -1 >= index ) {
			if (index < 0) {
        return false;
      }else if(index == 0){
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
						//System.out.println("from the back");
					}
						toAdd.next = curr.next;
						curr.next = toAdd;
						toAdd.prev = curr;
						toAdd.next.prev = toAdd;
						length++;

						return true;


				}
			}
		}else if(index == length){
      add2End(data);
			return true;
    }else if(index > length){
      return false;
    }else if(length == 0) {
			add2Front(data);
			return true;
		}else{
			return false;
		}
  }

	public void addInOrder(E data){

			if (length == 0) {
				add2Front(data);
        return;
			}
      Node mid = findMiddle();
      E dat = mid.data;
      int d = data.compareTo(dat);
      System.out.println(d);
      if (d < 0){
        Node curr = head;
				for (int i = 0; i < length ; i++) {
					if (data.compareTo(curr.data) < 0) {
						if (i ==0){
							add2Front(data);
						}else{
							add2Index(i , data);
						}
						return;
					}
					curr= curr.next;
				}

      }else{
				Node curr = tail;
				for (int i = 0; i < length ; i++) {
					if (data.compareTo(curr.data) > 0) {
						if (i == 0){
							add2End(data);
						}else{
							add2Index(length - i , data);
						}

						return;
					}
					curr= curr.prev;
				}

			}
	}


  //O(n)
	public ArrayList<Integer> removeAll(E data){
		ArrayList<Integer> ind = new ArrayList<Integer>();
		Node curr1 = head;
		int count1 = 0;
		int len  = length;



		for(int i = 0; i < length+count1; i++){

			if(curr1.data.equals(data)){

				ind.add(i);
				remove(i - count1);
				curr1 = curr1.next;
				count1++;


			}else{

				curr1 = curr1.next;
			}

		}
		return ind;

	}


  //O(n)
  public int indexOf(E data){
    Node curr1 = head;
    for(int i = 0; i < length; i++){
      if(curr1.data.equals(data)){
        return i;
      }
      curr1 = curr1.next;
    }
    return -1;
  }


  //O(n/2)
	public Node findMiddle(){
		Node curr = head;
		if (length % 2 == 0){
			for (int i = 0; i < (length/2)-1 ; i++) {
				curr = curr.next;
			}

      return curr;
      // Node curr1 = curr.prev;
      // if(curr1.data.compareTo(curr.data) > 1){
      //   return curr1;
      // }else{
      //   return curr;
      // }
		}else{
			for (int i = 0; i < (length/2) ; i++) {
				curr = curr.next;
			}
			return curr;
		}
	}

  //O(n)
  public String toString() {
    String toReturn = "";
    Node curr = head;
    while (curr != null) {
      toReturn += curr.toString();
      curr = curr.next;
    }
    return toReturn;
  }


  //O(1)
	public int size(){
		return length;
	}

  //O(1)
	public void bounce(){
		if (length > 0){
			add2Front(tail.data);
			remove(length -1);
			return;
		}else{
			return;
		}


	}

  //O(n)
	public E remove(int index){
		if (index > length -1){
			return null;
		}else{
			if(length == 0){
				System.out.println("no items to remove");
				return null;
			}else if(length == 1){
				Node curr = head ;
				E toReturn = curr.data;
				//toReturn += curr.toString();

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
					E toReturn = curr.data;
					//toReturn += curr.toString();

					if (curr.prev == null){
						head = curr.next ;
						curr.next.prev = null;
					}else{
						curr.next.prev = curr.prev;
						curr.prev.next = curr.next;
					}


					//System.out.println("index " + index + " was removed");
					return toReturn;
					//remove

				} else {
					Node curr = tail;
					for (int i = length-index-1; i > 0; i--) {
						curr = curr.prev;
						//System.out.println("from the back");
					}
					length--;
					E toReturn = curr.data;
					//toReturn += curr.toString();
					if (curr.next == null){
						tail = curr.prev ;
						curr.prev.next = null;

					}else{
						curr.next.prev = curr.prev;
						curr.prev.next = curr.next;
					}


					//System.out.println("index " + index + " was removed");
					return toReturn;

				}
		}


		}
	}
  //O(n)
	public String reverseToString(){
		String toReturn = "";
    Node curr = tail;
		if(length == 0){
			toReturn += "Your list is empty";
		}else{
    while (curr != null) {
      toReturn += curr.toString();
      curr = curr.prev;
    }
	}
    return toReturn;
	}

  class Node {
    E data;
    Node next;
    Node prev;

    public Node(E data) {
      this.data = data;
      next = null;
      prev = null;
    }

    public String toString() {
      return data + ", ";
    }
  }

}
