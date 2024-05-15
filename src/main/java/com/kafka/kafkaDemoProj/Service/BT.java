package com.kafka.kafkaDemoProj.Service;

import java.util.Scanner;

public class BT {

    public static class Node{
        int val;

        Node left;

        Node right;

        Node(int val){
            this.val = val;
        }

        public int getVal(){
            return val;
        }
    }

    private Node root;


    public Node populate(Scanner scanner){
        System.out.println("enter root node val ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(root,scanner);
        return  root;
    }

    public Node populate(Node node ,Scanner scanner) {

        boolean left = scanner.nextBoolean();
        if (left) {
            int value = scanner.nextInt();
            node.left = populate(new Node(value),scanner);
        }

        boolean right = scanner.nextBoolean();
        if (right) {
            int value = scanner.nextInt();
            node.right = populate(new Node(value),scanner);
        }
        return  node;


    }

    public void display(){
        display(this.root,"");
    }

    public void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.val);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
}
