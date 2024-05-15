package DSA;

public class DoIt {


    public static void main(String[] args) {
        char[] s= new char[]{'H','a','n','n','a','h'};
        DoIt  doIt =new DoIt();
        doIt.reverseString(s);

    }

    public void reverseString(char[] s) {
        char arr[] = new char[s.length];
        int count = 0;
        int p =arr.length;

        for (int k = 0; k < p; k++) {
            for (int l = k + 1; l < p; l++) {
                if (arr[k] == arr[l]) {
                   p--;
                   l--;
                }
            }
            count++;
        }
    }
    }
