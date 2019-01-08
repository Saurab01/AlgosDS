package graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by saurabhagrawal on 06/01/19.
 */
public class GraphsUtil {
    public static HashMap<Integer, ArrayList<Integer>> createGraph(){
        HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
        addEdge(graph,0, 1);
        addEdge(graph,0, 2);
        addEdge(graph,1, 2);
        addEdge(graph,2, 0);
        addEdge(graph,2, 3);
        addEdge(graph,3, 3);
        return graph;
    }

    public static void addEdge(HashMap<Integer, ArrayList<Integer>> graph, int u, int v) {
        if (!graph.containsKey(u)){
            graph.put(u,new ArrayList<>());
        }
        graph.get(u).add(v);  //for both

        if (!graph.containsKey(v)){  //for last elemet
            graph.put(v,new ArrayList<>());
        }
    }

    public static void main(String[] a){
        System.out.println(createGraph());
    }

    public static int[][] createWeightedGraph() {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        return graph;
    }
}
