package DSA;

import java.util.ArrayList;
import java.util.List;

public class SubSeq {
    public static void main(String[] args) {
        //subSeq("", "abc");
        //System.out.println(subSeqRet("", "abc"));

        //System.out.println(skip("baakljdfa"));
        //List<List<Integer>> ans = subSet(new int[]{1, 2, 3});
        //System.out.println(ans);

        System.out.println(subSetDuplicates(new int[]{1,2,2}));
    }

    static void subSeq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSeq(p, up.substring(1));
        subSeq(p + ch, up.substring(1));
    }

    /*static ArrayList<String> subSeqRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = subSeqRet(p, up.substring(1));
        ArrayList<String> right = subSeqRet(p + ch, up.substring(1));
        left.addAll(right);

        return left;
    }*/

    static ArrayList<String> subSeqRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        char ch = up.charAt(0);
        list.addAll(subSeqRet(p, up.substring(1)));
        list.addAll(subSeqRet(p + ch, up.substring(1)));


        return list;
    }

    static String skip(String up) {
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }
    }


    static List<List<Integer>> subSet(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (Integer ele : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(ele);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subSetDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end;
            }

            end = outer.size();
            int n = outer.size();
            for (int j = start; j < n; j++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }

        }
        return outer;
    }


}
