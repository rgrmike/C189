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
            //print statement for debug to see when root is created
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
                    //debug statement to see when tree node is added right
                    //System.out.println("Added left node with radd for: " + newTreeNode.getName());
                }
                else{
                    //Call rAdd with parameters root.getLeftChild and key
                    //statement for debug of how many times recursive call was made
                    //System.out.println("called rAdd with left node: " + addRoot.getLeftNode());
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
                    //debug statement to see when tree node is added right
                    //System.out.println("Added right node with radd for: " + newTreeNode.getName() + " " + newTreeNode.getparent());
                }
                else{
                    //statement for debug of how many times recursive call was made
                    //System.out.println("called rAdd with right node: " + addRoot.getRightNode());
                    rAdd(addRoot.getRightNode(), newTreeNode);
                }
            }


    }

    public treenode find(String fName, String lName){
        //let everyone know what we are trying to find
        System.out.println("Find Tree Value: " + fName + " " + lName);
        //join the first and last name
        String name = nameCat(fName, lName);
        //return the treenode that we found - this is used for delete
        //call recursive find
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
                //System.out.println("calling rFind with get left node: " + rFindroot.getLeftNode());
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
                //System.out.println("calling rFind with get right node: " + rFindroot.getRightNode());
                rFind(rFindroot.getRightNode(), rname);
            }
        }
        //this is here to keep the IntelliJ IDE happy - it was showing a syntax error for no return
        //return null;
        return rFindroot;
    }

    public treenode delete(String fName, String lName){
        System.out.println("Delete Name from Tree: " + fName + " " + lName);
        treenode delNode = find(fName, lName);
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
                    delNode.getparent().setRightNode(null);
                }
                else {
                    //Set node’s parent’s left child to null
                    delNode.getparent().setLeftNode(null);
                }
        }
        //Check for case two (the node has a right child)
        else if(delNode.getRightNode() != null && delNode.getLeftNode() == null){
            //Set node’s parent’s right child to node’s right child
            delNode.getparent().setRightNode(delNode.getRightNode());
            //Set node’s right child’s parent to node’s parent
            delNode.getRightNode().setParent(delNode.getparent());
        }
        //Check for case three (the node has a left child)
        else if(delNode.getLeftNode() != null && delNode.getRightNode() == null){
            //Set node’s parent’s left child to node’s left child
            delNode.getparent().setLeftNode(delNode.getLeftNode());
            //Set node’s left child’s parent to node’s parent
            delNode.getLeftNode().setParent(delNode.getparent());
        }
        //check to see if the node has both left and right children
        else if((delNode.getRightNode() != null) && (delNode.getLeftNode() != null)){
            //	Call your utility method with the node’s right child as a parameter.
            // So you’ll have the smallest node in the node’s right subtree.
            // This node is guaranteed to be greater than any node in the node’s left subtree.
            //	Replace the data of the node you want to delete with the data of the node you found in the subtree
            //	Delete the node you found in the subtree (using the algorithm in case 1)

            delNode = util(delNode.getRightNode());

            if(delNode.getisRightChild() == true){
                //			Set node’s parent’s right child to null
                delNode.getparent().setRightNode(null);
            }
            else {
                //Set node’s parent’s left child to null
                delNode.getparent().setLeftNode(null);
            }


        }
        //this is here to keep the IDE happy - should never hit this
        return null;
    }

    public treenode util (treenode utilTreenode){
        //Create a little utility method that takes a TreeNode and returns the leftmost child
        //It will simply be a while loop that goes down the left child repeatedly until the left child is null.
        //It returns that last left child.
        //This node has the characteristic of being the smallest node of the tree searched
        //create a variable to exit the loop
        boolean exitLoop = false;
        //create a variable to return
        treenode retTreenode = utilTreenode;
        //while the value has a left child repeat
        while(exitLoop == false){
            //update the return variable
            retTreenode = utilTreenode;
            //iterate to the next child
            utilTreenode = utilTreenode.getLeftNode();
            //check to see if the child is null - if it is set the exit to true
            if(utilTreenode.getLeftNode() == null){
                 exitLoop = true;
             }

        }
        //return the last node
        return retTreenode;
    }

    public String nameCat(String fName, String lName){
        //nameCat simply combines first and last name into a single string value
        return fName + lName;}
}
