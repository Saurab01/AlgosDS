package dynamicProg.basic.array;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class DynamicProgArray {
    public static void main(String a[]){
        DynamicProgArray obj=new DynamicProgArray();
        obj.maximumSubsequenceSum();
    }

    //Ques1 Maximum Subsequnece SUm---not necessary contiguous
    private void maximumSubsequenceSum() {
        int a[]={-1,20,-5,11,-2,3};
        System.out.println("*******\nMax subsequence sum using Recursion=="+maximumSubsequenceSumHelperRecursion(a,0));

        int dp[] =new int[a.length];
        Arrays.fill(dp,-1);
        System.out.println("Max subsequence sum using DP=="+maximumSubsequenceSumHelperDP(a,0,dp));
    }

    private int maximumSubsequenceSumHelperRecursion(int[] a, int i) {
        if (i>=a.length) return 0;
        //including me
        int includingMe=a[i]+maximumSubsequenceSumHelperRecursion(a,i+1);
        //excluding me
        int excludingMe=maximumSubsequenceSumHelperRecursion(a,i+1);
        return Math.max(includingMe,excludingMe);
    }

    private int maximumSubsequenceSumHelperDP(int[] a, int i,int dp[]) {
        if (i>=a.length) return 0;

        if (dp[i]==-1) {
            //including me
            int includingMe = a[i] + maximumSubsequenceSumHelperRecursion(a, i + 1);
            //excluding me
            int excludingMe = maximumSubsequenceSumHelperRecursion(a, i + 1);
            dp[i] =Math.max(includingMe, excludingMe);
        }
        return dp[i];
    }


}
