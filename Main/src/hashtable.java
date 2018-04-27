package Main.src;
/**
 * Created by mian on 4/22/2018.
 */
public class hashtable{
    /* MA This is the hashtable that holds add, find, and delete methods */
    node[] hashTbl = new node[13];
    //MA Inserts values into hash table
    public void add(String fName, String lName, String email, String phone) {
        //call nameCat to concatenate the first and last name into the name variable
        String name = nameCat(fName, lName);
        //create the hashNum variable and create the hash using the equation listed in the task detail
        int hashNum = Math.abs(name.toUpperCase().hashCode()%13);
        //assign values to the node class
        node newNode = new node(name, email, phone, hashTbl[hashNum]);
        hashTbl[hashNum] = newNode;
        //print status so we can keep track
        System.out.println("Added hash Number = " + hashNum);
    }
    //find scans the nodes in the hash table for the requested values
    public void find(String fName, String lName){
        //print the names we are looking up so we can keep track of progress
        String name = nameCat(fName, lName);
        System.out.println("Trying to find = " + name);
        int hashNum = Math.abs(name.toUpperCase().hashCode()%13);
        node counter = hashTbl[hashNum];
        //check for a null value so we dont throw an exception on the last node
        //check all the nodes for the hash
        while (counter != null){
            //make sure there is a value to return
            if (counter.getName().equals(name)){
                String rtnEmail = hashTbl[hashNum].getEmail();
                String rtnPhone = hashTbl[hashNum].getPhone();
                //print to the screen that we actually found the value we were looking for
                //the cohort said to set this to void so we don't return anything - this just shows that we found what we wanted
                System.out.println("Found: " + name + " " + rtnEmail + " " + rtnPhone);
            }
            counter = counter.getNextNode();
        }
    }
    //delete the node based on first and last name parameters
    public void delete(String fName, String lName) {
        String name = nameCat(fName, lName);
        //print the name we are going to delete so we can track progress
        System.out.println("Delete = " + name);
        //calculate the hash
        int hashNum = Math.abs(name.toUpperCase().hashCode() % 13);
        //set the counter to the hash number
        node counter = hashTbl[hashNum];
        //check to see if we find the value in the first node
        if (counter.getName().equals(name)) {
            hashTbl[hashNum] = hashTbl[hashNum].getNextNode();
        }
        //make sure we don't throw a null pointer exception
        else while (counter != null) {
            //find the value of the previous node so we can delete menode
            node prevNode = hashTbl[hashNum];
            //set present node to one after the first node
            node meNode = prevNode.getNextNode();
            //check the node to make sure it matches our name
            if (counter.getName().equals(name)) {
                //set variables to allow the node deletion
                meNode = meNode.getNextNode();
                prevNode = meNode;

            }
            //putting in this null check to resolve nullpointerexception on JohnDoe
            if (meNode != null){
                //only run setNextNode if there is not a null value - otherwise we are at the end of the chain
                prevNode.setNextNode(meNode.getNextNode());
            }
            //if we don't find the name we were looking for - from a previous deletion - we don't do anything
            else System.out.println("Name Not found");
            counter = counter.getNextNode();
        }
    }
    //nameCat concatenates the first and last name
    public String nameCat(String fName, String lName){
        String tempName = fName + lName;
        return tempName;
    }


}