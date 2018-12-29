package array.basic;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class MaxContiguousSubArraySum {

    public static void main(String []a){
        //int arr[]={3,-1,0,9};
        int arr[]={-2,1,9,0,-10,8};
        int max_so_far=Integer.MIN_VALUE,sum_till_now=0;
        for(int i=0;i<arr.length;i++){
            //System.out.println("******\nCheck for "+arr[i]);
            sum_till_now=sum_till_now+arr[i];
            max_so_far=Math.max(max_so_far,sum_till_now);
            if (sum_till_now<0) sum_till_now=0;
            //System.out.println("max_so_far "+max_so_far);
            //System.out.println("sum_till_now "+sum_till_now);

        }
        System.out.print(max_so_far);
    }

}
