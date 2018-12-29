package dynamicProg.basic.string;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class LongestCommonSubSequence_1 {
    private static int dp[][];
    public static void main(String[] a){
        String str1="grapple";
        String str2="rple";
        System.out.println(lcsLenHelperRecu(str1.toCharArray(),str2.toCharArray(),0,0));

        dp=new int[str1.length()][str2.length()];
        for (int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(lcsLenHelperDP(str1.toCharArray(),str2.toCharArray(),0,0));
        printDPMatrix(dp);
        printSubSequence(dp);
    }

    private static int lcsLenHelperRecu(char[] a, char[] b, int m, int n) { //m for a  n for b
        if (m>=a.length || n>=b.length) return 0;

        //System.out.println("Check for "+m +"  "+n+ "   --");
        //System.out.println(a[m]+ "  "+b[n]);
        if (a[m]==b[n]){   //equal
            return 1+lcsLenHelperRecu(a,b,m+1,n+1);
        }else{
            int bNext=lcsLenHelperRecu(a,b,m,n+1); //checking next in b array
            int aNext=lcsLenHelperRecu(a,b,m+1,n);
            return Math.max(aNext,bNext);
        }
    }
    //using DP
    private static int lcsLenHelperDP(char[] a, char[] b, int m, int n) { //m for a  n for b
        if (m>=a.length || n>=b.length) return 0;

        //System.out.println("Check for "+m +"  "+n+ "   --");
        //System.out.println(a[m]+ "  "+b[n]);
        if (dp[m][n]==-1) {
            if (a[m] == b[n]) {   //equal
                dp[m][n]= 1 + lcsLenHelperDP(a, b, m + 1, n + 1);
            } else {
                int bNext = lcsLenHelperDP(a, b, m, n + 1); //checking next in b array
                int aNext = lcsLenHelperDP(a, b, m + 1, n);
                dp[m][n]= Math.max(aNext, bNext);
            }
        }
        //System.out.println("Check for "+m +"  "+n+ "   --");
        return dp[m][n];
    }

    private static void printDPMatrix(int[][] dp) {
        for (int i=0;i<dp.length;i++)
            System.out.println(Arrays.toString(dp[i]));
    }

    //TODO: print subsequence
    private static void printSubSequence(int[][] dp) {

    }
}
