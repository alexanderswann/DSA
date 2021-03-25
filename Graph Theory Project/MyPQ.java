import java.util.*;
public class MyPQ<E> implements DataStructure<E>{

  private PriorityQueue<E> pq;
  public MyPQ(Comparator<E> comparator){
    pq = new PriorityQueue<E>(10, comparator);

  }

  public void add(E item){
     pq.add(item);
  }

  public E remove(){
    return pq.poll();
  }

  public boolean isEmpty(){
    return pq.isEmpty();
  }

  public String toString(){
    String toReturn = "";
    for (Object item : pq.toArray()) {
      toReturn += item + " ";
    }

    return toReturn;
  }

}
