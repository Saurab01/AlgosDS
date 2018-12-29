package heap.basics;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by saurabhagrawal on 30/12/18.
 */
/*
Given an infinite stream of integers, find the k’th largest element at any point of time.
Input:
stream[] = {10, 20, 11, 70, 50, 40, 100, 5, ...}
k = 3
Output:    {_,   _, 10, 11, 20, 40, 50,  50, ...}
 */
public class KthLargestElementStream {
    public static void main(String[] a){

        Integer[] input=new Integer[]{10, 20, 11, 70, 50, 40, 100, 5};
        int k=3;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(); //by default ascending order
        Integer[] kthLargestOutput=new Integer[input.length];

        getKthLargest(input,k,kthLargestOutput,minHeap);
        System.out.println(Arrays.deepToString(kthLargestOutput));
    }

    private static void getKthLargest(Integer[] input, int k, Integer[] kthLargestOutput, PriorityQueue<Integer> minHeap) {
        for (int i=0;i<input.length;i++){

            if (minHeap.size()<k)
                minHeap.add(input[i]);
            else if (input[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.add(input[i]);
            }
            if(minHeap.size()==k)
                kthLargestOutput[i]=minHeap.peek();
            //System.out.println("After "+(i+1)+" iteration piorittQueue is="+Arrays.deepToString(minHeap.toArray()));
        }
    }
}
