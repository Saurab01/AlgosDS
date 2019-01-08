package graphs.applications;

import javafx.scene.control.Cell;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by saurabhagrawal on 09/01/19.
 */
public class SnakeLadder_1 {
    public static void main(String[] args)
    {
        int N = 30;
        int moves[] = new int[N+1];
        for (int i = 0; i < N+1; i++)
            moves[i] = -1;

        // Ladders
        moves[3] = 22;
        moves[5] = 8;
        moves[11] = 26;
        moves[20] = 29;

        // Snakes
        moves[27] = 1;
        moves[21] = 9;
        moves[17] = 4;
        moves[19] = 7;

        System.out.println("Min Dice throws required is " + new SnakeLadder_1().getMinDiceThrows(moves, N));
    }

    private int getMinDiceThrows(int[] moves, int N) {
        int finalDiceCount=0;
        CellEntry cell=new CellEntry(1,0);  //start with cell=1, dice count=0
        Queue<CellEntry> queue=new LinkedList<>();
        queue.add(cell);

        int[] visited=new int[N+1];
        for (int i=0;i<N+1;i++) visited[i]=-1; //1 to 30
        visited[1]=1;  //set visited first cell as 1

        while(!queue.isEmpty()){
            CellEntry prev=queue.poll();
            if (prev.cellNo==N) {
                finalDiceCount=prev.mimimum_dice_count;
                break;
            }

            for (int i=1;i<=6;i++){
                if (prev.cellNo+i<=N && visited[prev.cellNo+i]==-1) {  //cell number sum<=30 and not visited

                    int tempCellNo=prev.cellNo + i;
                    if (moves[prev.cellNo + i]!=-1) tempCellNo=moves[prev.cellNo + i];

                    CellEntry newCell = new CellEntry(tempCellNo , prev.mimimum_dice_count + 1);
                    visited[prev.cellNo + i]=1;  //in visiting array keeping current only, not new
                    queue.add(newCell);
                }
            }
        }
        return finalDiceCount;
    }
    private class CellEntry{
        int cellNo;
        int mimimum_dice_count;

        public CellEntry(int cellNo, int mimimum_dice_count) {
            this.cellNo = cellNo;
            this.mimimum_dice_count = mimimum_dice_count;
        }
    }
}
