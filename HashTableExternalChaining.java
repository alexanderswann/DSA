import java.util.*;
import java.io.*;

public class HashTableExternalChaining {

    private pair[] hashMap;
    private double totalE; //total number of elements
    private double threshold;
    private int MaxchainLength = 0;

    public HashTableExternalChaining(double threshold) {
        hashMap = new pair[10];
        this.threshold = threshold;
    }


    //  cd Documents\GitHub\DSA

    public void resize() {
        pair[] newMap = new pair[hashMap.length * 2];

        int i = 0;

        while (i <= hashMap.length - 1) {


            if (hashMap[i] != null && hashMap[i].key != null && hashMap[i].value != null && hashMap[i].next == null) {

                int j = Math.abs(hashMap[i].key.hashCode() % newMap.length);


                if ((newMap[j] != null && newMap[j].value == null && newMap[j].key == null) || newMap[j] == null) {
                    newMap[j] = new pair(hashMap[i].key, hashMap[i].value);

                } else {
                    Node curr;
                    if (newMap[j].next == null) {
                        newMap[j].next = new Node(new pair(hashMap[i].key, hashMap[i].value));

                    } else {
                        curr = newMap[j].next;

                        while (curr.next != null) {
                            curr = curr.next;
                        }
                        curr.next = new Node(new pair(hashMap[i].key, hashMap[i].value));
                    }





                }



            } else if (hashMap[i] != null && hashMap[i].value == null && hashMap[i].key == null) {


            } else if (hashMap[i] != null && hashMap[i].value != null && hashMap[i].key != null && hashMap[i].next != null) {


                newMap = reHash(hashMap[i].key, hashMap[i].value, newMap);



                //System.out.println()
                Node curr = hashMap[i].next;
                while (curr != null) {
                    newMap = reHash(curr.p.key, curr.p.value, newMap);
                    curr = curr.next;
                }



            }


            i++;
        }



        hashMap = newMap;
        return;

    }




    public pair[] reHash(String key, String value, pair[] map) {
        int j = Math.abs(key.hashCode() % map.length);


        if ((map[j] != null && map[j].value == null && map[j].key == null) || map[j] == null) {
            map[j] = new pair(key, value);
        } else {
            Node curr;
            if (map[j].next == null) {
                map[j].next = new Node(new pair(key, value));
            } else {
                curr = map[j].next;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = new Node(new pair(key, value));
            }


        }
        return map;
    }


    public boolean insert(String key, String value) {

        if (key == null && value == null) {
            return false;
        }

        if ((((totalE + 1) / hashMap.length) >= threshold) || (MaxchainLength >= 5)) {
            resize();
        }



        int i = Math.abs(key.hashCode() % hashMap.length);
        int chain = 1;

        if ((hashMap[i] != null && hashMap[i].value == null && hashMap[i].key == null) || hashMap[i] == null) {
            hashMap[i] = new pair(key, value);
            totalE++;
            return true;
        } else {
            Node curr;
            if (hashMap[i].next == null) {
                hashMap[i].next = new Node(new pair(key, value));
                totalE++;
                return true;
            } else {
                curr = hashMap[i].next;
                chain++;
            }

            while (curr.next != null) {
                curr = curr.next;
                chain++;
            }
            chain++;
            curr.next = new Node(new pair(key, value));
            if (MaxchainLength < chain) {
                MaxchainLength = chain;
            }
            totalE++;
            return true;
        }




    }




    public boolean containsPair(String key, String value) {
        return find(key, value) >= 0;
    }


    public boolean containsKey(String key) {
        if (key == null) {
            return false;
        }
        int i = Math.abs(key.hashCode() % hashMap.length);

        if (hashMap[i] == null || (hashMap[i].value == null && hashMap[i].key == null)) {

            return false;
        } else if ((hashMap[i].key != null && hashMap[i].key.equals(key))) {
            return true; // 0
        } else if (hashMap[i].next != null) {
            Node curr = hashMap[i].next;
            while (curr != null) {
                if ((curr.p.key != null && curr.p.key.equals(key))) {
                    return true;
                }
                curr = curr.next;
            }
        } else {
            return false;

        }


        return false;
    }




    public boolean containsValue(String value) {
        int i = 0;

        while (i <= hashMap.length - 1) {
            if (hashMap[i] != null && hashMap[i].key != null && hashMap[i].value != null && hashMap[i].next == null) {
                if (hashMap[i] != null && hashMap[i].value != null && hashMap[i].value.equals(value)) {
                    return true;
                }
            } else if (hashMap[i] != null && hashMap[i].value == null && hashMap[i].key == null) {
                if (hashMap[i] != null && hashMap[i].value != null && hashMap[i].value.equals(value)) {
                    return true;
                }
            } else if (hashMap[i] != null && hashMap[i].value != null && hashMap[i].key != null && hashMap[i].next != null) {
                if (hashMap[i] != null && hashMap[i].value != null && hashMap[i].value.equals(value)) {
                    return true;
                }
                Node curr = hashMap[i].next;
                while (curr != null) {
                    if (curr.p != null && curr.p.value != null && curr.p.value.equals(value)) {
                        return true;
                    }
                    curr = curr.next;
                }

            }

            i++;

        }
        return false;

    }




    public int find(String key, String value) { //returns the index where the pair exists
        if (key == null || value == null) {
            return -1;
        }
        int i = Math.abs(key.hashCode() % hashMap.length);

        if (hashMap[i] == null || (hashMap[i].value == null && hashMap[i].key == null)) {
            return -1;
        } else if ((hashMap[i].key != null && hashMap[i].key.equals(key)) && (hashMap[i].value != null && hashMap[i].value.equals(value))) {
            return i; // 0
        } else if (hashMap[i].next != null) {
            Node curr = hashMap[i].next;
            while (curr != null) {
                if ((curr.p.key != null && curr.p.key.equals(key)) && (curr.p.value != null && curr.p.value.equals(value))) {
                    return i;
                }
                curr = curr.next;
            }
        } else {
            return -1;

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

        if (hashMap[i] != null && hashMap[i].key != null && hashMap[i].value != null && hashMap[i].next == null) {
            hashMap[i] = new pair(null, null);
        } else if (hashMap[i] != null && hashMap[i].key != null && hashMap[i].value != null && hashMap[i].next != null && hashMap[i].value.equals(value) && hashMap[i].key.equals(key)) {
            hashMap[i].value = hashMap[i].next.p.value;
            hashMap[i].key = hashMap[i].next.p.key;
            if (hashMap[i].next.next == null) {
                hashMap[i].next = null;
                return true;
            } else {
                hashMap[i].next = hashMap[i].next.next;
                return true;
            }
        } else if (hashMap[i].next != null && hashMap[i].next.p.value.equals(value) && hashMap[i].next.p.key.equals(key)) {
            if (hashMap[i].next.next == null) {
                hashMap[i].next = null;
                return true;
            } else {
                hashMap[i].next = hashMap[i].next.next;
                return true;
            }
        } else {
            Node curr = hashMap[i].next;
            while (curr.next != null) {
                if (curr.next.p.key != null && curr.next.p.value != null && curr.next.p.value.equals(value) && curr.next.p.key.equals(key)) {
                    if (curr.next.next == null) {
                        curr.next = null;
                        return true;
                    } else {
                        curr.next = curr.next.next;
                        return true;
                    }

                } else {
                    curr = curr.next;
                }

            }
        }


        return false;

    }

    public String toString() {
        int i = 0;
        String toReturn = "key | value\n";

        while (i <= hashMap.length - 1) {
            if (hashMap[i] != null && hashMap[i].key != null && hashMap[i].value != null && hashMap[i].next == null) {
                toReturn = toReturn + hashMap[i].key + " " + hashMap[i].value + "\n";
            } else if (hashMap[i] != null && hashMap[i].value == null && hashMap[i].key == null) {
                toReturn = toReturn + "null null\n";
            } else if (hashMap[i] != null && hashMap[i].value != null && hashMap[i].key != null && hashMap[i].next != null) {
                toReturn = toReturn + hashMap[i].key + " " + hashMap[i].value + " | ";
                Node curr = hashMap[i].next;
                while (curr != null) {
                    toReturn = toReturn + curr.p.key + " " + curr.p.value + " | ";
                    curr = curr.next;
                }
                toReturn = toReturn + "\n";

            } else {
                toReturn = toReturn + "empty" + " " + "empty" + "\n";
            }

            i++;

        }

        return toReturn;

    }

}

class pair {
    Node next;
    String key;
    String value;



    public pair(String key, String value) {
        this.key = key;
        this.value = value;
    }

}



class Node {
    Node next;
    pair p;

    public Node(pair p) {
        this.p = p;
    }

}
