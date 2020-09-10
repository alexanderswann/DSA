public class DoublyLinkedListTester{
	public static void main(String[] args){

		DoublyLinkedList list = new DoublyLinkedList();

//first batch of tests

		// list.add2End("6");
		// list.add2End("7");
		// list.add2Front("2");
		// list.add2Front("1");
		// list.add2Index(0,"0");
		// list.add2Index(8,"try this");
		// list.add2Index(7,"8");
		// list.add2End("9");
		// list.add2End("10");
		// list.add2Index(9,"8.5");
		// list.add2Index(9,"8.25");
		// list.add2Index(10,"8.35");
		// list.add2Index(7,"6.35");
		//
		// list.add2Index(9,"7.35");
		// list.add2End("11");
		// list.add2Index(0,"-1");
		// list.add2Index(18,"12");
		// list.add2Index(17,"12");
		// list.add2End("13");
		// list.add2Front("-1");
		// list.add2Front("-2");
		// list.add2End("14");
		// list.add2End("15");
	 //
		// list.add2Front("3");
	 // list.add2Front("2");
		// list.add2Front("1");
		// list.add2End("4");
		// list.add2End("5");
		// list.add2Index(1,"a");
		// list.add2Index(1,"b");
		// list.add2Index(0,"c");
		// list.add2Index(0,"5");
	 //
		// list.add2Index(0,"4");
		// list.add2Index(0,"3");
		// list.add2End("6");
		// list.add2End("7");
		// list.add2Front("2");
		// list.add2Front("1");
		// list.add2Index(0,"0");
	 //
		// list.add2Index(8,"try this");
		// list.add2Index(7,"8");
		// list.add2End("9");
		// list.add2End("10");
		// list.add2Index(9,"8.5");
		// list.add2Index(9,"8.25");
		// list.add2Index(10,"8.35");
		// list.add2Index(7,"6.35");
	 //
		// list.add2Index(9,"7.35");
		// list.add2End("11");
		// list.add2Index(0,"-1");
		// list.add2Index(18,"12");
		// list.add2Index(17,"12");
		// list.add2End("13");
		// list.add2Front("-1");
		// list.add2Front("-2");
		// list.add2End("14");
		// list.add2End("15");
		// list.add2End("0");
		// list.add2End("1");
		// list.add2End("2");
		// list.add2End("3");
		// list.add2End("4");
		// list.add2End("5");

	//	System.out.println(list);

		//System.out.println(list.remove(2));
		// System.out.println(list.add2Index(1,"a"));
		// System.out.println(list.add2Index(2,"b"));
		// System.out.println(list.add2Index(3,"c"));
		// System.out.println(list.add2Index(4,"d"));
		// System.out.println(list.add2Index(5,"e"));
		// list.add2Index(1,"b");
		// list.add2Index(1,"c");
		// list.add2Index(0,"5");
		// list.add2Index(0,"4");
		// list.add2Index(0,"3");
		// list.add2Front("3");
		// list.add2Front("2");
		// list.add2Front("1");
		list.add2End("4");
		list.add2End("5");
		list.add2Index(0,"5");
		//list.add2End("4.5");
		// list.add2Front("4.25");
		// list.add2Index(0,"4");
		// list.add2Index(0,"0");
		// list.add2Index(1,"3");
		// list.add2Index(1,"2");
		// list.add2Index(1,"1");
		// list.add2End("6");
		// list.add2End("7");
		// list.add2Index(4,"3.5");
		// list.add2Index(6,"4.15");

		System.out.println(list);
		System.out.println("\n");
		System.out.println(list.reverseToString());
		System.out.println(list.rH());
		System.out.println(list.rT());



//second batch of tests
		// list.add2Front("1");
		// list.add2Front("2");
		// list.add2Front("3");
		// list.add2Front("4");
		// list.add2Index(2,"5");
		// list.add2Index(3,"0");
		//
		//
		// System.out.println(list);
		// System.out.println("\n");
		System.out.println("the middle is " + list.findMiddle());

		System.out.println("the size is " + list.size());
		// list.add2Front("-1");
System.out.println(list);
		System.out.println("the middle is " + list.findMiddle());

		System.out.println("the size is " + list.size());
		//
		//
		// System.out.println(list.remove(1));
		// System.out.println(list);
		// System.out.println("the size is " + list.size());
		//
		//
		// System.out.println(list.remove(6));
		//
		// System.out.println(list);
		// System.out.println("\n");
		// System.out.println(list.reverseToString());
		// list.add2Index(6,"4");
		// list.add2Index(6,"9s");
		// list.add2Index(6,"2");
		// list.add2Index(6,"1");
		// System.out.println(list);
		// System.out.println("\n");
		// System.out.println(list.reverseToString());
		// System.out.println(list);
		// System.out.println("the size is " + list.size());
		//
		// System.out.println(list.remove(3));
		// System.out.println(list);
		// System.out.println("the size is " + list.size());
		//s
		// System.out.println("\n");
		//
		// list.add2End("13");
		// list.add2Front("-1");
		// list.add2Front("-2");
		// list.add2End("14");
		// list.add2End("15");
		//
		// System.out.println("the size is " + list.size());
		//
		// System.out.println(list);
		// System.out.println(list.reverseToString());
		//
		// System.out.println("the middle is " + list.findMiddle());
		// list.add2Index(4, "15");
		// System.out.println(list);
		// System.out.println("the middle is " + list.findMiddle());
		//
		// list.add2Front("-0");
		// list.add2End("16");
		System.out.println("\n");System.out.println("\n");

		System.out.println(list);
		list.bounce();
		list.bounce();
		list.bounce();
		list.bounce();
		list.bounce();
		list.bounce();
		list.bounce();
		// list.add2End("13");
		// list.add2Front("-1");
		// list.add2Front("-2");
		// list.add2End("14");
		// list.add2End("15");
		list.removeAll("5");
		System.out.println(list);
		// System.out.println(list.reverseToString());
		// System.out.println(list.rH());
		// System.out.println(list.rT());


	}
}
//cd Documents\GitHub\DSA\
// javac DoublyLinkedListTester.java
// javac DoublyLinkedList.java
// java DoublyLinkedListTester
