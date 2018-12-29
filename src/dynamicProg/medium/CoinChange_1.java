package dynamicProg.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class CoinChange_1 {
    private static int total=0;
    private static int dp[][];
    public static void main(String[] a){
        getWays(4,new int[]{1,2,3}); //coins

        System.out.println("Total=="+total);
    }
    private static void getWays(int amount, int[] changes) {
        dp=new int[amount][changes.length];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        getWaysHelper(amount,changes,0,new ArrayList<Integer>());

    }
    private static void getWaysHelper(int amount, int[] changes, int i, ArrayList<Integer> ways) {
        if (amount<0) {
            ways.clear();
            return;
        }
        if (amount==0) {
            System.out.println(ways);
            ways.clear();
            total++;
            return;
        }
        if (i>=changes.length) return;
            //including
            ways.add(changes[i]);
            getWaysHelper(amount - changes[i], changes, i, ways);

            //excluding
            getWaysHelper(amount, changes, i + 1, ways);


    }
}
