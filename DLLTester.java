import java.util.ArrayList;
public class DLLTester{
	public static void main(String[] args){
		System.out.println("-----Testing size in constructors-----");
		DoublyLinkedList l1 = new DoublyLinkedList();
		System.out.printf("The size of this empty list should be 0. It's %d\n", l1.size());

		System.out.println("\n-----Testing add2End-----");
		l1.add2End("b");
		l1.add2End("d");
		l1.add2End("f");
		System.out.printf("This list should contain b, d, f. It's: %s\n", l1);
		System.out.printf("The size of this list should be 3. It's %d\n", l1.size());

		System.out.println("\n-----Testing add2Front-----");
		l1 = new DoublyLinkedList();
		l1.add2Front("a");
		l1.add2Front("b");
		l1.add2Front("c");
		System.out.println("This list should contain c, b, a. It's: " + l1);
		System.out.printf("The size of this list should be 3. It's %d\n", l1.size());

		System.out.println("\n-----Testing add2Index-----");
		l1 = new DoublyLinkedList();
		l1.add2Index(0, "b");
		l1.add2Index(0, "a");
		l1.add2Index(2, "d");
		l1.add2Index(2, "c");
		System.out.println("This list should contain a, b, c, d. It's: " + l1);
		l1.add2Index(-1, "a");
		System.out.println("Added at -1, nothing should happen to list: " + l1);
		l1.add2Index(15, "b");
		System.out.println("Added out of bounds, nothing should happen to list: " + l1);
		System.out.printf("The size of this list should be 4. It's %d\n", l1.size());

		System.out.println("\n-----Testing addInOrder-----");
		l1 = new DoublyLinkedList();
	  l1.addInOrder("c");
		l1.addInOrder("a");
		l1.addInOrder("g");
		l1.addInOrder("e");
		l1.addInOrder("d");
		l1.addInOrder("f");
		System.out.println("This list should contain a, c, d, e, f, g. It's: " + l1);
		System.out.printf("The size of this list should be 6. It's %d\n", l1.size());

		System.out.println("\n-----Testing indexOf-----");
		System.out.println("a should live at index 0. It lives at : " + l1.indexOf("a"));
		System.out.println("g should live at index 5. It lives at : " + l1.indexOf("g"));
		System.out.println("f should live at index 4. It lives at : " + l1.indexOf("f"));
		System.out.println("b isn't in our list, so this should print -1. It's: " + l1.indexOf("b"));
		System.out.println("A isn't in our list, so this should print -1. It's: " + l1.indexOf("A"));
		System.out.println("h isn't in our list, so this should print -1. It's: " + l1.indexOf("h"));
		System.out.printf("The size of this list should be 6. It's %d\n", l1.size());

		System.out.println("\n-----Testing remove-----");
		Object thing = l1.remove(8);
		System.out.println("Attempted to remove OOB (8). Should return null. It returned: " + thing);
		l1.remove(0);
		System.out.println("After we remove a, the list should have c, d, e, f, g. It's: " + l1);
		l1.remove(3);
		System.out.println("After we remove f, the list should have c, d, e, g. It's: " + l1);
		l1.remove(2);
		System.out.println("After we remove e, the list should have c, d, g. It's: " + l1);
		l1.remove(1);
		System.out.println("After we remove d, the list should have c, g. It's: " + l1);
		l1.remove(1);
		System.out.println("After we remove g, the list should have c. It's: " + l1);
		l1.remove(0);
		System.out.println("After we remove c, the list should have nothing. It's: " + l1);
		System.out.printf("The size of this list should be 0. It's %d\n", l1.size());

		System.out.println("\n-----Testing removeAll-----");
		l1 = new DoublyLinkedList();
		l1.add2End("a");
		l1.add2End("c");
		l1.add2End("d");
		l1.add2End("c");
		l1.add2End("a");
		l1.add2End("c");
		System.out.println("List contains: " + l1);
		ArrayList<Integer> res = l1.removeAll("h");
		System.out.println("Attempted to remove h which DNE. Should return empty arrayList. It returned: " + res);
		res = l1.removeAll("d");
		System.out.println("After we remove all d's, the list should have a, c, c, a, c. It's: " + l1);
		System.out.println("The d lived at spot 2; method returned: " + res);
		System.out.printf("The size of this list should be 5. It's %d\n", l1.size());
		l1 = new DoublyLinkedList();
		l1.add2End("a");
		l1.add2End("c");
		l1.add2End("d");
		l1.add2End("c");
		l1.add2End("a");
		l1.add2End("c");
		System.out.println("Reset list; contains: " + l1);
		res = l1.removeAll("c");
		System.out.println("After we remove all c's, the list should have a, d, a. It's: " + l1);
		System.out.println("The c's lived at spots 1, 3, 5; method returned: " + res);
		System.out.printf("The size of this list should be 3. It's %d\n", l1.size());
		l1 = new DoublyLinkedList();
		l1.add2End("a");
		l1.add2End("c");
		l1.add2End("d");
		l1.add2End("c");
		l1.add2End("a");
		l1.add2End("c");
		System.out.println("Reset list; contains: " + l1);
		res = l1.removeAll("a");
		System.out.println("After we remove all a's, the list should have c, d, c, c. It's: " + l1);
		System.out.println("The a's lived at spots 0, 4; method returned: " + res);
		System.out.printf("The size of this list should be 4. It's %d\n", l1.size());

		System.out.println("\n-----Testing reverseToString-----");
		l1 = new DoublyLinkedList();
		l1.add2End("a");
		l1.add2End("b");
		l1.add2End("c");
		l1.add2End("d");
		l1.add2End("e");
		System.out.println("The list contains a, b, c, d, e. So this should print e, d, c, b, a. It's: " + l1.reverseToString());

		System.out.println("\n-----Testing findMiddle-----");
		System.out.println("The list contains a, b, c, d, e. So the middle should be c. It's: " + l1.findMiddle());
		l1.remove(4);
		System.out.println("The list contains a, b, c, d. So the middle should be b. It's: " + l1.findMiddle());

		l1 = new DoublyLinkedList();
		l1.add2End("b");
		l1.add2End("c");
		l1.add2End("a");
		l1.add2End("d");
		System.out.println("The list contains b, c, a, d. So the middle should be a. It's: " + l1.findMiddle());
		l1.add2End("e");
		System.out.println("The list contains b, c, a, d, e. So the middle should be a. It's: " + l1.findMiddle());

		System.out.println("\n-----Testing bounce-----");
		System.out.println("Before Bounce: " + l1);
		l1.bounce();
		System.out.println("After bounce should be e, b, c, a, d. It's: " + l1);
		l1.bounce();
		System.out.println("After bounce should be d, e, b, c, a. It's: " + l1);
		System.out.printf("The size of this list should be 5. It's %d\n", l1.size());
	}
}
