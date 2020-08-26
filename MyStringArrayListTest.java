public class MyStringArrayListTest {
public static void main(String[] args){
	MyStringArrayList list = new MyStringArrayList();
   list.add("10");
   list.add("13");
   list.add("14");
   list.add("11");
   list.add(9, "11");
   list.remove(2);
   System.out.println(list.toString());
   list.set(2, "10");
   System.out.println(list.toString());
   list.removeAll(null);
   //list.removeAll(12);
   list.removeAll("10");
   System.out.println(list.toString());
//    String ja = "Hellp";
//    System.out.println(ja.getClass(). getName());
}
}