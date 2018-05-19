package Main.src;
/**
 * MA Created by mian on 4/22/2018.
 */
public class node{
    /* MA This class will represent one node in the hash table */
    //MA declare string variables for name, phone, and email
    private String name;
    private String phone;
    private String email;
    //MA declare variable for the node to allow circular reference
    private node nextNode;

    //MA Constructors
    public node(String name, String phone, String email){
        this(name, phone, email, null);
    }
    //MA Create the next nodes
    public node(String name, String phone, String email, node nextNode){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.nextNode = nextNode;
    }
    //MA Accessor and mutator methods
    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhone(){
        return this.phone;
    }

    public  node getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(node nextNode){
        this.nextNode = nextNode;
    }

}