import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return search(root, val);
    }
    public boolean search(BSTNode n, int val){
        if (n == null){
            return false;
        }
        if (val == n.getVal()){
            return true;
        }
        if (val > n.getVal()){
            return search(n.getRight(), val);
        }
        return search(n.getLeft(), val);
    }
    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder(){
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getInorder(list, root);
        return list;
    }
    public ArrayList<BSTNode> getInorder(ArrayList<BSTNode> list, BSTNode n){
        if(n == null){
            return list;
        }
        getInorder(list, n.getLeft());
        list.add(n);
        getInorder(list, n.getRight());
        return list;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getPreorder(list, root);
        return list;
    }
    public ArrayList<BSTNode> getPreorder(ArrayList<BSTNode> list, BSTNode n){
        if(n == null){
            return list;
        }
        list.add(n);
        getPreorder(list, n.getLeft());
        getPreorder(list, n.getRight());
        return list;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getPostorder(list, root);
        return list;
    }
    public ArrayList<BSTNode> getPostorder(ArrayList<BSTNode> list, BSTNode n){
        if(n == null){
            return list;
        }
        getPostorder(list, n.getLeft());
        getPostorder(list, n.getRight());
        list.add(n);
        return list;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insert(root, val);
    }

    public BSTNode insert(BSTNode n, int val){
        if (n == null){
            return new BSTNode(val);
        }
        if (val == n.getVal()){
            return n;
        }
        if (val > n.getVal()){
            n.setRight(insert(n.getRight(), val));
            return n;
        }
        n.setLeft(insert(n.getRight(), val));
        return n;
    }

    public void insert(BSTNode current, int val, BSTNode parent, int side){
        if (current == null){
            if (side == 1){
                parent.setLeft(current);
            }
            else{
                parent.setRight(current);
            }
            return;
        }
        if (val == current.getVal()){
            return;
        }
        if (val > current.getVal()){
            insert(current, val, parent.getRight(), 2);
        }
        insert(current, val, parent.getLeft(), 1);
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
