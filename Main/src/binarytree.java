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
        treenode newNode = new treenode(name, phone, email);
        boolean needNew = false;

        if(root == null)root = newNode;
        else {
            treenode currenttreenode = root;
            treenode parenttreenode = null;

            while(!needNew){
                parenttreenode = currenttreenode;

                if(currenttreenode.getName().compareTo(name)<0){
                    currenttreenode = currenttreenode.getleftNode();

                    if(currenttreenode == null){
                        parenttreenode.setLeftNode(newNode);
                        needNew = true;
                    }
                }else {
                    currenttreenode=currenttreenode.getRightNode();

                    if(currenttreenode == null){
                        parenttreenode.setRightNode(newNode);
                        needNew = true;
                    }
                }
            }
        }
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
            currenttreenode.setLeftNode(delete(name, currenttreenode.getleftNode()));
        else if (compareRes > 0)
            currenttreenode.setRightNode(delete(name, currenttreenode.getRightNode()));
        else {
            if (currenttreenode.getleftNode() == null)
                return currenttreenode.getRightNode();
            else if (currenttreenode.getRightNode() == null)
                return currenttreenode.getleftNode();
            else {
                String littleName = currenttreenode.getName();

                while (currenttreenode.getleftNode() != null){
                    littleName = currenttreenode.getleftNode().getName();
                    currenttreenode = currenttreenode.getleftNode();
                }
                currenttreenode.setRightNode(delete(littleName, currenttreenode.getRightNode()));
            }
        }
        return currenttreenode;
    }

    public String[] find(String fName, String lName){
        System.out.println("Find Tree Value: " + fName + " " + lName);
        String name = nameCat(fName, lName);
        String[] dataArray = new String[2];

        if(root == null) {
            System.out.println("Data not found in tree");
                    return dataArray;
        }
        else {
            treenode currenttreenode = root;

            while (currenttreenode != null){
                if(currenttreenode.getName().equals(name)){
                    dataArray[0] = currenttreenode.getEmail();
                    dataArray[1] = currenttreenode.getPhone();
                    return dataArray;
                }
                else if(currenttreenode.getName().compareTo(name) < 0)
                    currenttreenode = currenttreenode.getleftNode();
                else
                    currenttreenode = currenttreenode.getRightNode();
            }
        }
        System.out.println(fName + " " + lName + " not found.");
        return dataArray;
    }

    public String nameCat(String fName, String lName){
        String tempName = fName + lName;
        return tempName;}
}
