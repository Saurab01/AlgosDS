package recursion.basic.string.palindrome;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class InsertionTOMakePalindrome {
    private static int dp[][];

    public static void main(String []a){
        String example="abcde";

        int start=0;
        int length=example.toCharArray().length;
        int end=length-1;
        System.out.println(insertMinPalin(example.toCharArray(),start,end) );

        dp=new int[length][length];
        for (int i=0;i<length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(insertMinPalinDP(example.toCharArray(),start,end));
    }

    private static int insertMinPalin(char[] arr, int start, int end) {
        //System.out.println("Check for:: "+arr[start]+"  "+arr[end]);
        if (start>=end) return 0;
        if (arr[start]==arr[end]) {
            return insertMinPalin(arr, start + 1, end - 1);
        }
        else{
            int insertionEnd=1+ insertMinPalin(arr,start+1,end);
            int insertionBegin=1+ insertMinPalin(arr,start,end-1);
            return Math.min(insertionBegin,insertionEnd);
        }
    }

//with DP
    private static int insertMinPalinDP(char[] arr, int start, int end) {
        if (start>=end) return 0;

        if (dp[start][end]==-1) {
            if (arr[start] == arr[end]) {
                return dp[start][end]=insertMinPalinDP(arr, start + 1, end - 1);
            } else {
                int insertionEnd = 1 + insertMinPalinDP(arr, start + 1, end);
                int insertionBegin = 1 + insertMinPalinDP(arr, start, end - 1);
                return dp[start][end]=Math.min(insertionBegin, insertionEnd);
            }
        }
        return dp[start][end];
    }
}
