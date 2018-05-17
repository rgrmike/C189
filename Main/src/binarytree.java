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
            System.out.println("Adding data to root");
        }
        else {
            rAdd(root, newTreeNode);
        }
    }

    public void rAdd(treenode root, treenode newTreeNode){
            /* compare the newTreeNode name value to the root value.
            If key is greater than root it will be positive - if it is less then it will be negative */
            if(newTreeNode.getName().compareTo(root.getName()) < 0){
                if(root.getLeftNode() == null){
                    //Set root left child to the new node
                    root.setLeftNode(newTreeNode);
                    //Set new node's parent to root
                    newTreeNode.setParent(root);
                    //set isRightChild to false
                    newTreeNode.setisRightChild(false);
                    System.out.println("Added left node with radd for: " + newTreeNode.getName());
                }
                else{
                    //Call rAdd with parameters root.getLeftChild and key
                    System.out.println("called rAdd with " + root.getLeftNode());
                    rAdd(root.getLeftNode(), newTreeNode);
                }
            }
            else{
                if(root.getRightNode() == null) {
                    //Set root’s right child to the new node
                    root.setRightNode(newTreeNode);
                    //Set new node’s parent to root
                    newTreeNode.setParent(root);
                    //Set isRightChild to true
                    newTreeNode.setisRightChild(true);
                    System.out.println("Added left node with radd for: " + newTreeNode.getName());
                }
                else{
                    System.out.println("called rAdd with " + root.getRightNode());
                    rAdd(root.getRightNode(), newTreeNode);
                }
            }


    }

    public void find(String fName, String lName){
        System.out.println("Find Tree Value: " + fName + " " + lName);
        String name = nameCat(fName, lName);
        rFind(root, name);
    }

    public treenode rFind(treenode root, String name){
        //If key ==  root’s name
        if(name.compareTo(root.getName()) == 0){
            //Report found
            System.out.println("Name: " + name + "found");
            //Return key
            return root;
        }
        //Else if key < root’s name
        else if(name.compareTo(root.getName()) < 0){
            //If root’s left child is null
            if(root.getLeftNode() == null){
                //Report not found
                System.out.println("Name: " + name + " not found as left node");
                //Return null
                return null;
            }
            //Else
            else {
                //Call rFind with root’s left child and name
                System.out.println("calling rFind with: " + root.getLeftNode());
                rFind(root.getLeftNode(), name);
            }
        }
        else {
            //If root’s right child is null
            if(root.getRightNode() == null) {
                //Report not found
                System.out.println("Name: " + name + " not found as right node");
                //Return null
                return null;
            }
            else {
                //Call rFind with root’s left child and name
                System.out.println("calling rFind with: " + root.getLeftNode());
                rFind(root.getLeftNode(), name);
            }
        }
        return null;
    }

    public void delete(String fName, String lName){
        System.out.println("Delete Name from Tree: " + fName + " " + lName);
        String name = nameCat(fName, lName);
        this.root = delete(name, this.root);
    }

    public treenode delete(String name, treenode currenttreenode){
        if(currenttreenode == null)
            return currenttreenode;
        int compareRes = currenttreenode.getName().compareTo(name);

        if(compareRes < 0)
            currenttreenode.setLeftNode(delete(name, currenttreenode.getLeftNode()));
        else if (compareRes > 0)
            currenttreenode.setRightNode(delete(name, currenttreenode.getRightNode()));
        else {
            if (currenttreenode.getLeftNode() == null)
                return currenttreenode.getRightNode();
            else if (currenttreenode.getRightNode() == null)
                return currenttreenode.getLeftNode();
            else {
                String littleName = currenttreenode.getName();

                while (currenttreenode.getLeftNode() != null){
                    littleName = currenttreenode.getLeftNode().getName();
                    currenttreenode = currenttreenode.getLeftNode();
                }
                currenttreenode.setRightNode(delete(littleName, currenttreenode.getRightNode()));
            }
        }
        return currenttreenode;
    }



    public String nameCat(String fName, String lName){
        return fName + lName;}
}
