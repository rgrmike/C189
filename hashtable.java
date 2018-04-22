package C189;
/**
 * Created by mian on 4/22/2018.
 */
public class hashTable {
    /* MA This is the hashtable that holds add, find, and delete methods */
    Node[] hashTbl = new Node[13];
    //MA Inserts values into hash table
    public void add(String name, String email, String phone) {
        int hashNum = Math.abs(name.toUpperCase().hashCode()%13);
        System.out.println("hash Number = "hashNum);
    }

    public void find(String name){
        System.out.println("find = "this.name);
    }

    public void delete(String name){
        System.out.println("Delete = "this.name);
    }


}