class Solution {
    class Tuple{
        int i,j = -1;
        Tuple(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int numIslands(char[][] grid) {
        

        //we need to traverse thru each cell in the grid and check if this is 1,
        //if 1, then we sink it(turn it into 0) and keep checking neighbors for 1,
        //we keep sinking these slots using BFS until we hit all neighbors are 0,
        //that would be one island.
        //we keep running this algorithm for each slots in the grid.

        //basic check
        if(grid.length==0){
            return 0;
        }

        int islands = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int i=0; i< ROWS; i++){
            for(int j=0; j<COLS; j++){

                if(grid[i][j]== '1'){

                    //run BFS
                    BFS(grid, i, j, ROWS, COLS);

                    //each time we come out of the BFS
                    //means we done searching one island
                    islands++;
                }
            }
        }

        return islands;
    }


    public void BFS(char[][] grid, int row, int col, int ROWS, int COLS){

        //we need a FIFO queue that will keep track of all [row,col] pairs that we have visited
        Queue<Tuple> queue = new LinkedList<>();

        //add this item in the queue as a tuple
        queue.add(new Tuple(row, col));

        //the queue now has the first slot of this island
        while(!queue.isEmpty()){

            //pop from the queue
            Tuple current = queue.poll();

            //reuse row and col variables
            row = current.i;
            col = current.j;

            //we need to visit neighbors of current node
            //we check left, right, up, down

            //down check
            //column stays fixed, row goes plus 1
            if((row+1)<ROWS && grid[row+1][col]=='1'){
                //down neighbor slow it 1 as well so push in queue
                queue.add(new Tuple(row+1, col));
                
                //sink the neighbor aka turn the neighbor slot into 0
                //note that, this neighbor will be in the queue,
                //and when we first process this neighbor we will sink this same slot again.
                grid[row+1][col] = '0';
            }

            //up check
            //column stays fixed, row goes minus 1
            if((row-1)>=0 && grid[row-1][col]=='1'){
                //up neighbor slow it 1 as well so push in queue
                queue.add(new Tuple(row-1, col));
                
                grid[row-1][col] = '0';
            }

            //left check
            //row stays fixed, column goes minus 1
            if((col-1)>=0 && grid[row][col-1]=='1'){
                //left neighbor slow it 1 as well so push in queue
                queue.add(new Tuple(row, col-1));
                
                grid[row][col-1] = '0';
            }

            //right check
            //row stays fixed, column goes plus 1
            if((col+1)<COLS && grid[row][col+1]=='1'){
                //right neighbor slow it 1 as well so push in queue
                queue.add(new Tuple(row, col+1));
                
                grid[row][col+1] = '0';
            }
        }
    }
}
