package recursion.basic.string.palindrome;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
//TODO: print well (save to DS)
//Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
// Find and return the shortest palindrome you can find by performing this transformation.
    //Input: "abcd"
    //Output: "dcbabcd"
    //Input: "aacecaaa"
    //Output: "aaacecaaa"

public class ShortestPalindrome {
    int dp[][];
    public static void main(String a[]) {
        String []exampleList = {"aacecaaa","abcd"};
        //String []exampleList = {"ab","aacecaaa"};

        for (String example: exampleList) {
            int start = 0;
            int length = example.toCharArray().length;
            int end = length - 1;
            System.out.println("\n****for "+example);
            insertRecur(example.toCharArray(), start, end);
        }

        /*dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(insertMinPalinDP(example.toCharArray(), start, end));*/
    }

    private static int insertRecur(char[] a, int start, int end) {
        if (start>=end) return 0;
        if (a[start]==a[end]) {
            System.out.print(a[end] + " ");
            return insertRecur(a,start+1,end-1);
        }
        else{
            System.out.print(a[end]+ " ");
            int minAddBegin=1+insertRecur(a,start,end-1);

            return minAddBegin;
        }
    }
}
