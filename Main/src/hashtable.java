package Main.src;
/**
 *MA  Created by mian on 4/22/2018.
 */
public class hashtable{
    /* MA This is the hashtable that holds add, find, and delete methods */
    node[] hashTbl = new node[13];
    //MA Inserts values into hash table
    public void add(String fName, String lName, String email, String phone) {
        //MA call nameCat to concatenate the first and last name into the name variable
        String name = nameCat(fName, lName);
        //MA create the hashNum variable and create the hash using the equation listed in the task detail
        int hashNum = Math.abs(name.toUpperCase().hashCode()%13);
        //MA assign values to the node class
        node newNode = new node(name, email, phone, hashTbl[hashNum]);
        hashTbl[hashNum] = newNode;
        //MA print status so we can keep track
        System.out.println("Added hash Number = " + hashNum);
    }
    //MA find scans the nodes in the hash table for the requested values
    public void find(String fName, String lName){
        //MA print the names we are looking up so we can keep track of progress
        String name = nameCat(fName, lName);
        System.out.println("Trying to find = " + name);
        int hashNum = Math.abs(name.toUpperCase().hashCode()%13);
        node counter = hashTbl[hashNum];
        String foundEmail = null;
        String foundPhone = null;
        boolean foundIt = false;
        //MA check for a null value so we don't throw an exception on the last node
        //MA check all the nodes for the hash
        while (counter != null){
            //MA make sure there is a value to return
            if (counter.getName().equals(name)){
                foundEmail = counter.getEmail();
                foundPhone = counter.getPhone();
                foundIt = true;
            }
            counter = counter.getNextNode();
        }
        if(foundIt == false){
            System.out.println(fName + " " + lName + " Can't Be found.");
        }
        else if(foundIt == true){
            //MA print to the screen that we actually found the value we were looking for
            System.out.println("Found: " + name + " " + foundEmail + " " + foundPhone);
        }
    }
    //MA delete the node based on first and last name parameters
    public void delete(String fName, String lName) {
        String name = nameCat(fName, lName);
        //MA print the name we are going to delete so we can track progress
        System.out.println("Delete = " + name);
        //MA calculate the hash
        int hashNum = Math.abs(name.toUpperCase().hashCode() % 13);
        //MA set the counter to the hash number
        node counter = hashTbl[hashNum];
        //MA check to see if we find the value in the first node
        if (counter.getName().equals(name)) {
            hashTbl[hashNum] = hashTbl[hashNum].getNextNode();
        }
        //MA make sure we don't throw a null pointer exception
        else while (counter != null) {
            //MA find the value of the previous node so we can delete menode
            node prevNode = hashTbl[hashNum];
            //MA set present node to one after the first node
            node meNode = prevNode.getNextNode();
            //MA check the node to make sure it matches our name
            if (counter.getName().equals(name)) {
                //MA set variables to allow the node deletion
                meNode = meNode.getNextNode();
                prevNode = meNode;
            }
            //MA putting in this null check to resolve nullpointerexception on JohnDoe
            if (meNode != null){
                //MA only run setNextNode if there is not a null value - otherwise we are at the end of the chain
                prevNode.setNextNode(meNode.getNextNode());
            }
            //MA if we don't find the name we were looking for - from a previous deletion - we don't do anything
            else System.out.println("Name: "  + fName + " " + lName + " Not found to delete");
            counter = counter.getNextNode();
        }
    }
    //MA nameCat concatenates the first and last name
    public String nameCat(String fName, String lName){
        String tempName = fName + lName;
        return tempName;
    }
}