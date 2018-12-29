package dynamicProg.basic.matrix;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class MatrixRelatedHelper {

    static int getMaxCostHelper(int i,int j, int r, int c,int a[][],int dp[][]){
        if (i>=r || j>=c) return Integer.MIN_VALUE;  //to make suitable for negative numbers--dont return zero
        else if (i==r-1 && j==c-1) return a[i][j];
        if (dp[i][j] ==-1){
            dp[i][j]=a[i][j]+getMax(getMaxCostHelper(i+1,j,r,c,a,dp),getMaxCostHelper(i,j+1,r,c,a,dp));
        }
        return dp[i][j];
    }







    static int getMax(int a , int b){
        return a>b?a:b;
    }
}
