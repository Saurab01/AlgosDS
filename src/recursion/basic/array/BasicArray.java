package recursion.basic.array;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
public class BasicArray {
    public static void main(String[] a){
        BasicArray obj=new BasicArray();
        //obj.printAllSubSequences();
    }

    //Ques1
    private void printAllSubSequences() {
        int a[]={1,2,3};
        int p[]=new int[a.length];
        Arrays.fill(p,-1);
        printAllSubSequencesHelper(a,0,a.length,p,0);
    }
    private void printAllSubSequencesHelper(int[] a, int i, int length,int p[],int pi) {
        if (i>=length) {
            System.out.println(Arrays.toString(p));
            System.out.println();
            return;
        }
        //included
        System.out.println("+++Including "+a[i]);
        p[pi]=a[i];
        printAllSubSequencesHelper(a,i+1,length,p,pi+1);

        //not included
        p[pi]=-1;
        System.out.println("---Exncluding "+a[i]);
        printAllSubSequencesHelper(a,i+1,length,p,pi);

    }

}
