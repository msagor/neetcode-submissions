//from LeetCode
//using memo to avoid TLE
//note that we changed backtrack fu ction from void to int
class Solution {

    int ROW = -1;
    int COL = -1;
    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        ROW = obstacleGrid.length;
        COL = obstacleGrid[0].length;

        memo = new int[ROW][COL];

        //initialize memo with -1
        for(int i=0; i<ROW; i++){
            Arrays.fill(memo[i], -1);
        }

        //check starting or ending cell
        if(obstacleGrid[0][0] == 1 || obstacleGrid[ROW-1][COL-1] == 1){
            return 0;
        }

        //run dfs
        return backtrack(0, 0, obstacleGrid);
    }


    public int backtrack(int r, int c, int[][] grid){

        //out of boundary check
        if(r<0 || c<0 || r>=ROW || c>=COL){
            return 0;
        }

        //wall check
        if(grid[r][c] == 1){
            return 0;
        }

        //reached end check
        if(r == ROW-1 && c == COL-1){
            return 1;
        }

        //memo check
        if(memo[r][c] != -1){
            return memo[r][c];
        }

        //recursive dfs
        int down = backtrack(r+1, c, grid);
        int right = backtrack(r, c+1, grid);

        //store result
        memo[r][c] = down + right;

        return memo[r][c];
    }
}
