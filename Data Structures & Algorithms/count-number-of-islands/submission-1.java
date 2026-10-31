class Solution {

    int numOfBoxes = 0;

    public int numIslands(char[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(grid, visited, i, j);
                    numOfBoxes++;
                }
            }  
        }

        return numOfBoxes;
    }


    public void dfs(char[][] grid, int[][] visited, int i, int j){

        //mark this box as visited
        visited[i][j] = 1;

        //check up
        if(i>0 && grid[i-1][j]=='1' && visited[i-1][j]==0){
            dfs(grid, visited, i-1, j);

        }

        //check down
        if(i<grid.length-1 && grid[i+1][j]=='1' && visited[i+1][j]==0){
            dfs(grid, visited, i+1, j);
        }

        //check left
        if(j>0 && grid[i][j-1]=='1' && visited[i][j-1]==0){
            dfs(grid, visited, i, j-1);
        }

        //check right
        if(j<grid[0].length-1 && grid[i][j+1]=='1' && visited[i][j+1]==0){
            dfs(grid, visited, i, j+1);
        }
    }
}