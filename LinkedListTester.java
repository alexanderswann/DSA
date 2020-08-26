public class LinkedListTester{
	public static void main(String[] args){
		/*System.out.println(args[0]);
		System.out.println(args[1]);*/
		LinkedList list = new LinkedList();

		list.add("A");
		list.add("B");
		list.add("C");

		System.out.println(list);

		System.out.println(list.get(1));

		//Node test = new Node("A");
		list.add2Index(0, "Z");
		System.out.println(list);
	}
}