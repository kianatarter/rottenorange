import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;
        for (int m = 0; m < grid.length; m++){
            for (int n = 0; n < grid[0].length; n++){
                if (grid[m][n] == 1){
                    fresh += 1;
                }
                if (grid[m][n] == 2){
                    queue.add(new int[]{m,n});
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                // check if neighbors are rotten + add to queue
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // check up
                if (row - 1 >= 0 && grid[row-1][col] == 1){
                    grid[row - 1][col] = 2;
                    fresh--;
                    queue.add(new int[]{row - 1, col});
                }

                // check down
                if (row + 1 < grid.length && grid[row+1][col] == 1){
                    grid[row + 1][col] = 2;
                    fresh--;
                    queue.add(new int[]{row + 1, col});
                }

                // check left
                if (col - 1 >= 0 && grid[row][col-1] == 1){
                    grid[row][col - 1] = 2;
                    fresh--;
                    queue.add(new int[]{row , col - 1});
                }


                // check right
                if (col + 1 < grid[0].length && grid[row][col+1] == 1){
                    grid[row][col + 1] = 2;
                    fresh--;
                    queue.add(new int[]{row , col + 1});
                }
            }
            // for each level of the queue, one minute has passed
            minutes++;

        }
        if (fresh == 0){
            return minutes;
        }
        return -1;
    }
}
