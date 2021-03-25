import java.util.*;
public class MyQ<E> implements DataStructure<E>{

  private ArrayDeque<E> pq;
  public MyQ(){
    pq = new ArrayDeque<E>();
  }

  public void add(E item){
    pq.offer(item);


  }

  public E remove(){
    return pq.removeFirst();
  }

  public boolean isEmpty(){
    return pq.isEmpty();
  }

  public String toString(){
    String toReturn = "";
    // for(int i =  0; i > pq.size(); i++){
    //   toReturn += pq.get()
    // }
    for (E item : pq) {
      toReturn += item  + " ";
    }

    return toReturn;
  }

}
