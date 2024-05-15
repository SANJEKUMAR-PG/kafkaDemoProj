/*
package com.kafka.kafkaDemoProj;

import com.kafka.kafkaDemoProj.Service.MergeSort;

import java.util.Arrays;

public class Calculation {


    */
/*Calculation.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        Calculation.mergeSortInPlace(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));*//*


       // main method code


/*BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        binaryTree.populate(scanner);
       binaryTree.display();*/

        /*BST tree = new BST();
        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
//        tree.populate(nums);
//        tree.display();
//        System.out.println(tree.balanced());
        tree.populatedSorted(nums);
        tree.display();
        System.out.println(tree.balanced());*/

    //Merge Sort


    //Quick Sort

   /* public static void quickSort(int nums[], int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }

        }

        quickSort(nums, low, e);
        quickSort(nums, s, high);

    }

    public static int findMax(int[] ints) {
        return 0;
    }

    public static void mergeSortInPlace(int[] nums, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = (e - s) / 2 + s;
        mergeSortInPlace(nums, s, mid);
        mergeSortInPlace(nums, mid, e);

        //sortInPlace(nums,s ,mid ,e);
    }

   */
/* private static void sortInPlace(int[] nums, int s, int m, int e) {
        int arr[] =  new int[e-s];
        int i = s;
        int j = m;
        int k = 0 ;

        while(i<m&&j<e){
            if (nums[i]<nums[j]) {
            }
        }

        while(){

        }

        while(){

        }

    }*//*


    public static int mySqrt(int x) {
        int s = 1;
        int e = x;
        int m = -1;

        while (s <= e) {
            m = s + (e - s) / 2;
            if (m * m > x) {
                e = m - 1;
            } else if (m * m == x) {
                return m;
            } else {
                s = m + 1;
            }
        }

        return m - 1;
    }

    public static int isPalindrome(int arr[]) {
        int missingNum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num =  arr[i] ^ i;
            missingNum = missingNum ^ num;
        }
        return missingNum;
    }

    public static boolean hasCycle(MergeSort.ListNode head) {
        if(head == null)
            return false;

        MergeSort.ListNode fast = head.next;
        MergeSort.ListNode slow = head;

        while(slow != fast && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == fast)
            return true;

        return false;
    }

     ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


 static Node head;

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void getNodeAtIndex(Node head) {
        if (head == null) {
            return; // Index out of bounds or empty list
        }

        Node current = head;

        while(current!=null){
            if (current.next == null) {
                return; // Index out of bounds
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(2);
        node.next.next = new Node(0);
        node.next.next.next = new Node(-4);
        head = node;

         getNodeAtIndex(head);


        System.out.println(insertRec(7, 2));
    }


    public static Node insertRec(int val, int index) {
        head = insertRec(val, index, head);
        return head;
    }

    private static Node insertRec(int val, int index, Node node) {
        if (node!=null) {
            if (index == 0) {
                Node temp = new Node(val, node);
                return temp;
            }
            node.next = insertRec(val, index--, node.next);

        }
        return node;
    }



 public static void mergeSort(int arr[], int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = (s+e) / 2 ;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);
        sort(arr, s, mid, e);
    }


    public static void sort(int arr[], int s, int m, int e) {
        int mix[] = new int[e - s];
        int i = s;
        int j = m;
        int k = 0;
            while (i < m && j < e) {
                if (arr[i] < arr[j]) {
                    mix[k] = arr[i];
                    i++;
                } else {
                    mix[k] = arr[j];
                    j++;
                }
                k++;
            }

            while (i < m) {
                mix[k] = arr[i];
                i++;
                k++;
            }

            while (j < e) {
                mix[k] = arr[j];
                j++;
                k++;
            }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }


    }

==================================================================================================================

Subsequence and permutations

public static void main(String[] args) {
        int[] arr = new int[]{-1,7,0,3,57,2,6};
        subSequence("","abc");
        System.out.println("==================================================");
        Permutations("","abc");
    }


    public static  void subSequence(String p,String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSequence(p + ch, up.substring(1));
        subSequence(p, up.substring(1));

    }

    public static  void Permutations(String p,String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            Permutations(f + ch + s, up.substring(1));
        }
    }



    ==========================================================================================================

    subset of Array

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> ans = subSet(arr);
        System.out.println(ans);
    }

    // normal subset
    private static List<List<Integer>> subSet(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }


    =============================================================================

    remove duplicate in subsets

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2};
        List<List<Integer>> ans = subSetDuplicates(arr);
        System.out.println(ans);
    }

    // duplicate subset
    private static List<List<Integer>> subSetDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            int n = outer.size();
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }



    // reverse linked list in between

    public static void main(String[] args) {
        ListNode nodeWithValue = new ListNode(1);

        // You can also create multiple nodes and link them together
        ListNode firstNode = new ListNode(2);
        ListNode secondNode = new ListNode(3);
        ListNode thirdNode = new ListNode(4);
        ListNode fourthNode = new ListNode(5);

        // Linking nodes
        nodeWithValue.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        ListNode temp = nodeWithValue;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        ListNode head = reverseBetween(nodeWithValue,2,4);
        System.out.println();
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newNode = current;

        for (int i = 0; current != null && i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newNode.next = current;

        return head;
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }



    ===============================================================================================================================


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = null;
        if (n > 0) {
            int data = scanner.nextInt();
            head = new Node(data);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int val = scanner.nextInt();
                Node newNode = new Node(val);
                temp.next = newNode;
                temp = newNode;
            }
        }

        Node result = reverseList(head);
        while(result!=null){
            System.out.print(result.value + "->");
            result = result.next;
        }
    }


    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


     static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    ================================================================================================================================

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = null;
        if (n > 0) {
            int data = scanner.nextInt();
            head = new Node(data);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int val = scanner.nextInt();
                Node newNode = new Node(val);
                temp.next = newNode;
                temp = newNode;
            }
        }

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }

        System.out.println();

        Node result = reverseBetween(head,2,6);
        while(result!=null){
            System.out.print(result.value + "->");
            result = result.next;
        }

    }

    public static Node reverseBetween(Node head, int left, int right) {
        Node current = head;
        Node prev = null;

        for (int i = 0; i < left - 1 && current != null; i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        for (int i = 0; i < right - left + 1 && current != null; i++) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        if (newEnd != null) {
            newEnd.next = current;
        }

        return head;

    }

    ============================================================================================================================


public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ListNode head = null;
        if (n > 0) {
            int data = scanner.nextInt();
            head = new ListNode(data);

            ListNode current = head;
            for (int i = 1; i < n; i++) {
                int value = scanner.nextInt();
                ListNode newNode = new ListNode(value);
                current.next = newNode;
                current = newNode;
            }
        }
        ListNode start = head;
        while (start != null) {
            System.out.print(start.value + "->");
            start = start.next;
        }
        System.out.println();

        ListNode result = reverseKGroups(head, 2);
        while (result != null) {
            System.out.print(result.value + "->");
            result = result.next;
        }

    }

    private static ListNode reverseKGroups(ListNode head, int k) {

        if (k <= 1 && head == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            ListNode last = prev;
            ListNode newEnd = current;

            for (int i = 0; i < k && current != null; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            if (newEnd != null) {
                newEnd.next = current;
            }
            prev = newEnd;

            count--;
        }
        return head;
    }

    private static int getLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }


    static class ListNode {
        private int value;

        private ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

}
*/
