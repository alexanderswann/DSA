import java.util.*;
import java.io.*;
public class HashTest {
    public static void main(String[] args) {

        HashTableLinearProbing table = new HashTableLinearProbing(.5);

        HashTableExternalChaining table2 = new HashTableExternalChaining(.5);

        String key2 = "yeahd";
        String key = "10";
        String value = "hi";
        String value2 = "7324";
        System.out.println(Math.abs(key.hashCode() % 10));


        table2.insert(key, value);
        table2.insert(key2, value2);
        // System.out.println(table2.toString());
        table2.insert(key, value2 + "kdf");
        // System.out.println(table2.toString());
        table2.insert(key2, value2 + "kde");


        System.out.println(table2.find(key, value2));
        System.out.println(table2.find(key2, value2 + "kde"));

        System.out.println(table2.containsValue(value2 + "kd"));
        System.out.println(table2.containsKey(key2));

        System.out.println(table2.toString());

        System.out.println(table2.remove(key2, value2));
        System.out.println(table2.toString());
        System.out.println(table2.remove(key, value));
        System.out.println(table2.toString());

                table2.remove(key, value);
                table2.remove(key2, value2);
                System.out.println(table2.toString());
                table2.remove(key, value2 + "kdf");
                System.out.println(table2.toString());
                table2.remove(key2, value2 + "kde");

          System.out.println(table2.toString());

      table2.insert(key, value);
      table2.insert(key, value2);
      System.out.println(table2.toString());
      table2.insert(key2, value2 );
      System.out.println(table2.toString());
      table2.insert(key2, value2 + "kde");
      table2.insert(key2, value2 + "kde");



      System.out.println(table2.toString());


            table2.insert(key+"kdf", value);
            table2.insert(key+"kddf", value2);
            table2.insert(key+"kd vsadf", value2+"kdf");
            table2.insert(key+"kdasvdf", value2+"kdfd");
            table2.insert(key+"kdasqdf", value2+"kdfds");
            table2.insert(key+"kdsaawef", value2+"kdfdsd");
            System.out.println(table.toString());
        //
        System.out.println(table2.toString());
            System.out.println(table2.find(key2, value2));
            System.out.println(table2.containsPair(key2, value2));
            table2.remove(key2, value2 + "kde");
            System.out.println(table2.toString());
            System.out.println(table.containsValue("23490kdfdsd"));


            System.out.println(table.remove(key , "hi"));
        System.out.println(table2.insert(null , null));
        //

            table.insert(key, value2+"23423");
            table.insert("hello", value2+"kdfdsd");

            System.out.println(table.toString());

            
        System.out.println(Math.abs(key.hashCode() % 10));

    }
}
