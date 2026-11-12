import java.util.Arrays;

class Solution {

    int ROW = -1;
    int COL = -1;
    int[][] memo;

    public int uniquePaths(int m, int n) {

        ROW = m;
        COL = n;

        //create a 2d grid
        int[][] grid = new int[ROW][COL];

        //create memo
        memo = new int[ROW][COL];

        //initialize memo with -1
        for(int i = 0; i < ROW; i++){
            Arrays.fill(memo[i], -1);
        }

        //run dfs
        return backtrack(0, 0, grid);
    }


    public int backtrack(int r, int c, int[][] grid){

        //out of boundary check
        if(r < 0 || c < 0 || r >= ROW || c >= COL){
            return 0;
        }

        //reached end check
        if(r == ROW - 1 && c == COL - 1){
            return 1;
        }

        //memo check
        if(memo[r][c] != -1){
            return memo[r][c];
        }

        //recursive dfs
        int down = backtrack(r + 1, c, grid);
        int right = backtrack(r, c + 1, grid);

        //store result
        memo[r][c] = down + right;

        return memo[r][c];
    }
}
