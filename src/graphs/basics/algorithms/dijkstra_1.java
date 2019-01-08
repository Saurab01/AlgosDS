package graphs.basics.algorithms;

import graphs.GraphsUtil;

import java.util.*;

/**
 * Created by saurabhagrawal on 08/01/19.
 */
public class dijkstra_1 {
    public static void main(String[] a) {

        int[][] graph = GraphsUtil.createWeightedGraph();
        int startingPoint = 0;
        shortestPath(graph,graph[0].length,0);
    }

    private static void shortestPath(int[][] graph,int vertices,int start) {

        int dist[] = new int[vertices];  //output array having dist start to i
        Boolean visited[] = new Boolean[vertices];

        for (int i=0;i< vertices; i++){  //initialise all distance as infinte and visited as false
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        // Distance of source vertex from itself is always 0
        dist[start] = 0;

        for (int i=0;i< vertices; i++){

            //finding minimum distance index not visited
            int u=minimum(dist,visited);

            System.out.println("Doing for vertex "+u);
            visited[u]=true; //marking minimum vertex as visited
            for (int v=0;v<vertices;v++){
                if (!visited[v] && graph[u][v]!=0){ //if not visited and there is edge u to v
                    if (dist[u]!= Integer.MAX_VALUE &&dist[v]>dist[u]+graph[u][v] ){
                        dist[v]=dist[u]+graph[u][v];
                    }
                }
            }
            System.out.println(Arrays.toString(dist));
        }
        // print the constructed distance array
        printSolution(dist, vertices);
    }

    private static int minimum(int[] dist, Boolean[] visited) {
        int minimum=Integer.MAX_VALUE;
        int min_index=0;
        for (int i=1;i<dist.length;i++){
            if (!visited[i]){
                if (dist[i]<minimum){
                    minimum=dist[i];
                    min_index=i;
                }
            }
        }
        return min_index;
    }

    static void  printSolution(int dist[], int vertices)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < vertices; i++)
            System.out.println(i+" tt "+dist[i]);
    }
}
