package dynamicProg.basic.matrix;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class MatrixRelated {
    public static void main(String[] a){
        MatrixRelated obj=new MatrixRelated();
        System.out.println("****\nMaximum Cost=="+obj.findMaxCost());
    }

    private int findMaxCost() {
        //int a[][]={{1,2,3},{4,9,6},{7,8,9}};
        int a[][]={{1,2,3},{4,8,2},{1,5,3}};
        int dp[][]=new int[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return MatrixRelatedHelper.getMaxCostHelper(0,0,a.length,a[0].length,a,dp);
    }

}
