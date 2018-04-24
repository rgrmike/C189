package C189;
/**
 * Created by mian on 4/22/2018.
 */
public class hashtable{
    /* MA This is the hashtable that holds add, find, and delete methods */
    C189.node[] hashTbl = new C189.node[13];
    //MA Inserts values into hash table
    public void add(String fName, String lName, String email, String phone) {
        String name = nameCat(fName, lName);
        int hashNum = Math.abs(name.toUpperCase().hashCode()%13);
        C189.node newNode = new C189.node(name, email, phone, hashTbl[hashNum]);
        hashTbl[hashNum] = newNode;
        System.out.println("hash Number = " + hashNum);
    }

    public void find(String fName, String lName){
        System.out.println("find = " + nameCat(fName, lName));
    }

    public void delete(String fName, String lName){
        System.out.println("Delete = " + nameCat(fName, lName));
    }

    public String nameCat(String fName, String lName){
        String tempName = fName + lName;
        tempName = tempName.toUpperCase();
        return tempName;
    }


}