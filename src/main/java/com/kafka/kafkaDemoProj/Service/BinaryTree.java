package com.kafka.kafkaDemoProj.Service;

import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }
    }

     Node root;

    public void populate(Scanner scanner){
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner,root);
    }

    public void populate(Scanner scanner,Node node) {
        System.out.println("left yes/no:");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("left val of  " + node.val);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("right yes/no");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("right val of " + node.val);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root,"");
    }

    public void display(Node node,String indent){
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }

    public void preOrder(Node node){
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);

    }

    public void InOrder(Node node){
        if (node == null) {
            return;
        }

        InOrder(node.left);
        System.out.println(node.val);
        InOrder(node.right);

    }

    public void postOrder(Node node){
        if (node == null) {
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.val);

    }

}
