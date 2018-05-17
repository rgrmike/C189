package Main.src;
/**
 * Created by mian on 4/25/2018.
 */
public class treenode {
    /* MA This class will represent one node in the hash table */
    //MA declare string variables for name, phone, and email
    private String name;
    private String phone;
    private String email;
    //MA declare variable for the tree
    private treenode parent;
    private treenode leftNode;
    private treenode rightNode;
    private boolean isRightChild;

    //MA Constructors
    public treenode(String name, String phone, String email){
        this(name, phone, email, null, null);
    }
    //MA Create the tree nodes
    public treenode(String name, String phone, String email, treenode leftNode, treenode rightNode){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
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

    public  treenode getLeftNode(){
        return this.leftNode;
    }

    public treenode getRightNode(){
        return this.rightNode;
    }

    public treenode getparent(){
        return this.parent;
    }

    public boolean getisRightChild() {
        return isRightChild;
    }

    public void setLeftNode(treenode leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(treenode rightNode){
        this.rightNode = rightNode;
    }

    public void setParent(treenode parent){this.parent = parent; }

    public void setisRightChild (boolean isRightChild){this.isRightChild = isRightChild; }


}
