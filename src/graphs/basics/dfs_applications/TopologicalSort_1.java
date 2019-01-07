package graphs.basics.dfs_applications;

import graphs.GraphsUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by saurabhagrawal on 06/01/19.
 */
public class TopologicalSort_1 {
    public static void main(String [] a){
        HashMap<Integer, ArrayList<Integer>> graph = createGraph();

        HashSet<Integer> visited=new HashSet<>();
        Stack<Integer> stack=new Stack<>();
        for (int num: graph.keySet()) {
            System.out.println("\n*****Testing for " + num);
            //visited.clear();  //dont clear here as same visited array be used
            topologicalSortDFS(graph, visited, stack,num);
        }
        printStack(stack);
    }

    private static void printStack(Stack<Integer> stack) {
        while(!stack.isEmpty()){
            System.out.printf("%d ",stack.pop());
        }
    }

    private static void topologicalSortDFS(HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited,
                                           Stack<Integer> stack, int num) {
        System.out.println("Checking  " + num);
        if (visited.contains(num)) return;

        visited.add(num);
        for (Integer adj: graph.get(num)){
            if (!visited.contains(adj)){
                topologicalSortDFS(graph, visited, stack,adj);
            }
        }
        stack.add(num);
    }

    private static HashMap<Integer,ArrayList<Integer>> createGraph() {
        HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();

        GraphsUtil.addEdge(graph,5, 2);
        GraphsUtil.addEdge(graph,5, 0);
        GraphsUtil.addEdge(graph,4, 0);
        GraphsUtil.addEdge(graph,4, 1);
        GraphsUtil.addEdge(graph,2, 3);
        GraphsUtil.addEdge(graph,3, 1);
        return graph;
    }

}
