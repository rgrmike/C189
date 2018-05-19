package Main.src;
/**
 * MA Created by mian on 4/25/2018.
 */
public class binarytree {
    treenode root;

    public void add(String fName, String lName, String email, String phone){
        System.out.println("Adding data to tree: " + fName + " " + lName );
        //MA call nameCat to concatenate the first and last name into the name variable
        String name = nameCat(fName, lName);
        treenode newTreeNode = new treenode(name, phone, email);
        //MA if the root is empty put the value there
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
            /*MA  compare the newTreeNode name value to the root value.
            If key is greater than root it will be positive - if it is less then it will be negative */
            if(newTreeNode.getName().compareTo(addRoot.getName()) < 0){
                if(addRoot.getLeftNode() == null){
                    //MA Set root left child to the new node
                    addRoot.setLeftNode(newTreeNode);
                    //MA Set new node's parent to root
                    newTreeNode.setParent(addRoot);
                    //MA set isRightChild to false
                    newTreeNode.setisRightChild(false);
                    //MA debug statement to see when tree node is added right
                    //MA System.out.println("Added left node with radd for: " + newTreeNode.getName());
                }
                else{
                    //MA Call rAdd with parameters root.getLeftChild and key
                    //MA statement for debug of how many times recursive call was made
                    //MA System.out.println("called rAdd with left node: " + addRoot.getLeftNode());
                    rAdd(addRoot.getLeftNode(), newTreeNode);
                }
            }
            else{
                if(addRoot.getRightNode() == null) {
                    //MA Set root’s right child to the new node
                    addRoot.setRightNode(newTreeNode);
                    //MA Set new node’s parent to root
                    newTreeNode.setParent(addRoot);
                    //MA Set isRightChild to true
                    newTreeNode.setisRightChild(true);
                    //MA debug statement to see when tree node is added right
                    //MA System.out.println("Added right node with radd for: " + newTreeNode.getName() + " " + newTreeNode.getparent());
                }
                else{
                    //MA statement for debug of how many times recursive call was made
                    //MA System.out.println("called rAdd with right node: " + addRoot.getRightNode());
                    rAdd(addRoot.getRightNode(), newTreeNode);
                }
            }


    }

    public treenode find(String fName, String lName){
        //MA let everyone know what we are trying to find
        System.out.println("Find Tree Value: " + fName + " " + lName);
        //MA join the first and last name
        String name = nameCat(fName, lName);
        //MA return the treenode that we found - this is used for delete
        //MA call recursive find
        return rFind(root, name);
    }

    public treenode rFind(treenode rFindroot, String rname){
        String compareRootName = rFindroot.getName();
        //MA If key ==  root’s name
        if(rname.compareTo(compareRootName) == 0){
            //MA Report found
            System.out.println("Name: " + rname + " found");
            //MA Return key
            return rFindroot;
        }
        //MA Else if key < root’s name
        else if(rname.compareTo(compareRootName) < 0){
            //MA If root’s left child is null
            if(rFindroot.getLeftNode() == null){
                //MA Report not found
                System.out.println("Name: " + rname + " not found as left node");
                //MA Return null
                return null;
            }
            else {
                //MA Call rFind with root’s left child and name
                //MA Print statement to aid in debug - lets us know how the tree is being searched
                //MA System.out.println("calling rFind with get left node: " + rFindroot.getLeftNode());
                rFind(rFindroot.getLeftNode(), rname);
            }
        }
        else {
            //MA If root’s right child is null
            if(rFindroot.getRightNode() == null) {
                //MA Report not found
                System.out.println("Name: " + rname + " not found as right node");
                //MA Return null
                return null;
            }
            else {
                //MA Call rFind with root’s left child and name
                //MA Print statement to aid in debug - lets us know how the tree is being searched
                //MA System.out.println("calling rFind with get right node: " + rFindroot.getRightNode());
                rFind(rFindroot.getRightNode(), rname);
            }
        }
        return rFindroot;
    }

    public treenode delete(String fName, String lName){
        System.out.println("Delete Name from Tree: " + fName + " " + lName);
        treenode delNode = find(fName, lName);
        if(delNode == null){
            //MA nothing found to delete returning null
            System.out.println("Name not found - nothing to delete.");
            return null;
        }
        else if(delNode.getLeftNode() == null && delNode.getRightNode() == null){
            //MA The node has no children
            //MA 		If isRightChild is true
                if(delNode.getisRightChild() == true){
                    //MA Set node’s parent’s right child to null
                    delNode.getparent().setRightNode(null);
                }
                else {
                    //MA Set node’s parent’s left child to null
                    delNode.getparent().setLeftNode(null);
                }
        }
        //MA Check for case two (the node has a right child)
        else if(delNode.getRightNode() != null && delNode.getLeftNode() == null){
            //MA Set node’s parent’s right child to node’s right child
            delNode.getparent().setRightNode(delNode.getRightNode());
            //MA Set node’s right child’s parent to node’s parent
            delNode.getRightNode().setParent(delNode.getparent());
        }
        //MA Check for case three (the node has a left child)
        else if(delNode.getLeftNode() != null && delNode.getRightNode() == null){
            //MA Set node’s parent’s left child to node’s left child
            delNode.getparent().setLeftNode(delNode.getLeftNode());
            //MA Set node’s left child’s parent to node’s parent
            delNode.getLeftNode().setParent(delNode.getparent());
        }
        //MA check to see if the node has both left and right children
        else if((delNode.getRightNode() != null) && (delNode.getLeftNode() != null)){
            //MA Call your utility method with the node’s right child as a parameter.
            //MA So you’ll have the smallest node in the node’s right subtree.
            //MA This node is guaranteed to be greater than any node in the node’s left subtree.
            //MA Replace the data of the node you want to delete with the data of the node you found in the subtree
            //MA Delete the node you found in the subtree (using the algorithm in case 1)

            delNode = util(delNode.getRightNode());

            if(delNode.getisRightChild() == true){
                //MA Set node’s parent’s right child to null
                delNode.getparent().setRightNode(null);
            }
            else {
                //MA Set node’s parent’s left child to null
                delNode.getparent().setLeftNode(null);
            }
        }
        //MA this is here to keep the IDE happy - should never hit this
        return null;
    }

    public treenode util (treenode utilTreenode){
        //MA Create a little utility method that takes a TreeNode and returns the leftmost child
        //MA It will simply be a while loop that goes down the left child repeatedly until the left child is null.
        //MA It returns that last left child.
        //MA This node has the characteristic of being the smallest node of the tree searched
        //MA create a variable to exit the loop
        boolean exitLoop = false;
        //MA create a variable to return
        treenode retTreenode = utilTreenode;
        //MA while the value has a left child repeat
        while(exitLoop == false){
            //MA update the return variable
            retTreenode = utilTreenode;
            //MA iterate to the next child
            utilTreenode = utilTreenode.getLeftNode();
            //MA check to see if the child is null - if it is set the exit to true
            if(utilTreenode.getLeftNode() == null){
                 exitLoop = true;
             }

        }
        //MA return the last node
        return retTreenode;
    }

    public String nameCat(String fName, String lName){
        //MA nameCat simply combines first and last name into a single string value
        return fName + lName;}
}
