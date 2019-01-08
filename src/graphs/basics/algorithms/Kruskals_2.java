package graphs.basics.algorithms;

import graphs.GraphsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by saurabhagrawal on 09/01/19.
 */
public class Kruskals_2 {
    public static void main(String[] a) {

        int[][] graph = GraphsUtil.createWeightedGraph();
        //int startingPoint = 0;
        shortestPath(graph,graph[0].length);
    }

    private static void shortestPath(int[][] graph, int vertices) {

        //get all edges
        List<Edge> edges=new ArrayList<>();
        for (int i=0;i<vertices;i++){
            for (int j=0;j<vertices;j++){
                if (i!=j && graph[i][j]!=0 ){  //i !=j as we dont need cycles
                    edges.add(new Edge(i,j,graph[i][j]));
                }
            }
        }
        Collections.sort(edges);  //Step1 : edges sorted by weigths

        //Step2 Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far.
        // If cycle is not formed, include this edge. Else, discard it.

    }

    static class Edge implements Comparable<Edge>{
        int src,dest,weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge)
        {return this.weight-compareEdge.weight;}
    }
}
//https://www.sanfoundry.com/java-program-find-mst-using-kruskals-algorithm/
