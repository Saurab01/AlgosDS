package graphs.basics.algorithms;

import graphs.GraphsUtil;

import java.util.Arrays;

/**
 * Created by saurabhagrawal on 09/01/19.
 */
public class Prims_3 {
    public static void main(String[] a) {

        //int[][] graph = GraphsUtil.createWeightedGraph();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        int startingPoint = 0;
        shortestPath(graph,graph[0].length);
    }

    private static void shortestPath(int[][] graph,int vertices) {
        int keys[] = new int[vertices];  //output array having keys start to i
        // Array to store constructed MST
        int parent[] = new int[vertices];  //TODO: see why for
        Boolean visited[] = new Boolean[vertices];

        for (int i=0;i< vertices; i++){  //initialise all distance as infinte and visited as false
            keys[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        // Distance of source vertex from itself is always 0
        keys[0] = 0;  //Always include first vertex in MST
        parent[0] = -1; // First node is always root of MST

        for (int i=0;i< vertices; i++){

            //finding minimum distance index not visited
            int u=minimum(keys,visited);

            System.out.println("Doing for vertex "+u);
            visited[u]=true; //marking minimum vertex as visited
            for (int v=0;v<vertices;v++){
                if (!visited[v] && graph[u][v]!=0){ //if not visited and there is edge u to v
                    if (keys[u]!= Integer.MAX_VALUE &&keys[v]>graph[u][v] ){
                        keys[v]=graph[u][v];
                        parent[v] = u;
                    }
                }
            }
            //System.out.println(Arrays.toString(keys));
        }
        // print the constructed MST
        printMST(parent, vertices, graph);

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
    static void printMST(int parent[], int vertices, int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++)
            System.out.println(parent[i]+" - "+ i+"\t"+graph[i][parent[i]]);
    }
}
