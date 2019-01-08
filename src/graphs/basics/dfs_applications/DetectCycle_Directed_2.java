package graphs.basics.dfs_applications;

import graphs.GraphsUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by saurabhagrawal on 06/01/19.
 */
//We do DFS for all vertices, and maintain visited stack,recursion stack, if element present in recursion stack
// means there is cycle
public class DetectCycle_Directed_2 {
    public static void main(String[] a) {

        HashMap<Integer, ArrayList<Integer>> graph = GraphsUtil.createGraph();

        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (int num: graph.keySet()){
            System.out.println("*****Testing for "+num);

            visited.clear();
            recursionStack.clear();

            if (detectCycleDFS(graph,visited,recursionStack,num)){
                System.out.println("cycle is present");
                return;
            }
        }
        System.out.println("----cycle not present");
    }

    private static boolean detectCycleDFS(HashMap<Integer, ArrayList<Integer>> graph, Set<Integer> visited,
                                       Set<Integer> recursionStack, int num) {
        if (recursionStack.contains(num)) return true;
        if (visited.contains(num)) return false;

        System.out.println("Test for "+num);
        recursionStack.add(num);
        visited.add(num);

        for (Integer adj : graph.get(num)) {
                //if (below called for visited not contains adj--then loop will not be detected)
                 return detectCycleDFS(graph, visited, recursionStack, adj);
        }
        return false;
    }
}
