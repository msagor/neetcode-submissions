//from leetcode
class Solution {

    int result = 0;
    int ROW =-1;
    int COL = -1;

    public int uniquePathsIII(int[][] grid) {
        
        ROW = grid.length;
        COL = grid[0].length;

        //first, count the number of walls
        int r = -1;
        int c = -1;
        int wallCount = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                //find starters
                if(grid[i][j]==1){
                    r = i;
                    c = j;
                }

                //find walls
                if(grid[i][j]==-1){
                    wallCount++;
                }
            }
        }

        //second, run dfs
        backtrack(r, c, grid, wallCount, 0);

        return result;
    }


    public void backtrack(int r, int c, int[][] grid, int wallCount, int emptyCount){
        //out of boundary check
        if(r<0 || c <0 || r>=ROW || c>=COL){
            return;
        }

        //wall check
        if(grid[r][c]==-1){
            return;
        }

        //visited check
        if(grid[r][c]==3){
            return;
        }

        //reached end check
        if(grid[r][c]==2){
            //wallcount and emptyCount check
            if(emptyCount == (ROW*COL) - wallCount - 1){
                result++;
            }
            return;
        }

        //increment emptyCount for this slot
        emptyCount++;

        //mark this slot as visited
        //we turn visited into walls
        int temp = grid[r][c];
        grid[r][c] = -1;

        //recursive backtrack
        backtrack(r-1, c, grid, wallCount, emptyCount); //up
        backtrack(r+1, c, grid, wallCount, emptyCount); //down
        backtrack(r, c-1, grid, wallCount, emptyCount); //left
        backtrack(r, c+1, grid, wallCount, emptyCount); //right

        //backtrack
        grid[r][c] = temp;
    }
}
