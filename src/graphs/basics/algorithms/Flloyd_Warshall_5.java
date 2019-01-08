package graphs.basics.algorithms;

/**
 * Created by saurabhagrawal on 09/01/19.
 */
public class Flloyd_Warshall_5 {
    final static int INF = 99999, vertices = 4;
    public static void main(String[] a){
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        shortestPath(graph);
    }

    private static void shortestPath(int[][] graph) {
        int soln[][]=iniialiseSolnMatrixToInputMatrix(graph);//step1

        for (int k=0;k<vertices;k++){
            for (int i=0;i<vertices;i++){
                for (int j=0;j<vertices;j++){
                    if (soln[i][k] + soln[k][j] < soln[i][j])
                        soln[i][j] = soln[i][k] + soln[k][j];
                }
            }
        }
        printShortestMatrix(soln);
    }

    private static void printShortestMatrix(int[][] soln) {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<vertices; i++)
        {
            for (int j=0; j<vertices; j++)
            {
                if (soln[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(soln[i][j]+"   ");
            }
            System.out.println();
        }
    }

    private static int[][] iniialiseSolnMatrixToInputMatrix(int[][] graph) {
        int soln[][]=new int[vertices][vertices];
        for (int i=0;i<vertices;i++){
            for (int j=0;j<vertices;j++)
                soln[i][j]=graph[i][j];
        }
        return soln;
    }
}
