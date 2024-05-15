package com.kafka.kafkaDemoProj.Service;

public class MergeSort {

    public static void main(String args[]) {
        int[] arr = {45};
        BS bs = new BS();
        bs.insert(arr);
        bs.display();
       int l = bs.level();
        System.out.println(l);
    }











    public static class TreeNode {

        TreeNode left;

        TreeNode right;

        int val;

        public TreeNode( int val) {
            this.val = val;
        }
    }

}
