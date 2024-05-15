package DSA;

public class BS {

    public static class Node {

        int val;

        Node left;

        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    BS() {

    }


    public Node insert(int arr[]) {
        if (arr.length > 0) {
            root = new Node(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    private Node insert(Node node, int val) {

        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        }

        if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public  void display(){
        display(this.root);
    }

    public void display(Node node){
        if (node == null) {
            return;
        }


        display(node.left);
        System.out.println(node.val);
        display(node.right);

    }
    public int level () {
        Node x = new Node(12);
        return level(root, x, 0);
    }


     int level (Node node, Node x, int lev) {
        if(node == null) {
            return 0;
        }

        if(node.val == x.val) {
            return lev;
        }

        int l = level(node.left, x, lev+1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev+1);
    }


}