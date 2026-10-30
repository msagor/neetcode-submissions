//implemented myself but chatgpt had to fix a minor bug
//note that -connectedEdges already have each edge counted twice (eg: left to right and right to left)
//also, numOfBoxes also counts each adjacent edge twice.
//also, connected edge needs to be incremented even though we are not going to visit the neighbor box. 


class Solution {

    int connectedEdges = 0;
    int numOfBoxes = 0;

    public int islandPerimeter(int[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];

        //find the starting box with island
        boolean finished = false;
        for(int i=0; i<grid.length && !finished; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    dfs(grid, visited, i, j);
                    finished = true;
                    break;
                }
            }  
        }

        int perimeter = numOfBoxes * 4;
        int result = perimeter - (connectedEdges); 
        System.out.println("numOfBoxes - " + numOfBoxes);
        System.out.println("connectedEdges - " + connectedEdges);
        return result;
    }


    // DFS
    public void dfs(int[][] grid, int[][] visited, int i, int j){

        //mark this box as visited
        visited[i][j] = 1;

        //increment numOfBoxes for this box
        numOfBoxes++;

        //check up
        if(i>0 && grid[i-1][j]==1 /*&& visited[i-1][j]==0*/){
            connectedEdges++;
            if(visited[i-1][j]==0){
                dfs(grid, visited, i-1, j);
            }
        }

        //check down
        if(i<grid.length-1 && grid[i+1][j]==1){
            connectedEdges++;
            if(visited[i+1][j]==0){
                dfs(grid, visited, i+1, j);
            }
        }

        //check left
        if(j>0 && grid[i][j-1]==1){
            connectedEdges++;
            if(visited[i][j-1]==0){
                dfs(grid, visited, i, j-1);
            }
        }

        //check right
        if(j<grid[0].length-1 && grid[i][j+1]==1){
            connectedEdges++;
            if(visited[i][j+1]==0){
                dfs(grid, visited, i, j+1);
            }
        }
    }
}