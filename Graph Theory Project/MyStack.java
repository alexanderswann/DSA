import java.util.*;
public class MyStack<E> implements DataStructure<E>{

	private Stack<E> stack;
	public MyStack(){
		stack = new Stack<E>();
	}

	public void add(E item){
		stack.push(item);
	}

	public E remove(){
		return stack.pop();
	}

	public boolean isEmpty(){
		return stack.empty();
	}

	public String toString(){
		String toReturn = "";
		for(int i = stack.size() -1; i >= 0 ; i--){
			toReturn += stack.get(i) + " ";
		}
		//I thought about just using the built in toString that we inherited from
		//Vector but I didnt like the way that it printed out

		return toReturn;

}
}
