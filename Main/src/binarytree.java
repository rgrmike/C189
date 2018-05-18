package Main.src;
/**
 * Created by mian on 4/25/2018.
 */
public class binarytree {
    treenode root;

    public void add(String fName, String lName, String email, String phone){
        System.out.println("Adding data to tree: " + fName + " " + lName );
        //call nameCat to concatenate the first and last name into the name variable
        String name = nameCat(fName, lName);
        treenode newTreeNode = new treenode(name, phone, email);
        //if the root is empty put the value there
        if(root == null){
            root = newTreeNode;
            System.out.println("Adding data to root" + "Root name = " + root.getName());
        }
        else {
            rAdd(root, newTreeNode);
        }
    }

    public void rAdd(treenode addRoot, treenode newTreeNode){
            /* compare the newTreeNode name value to the root value.
            If key is greater than root it will be positive - if it is less then it will be negative */
            if(newTreeNode.getName().compareTo(addRoot.getName()) < 0){
                if(addRoot.getLeftNode() == null){
                    //Set root left child to the new node
                    addRoot.setLeftNode(newTreeNode);
                    //Set new node's parent to root
                    newTreeNode.setParent(addRoot);
                    //set isRightChild to false
                    newTreeNode.setisRightChild(false);
                    System.out.println("Added left node with radd for: " + newTreeNode.getName());
                }
                else{
                    //Call rAdd with parameters root.getLeftChild and key
                    System.out.println("called rAdd with left node: " + addRoot.getLeftNode());
                    rAdd(addRoot.getLeftNode(), newTreeNode);
                }
            }
            else{
                if(addRoot.getRightNode() == null) {
                    //Set root’s right child to the new node
                    addRoot.setRightNode(newTreeNode);
                    //Set new node’s parent to root
                    newTreeNode.setParent(addRoot);
                    //Set isRightChild to true
                    newTreeNode.setisRightChild(true);
                    System.out.println("Added right node with radd for: " + newTreeNode.getName() + " " + newTreeNode.getparent());
                }
                else{
                    System.out.println("called rAdd with right node: " + addRoot.getRightNode());
                    rAdd(addRoot.getRightNode(), newTreeNode);
                }
            }


    }

    public treenode find(String fName, String lName){
        System.out.println("Find Tree Value: " + fName + " " + lName);
        String name = nameCat(fName, lName);
        return rFind(root, name);
    }

    public treenode rFind(treenode rFindroot, String rname){
        String compareRootName = rFindroot.getName();
        //If key ==  root’s name
        if(rname.compareTo(compareRootName) == 0){
            //Report found
            System.out.println("Name: " + rname + " found");
            //Return key
            return rFindroot;
        }
        //Else if key < root’s name
        else if(rname.compareTo(compareRootName) < 0){
            //If root’s left child is null
            if(rFindroot.getLeftNode() == null){
                //Report not found
                System.out.println("Name: " + rname + " not found as left node");
                //Return null
                return null;
            }
            //Else
            else {
                //Call rFind with root’s left child and name
                //Print statement to aid in debug - lets us know how the tree is being searched
                System.out.println("calling rFind with get left node: " + rFindroot.getLeftNode());
                rFind(rFindroot.getLeftNode(), rname);
            }
        }
        else {
            //If root’s right child is null
            if(rFindroot.getRightNode() == null) {
                //Report not found
                System.out.println("Name: " + rname + " not found as right node");
                //Return null
                return null;
            }
            else {
                //Call rFind with root’s left child and name
                //Print statement to aid in debug - lets us know how the tree is being searched
                System.out.println("calling rFind with get right node: " + rFindroot.getRightNode());
                rFind(rFindroot.getRightNode(), rname);
            }
        }
        //this is here to keep the IntelliJ IDE happy - it was showing a syntax error for no return
        return null;
    }

    public treenode delete(String fName, String lName){
        System.out.println("Delete Name from Tree: " + fName + " " + lName);
        treenode delNode = find(fName, lName);
        treenode parentNode = delNode.getparent();
        if(delNode == null){
            //nothing found to delete returning null
            System.out.println("Name not found - nothing to delete.");
            return null;
        }
        else if(delNode.getLeftNode() == null && delNode.getRightNode() == null){
            //The node has no children
            //		If isRightChild is true
                if(delNode.getisRightChild() == true){
                    //			Set node’s parent’s right child to null
                    parentNode.setRightNode(null);
                }
                else {
                    //Set node’s parent’s left child to null
                    parentNode.setLeftNode(null);
                }
        }
        //Check for case two (the node has a right child)
        else if(delNode.getRightNode() != null && delNode.getLeftNode() == null){
            //Set node’s parent’s right child to node’s right child
            parentNode.setRightNode(delNode.getRightNode());
            //Set node’s right child’s parent to node’s parent
            delNode.getRightNode().setParent(parentNode);
        }
        //Check for case three (the node has a left child)
        else if(delNode.getLeftNode() != null && delNode.getRightNode() == null){
            //Set node’s parent’s left child to node’s left child
            parentNode.setLeftNode(delNode.getLeftNode());
            //Set node’s left child’s parent to node’s parent

        }
    }


    public String nameCat(String fName, String lName){
        //nameCat simply combines first and last name into a single string value
        return fName + lName;}
}
