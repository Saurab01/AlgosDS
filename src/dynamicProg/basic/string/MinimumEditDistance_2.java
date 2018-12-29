package dynamicProg.basic.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saurabhagrawal on 29/12/18.
 */
/*
Given two strings A and B, Find the minimum edit distance to transform A to B.
Only operations allowed to be done on A are - INSERT, REPLACE or DELETE a character.
Number of character modifications performed on A to transform it to B is called edit distance.
editDistance("apple", "appl") = > 1
editDistance("apple", "apples") = > 1
editDistance("cake", "caves") = > 2
 */
    //TODO: incomplete
public class MinimumEditDistance_2 {
    public static void main(String[] a){
        List<String[]> cases=new ArrayList<>();
        //cases.add(new String[]{"apple", "appl"});
        //cases.add(new String[]{"apple", "apples"});
        //cases.add(new String[]{"cake", "caves"});
        //cases.add(new String[]{"disturbance", "disruption"});
        //cases.add(new String[]{"", "xyz"});
        cases.add(new String[]{"sea", "eat"});

        for (String[] example: cases){
            System.out.println(minimumDist(example[0].toCharArray(),example[1].toCharArray(),0,0,
                    example[0].toCharArray().length, example[1].toCharArray().length));
        }
    }

    private static int minimumDist(char[] a, char[] b, int m, int n, int len1,int len2) {

        // If first string is empty, the only option is to insert all characters of second string into first
        if (m>=len1 && n<len2) return len2-len1;

        // If second string is empty, the only option is to remove all characters of first string
        if(n>=len2 && m<len1) return len1-len2;

        if(m>=len1 && n>=len2) return 0;

        if (a[m]==b[n]){
            return minimumDist(a,b,m+1,n+1,len1,len2);
        }
        else{

            int replaceMin=1+minimumDist(a,b,m+1,n+1,len1,len2); //replace
            int deleteMin= 1+minimumDist(a,b,m+1,n,len1,len2);  //delete
            int insertMin= 1+minimumDist(a,b,m,n+1,len1,len2);//insert
            //return minimum
            System.out.println("replaceMin="+replaceMin+" deleteMin="+deleteMin+" insertMin="+insertMin);
            return Math.min(Math.min(replaceMin, deleteMin), insertMin);
        }
    }
}
