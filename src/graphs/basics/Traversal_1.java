package graphs.basics;

import graphs.GraphsUtil;

import java.util.*;

/**
 * Created by saurabhagrawal on 06/01/19.
 */
public class Traversal_1 {
    public static void main(String[] a){
        HashMap<Integer, ArrayList<Integer>> graph=GraphsUtil.createGraph();
        int startingPoint=0;
        Set<Integer> visited=new HashSet<>();
        System.out.println("****DFS results****");
        DFS(graph,visited,startingPoint);

        System.out.println("\n****BFS results****");
        visited.clear();
        visited.add(startingPoint); //first added only for BFS and not for DFS
        BFS(graph,visited,startingPoint);
    }

    private static void BFS(HashMap<Integer, ArrayList<Integer>> graph, Set<Integer> visited, int startingPoint) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(startingPoint);

        while (!queue.isEmpty()){
            int num=queue.poll();
            System.out.printf("%d ",num);
            for (Integer adj: graph.get(num)){
                if (!visited.contains(adj)){
                    visited.add(adj);
                    queue.add(adj);
                }
            }
        }
    }

    private static void DFS(HashMap<Integer, ArrayList<Integer>> graph, Set<Integer> visited, int n) {
        if (visited.contains(n)) return;
        System.out.printf("%d ",n);
        visited.add(n);
        for(Integer adj: graph.get(n)){
            if (!visited.contains(adj))
                DFS(graph,visited,adj);
        }
    }
}
