import java.util.*;
import java.io.*;

public class HashTableLinearProbing {

    private pair[] hashMap;
    private double totalE; //total number of elements
    private double threshold;

    public HashTableLinearProbing(double threshold) {
        hashMap = new pair[10];
        this.threshold = threshold;
    }


    //cd Documents\GitHub\DSA
    public void resize() {
        pair[] newMap = new pair[hashMap.length * 2];
        for (int j = 0; j < hashMap.length - 1; j++) {
            if (hashMap[j] != null && hashMap[j].key != null && hashMap[j].value != null) {

                int i = Math.abs(hashMap[j].key.hashCode() % newMap.length);

                while (newMap[i] != null && newMap[i].value != null && newMap[i].key != null) {

                    if (newMap.length - 1 == i) {
                        i = 0;
                    } else {
                        i++;
                    }

                }

                newMap[i] = new pair(hashMap[j].key, hashMap[j].value);


            }
        }
        hashMap = newMap;
        return;
    }



    public boolean insert(String key, String value) {

        if (key == null && value == null) {
            return false;
        }

        if (((totalE + 1) / hashMap.length) >= threshold) {
            resize();
        }



        int i = Math.abs(key.hashCode() % hashMap.length);

        while (hashMap[i] != null && hashMap[i].value != null && hashMap[i].key != null) {

            if (hashMap.length - 1 == i) {
                i = 0;
            } else {
                i++;
            }

        }

        hashMap[i] = new pair(key, value);
        totalE++;

        return true;
    }


    public boolean containsPair(String key, String value) {
        return find(key, value) >= 0;
    }


    public boolean containsKey(String key) {
        int i = Math.abs(key.hashCode() % hashMap.length);

        while (hashMap[i] == null || (hashMap[i].value == null && hashMap[i].key == null)) {
            if (hashMap[i] != null && hashMap[i].key != null && hashMap[i].key.equals(key)) {
                return true;
            }

            if (i == hashMap.length - 1) {
                i = 0;
            } else {
                i++;
            }

        }
        return false;
    }




    public boolean containsValue(String value) {
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] != null && hashMap[i].value != null && hashMap[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }



    public int find(String key, String value) { //returns the index where the pair exists
        if (key == null || value == null) {
            return -1;
        }
        int i = Math.abs(key.hashCode() % hashMap.length);

        while (hashMap[i] != null || (hashMap[i] != null && hashMap[i].value == null && hashMap[i].key == null)) {
            if (hashMap[i] != null && (hashMap[i].key != null && hashMap[i].key.equals(key)) && (hashMap[i].value != null && hashMap[i].value.equals(value))) {
                return i;

            }

            if (hashMap.length - 1 == i) {
                i = 0;
            } else {
                i++;
            }

        }


        return -1;
    }

    public boolean remove(String key, String value) {
        if (key == null || value == null) {
            return false;
        }
        int i = find(key, value);
        if (i <= 0) {
            return false;
        }
        hashMap[i] = new pair(null, null);
        return true;
    }

    public String toString() {
        int i = 0;
        String toReturn = "key | value\n";

        while (i <= hashMap.length - 1) {
            if (hashMap[i] != null && hashMap[i].key != null && hashMap[i].value != null) {
                toReturn = toReturn + hashMap[i].key + " " + hashMap[i].value + "\n";
            } else if (hashMap[i] != null && hashMap[i].value == null && hashMap[i].key == null) {
                toReturn = toReturn + "null null\n";
            } else {
                toReturn = toReturn + "empty" + " " + "empty" + "\n";
            }

            i++;

        }

        return toReturn;

    }

}

class pair {
    String key;
    String value;




    public pair(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
