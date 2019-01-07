package graphs.basics.dfs_applications;

import graphs.GraphsUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by saurabhagrawal on 06/01/19.
 */
public class PrintAllPaths_3 {
    public static void main(String[] a) {

        HashMap<Integer, ArrayList<Integer>> graph = GraphsUtil.createGraph();
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> path=new ArrayList<>();

        for (int num: graph.keySet()) {
            System.out.println("\n*****Testing for " + num);
            visited.clear();
            path.clear();
            pathFindDFS(graph, visited, path,num);
            path.stream().forEach(i->System.out.printf("%d ",i));
        }
    }

    private static void pathFindDFS(HashMap<Integer, ArrayList<Integer>> graph, Set<Integer> visited,
                                    ArrayList<Integer> path, int num) {
        if (visited.contains(num)) return;
        visited.add(num);
        path.add(num);
        for (int adj: graph.get(num)){
            if (!visited.contains(adj))
                pathFindDFS(graph, visited, path,adj);
        }
    }

}
