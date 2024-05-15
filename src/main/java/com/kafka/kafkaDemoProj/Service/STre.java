package com.kafka.kafkaDemoProj.Service;

public class STre {

    private static class Node {
        int val;

        Node left;

        Node right;

        int startInterval;

        int endInterval;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;


    public STre(int arr[]) {
        this.root = segmentTree(arr, 0, arr.length - 1);
    }

    private Node segmentTree(int[] arr, int s, int e) {

        if (s == e) {
            Node leaf = new Node(s, e);
            leaf.val = arr[s];
            return leaf;
        }

        Node node = new Node(s, e);

        int mid = (e - s) / 2 + s;

         node.left = segmentTree(arr, s, mid);
         node.right = segmentTree(arr, mid + 1, e);

        node.val = node.left.val + node.right.val;
        return node;
    }
    public void display(Node node, String indent){
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }

}
