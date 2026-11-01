//implemented myself after watching the solution
//we run over the queue size every time to run thru diagonal entries
class Solution {

    Queue<int[]> q = new LinkedList<>();

    int[][] directions = {{ -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }};
    
    int ROW = -1;
    int COL = -1;

    public int orangesRotting(int[][] grid) {

        int steps = 0;
        int fresh = 0;

        ROW = grid.length;
        COL = grid[0].length;

        //first find all the slots banana is rotten
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                //count all fresh
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if(grid[i][j]==2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        //run thru the queue and add neightbors
        while(fresh>0 && !q.isEmpty()){

            int q_length = q.size();

            for(int i=0; i<q_length; i++){
                //poll from queue
                int[] item = q.poll();

                //get this items r and c
                int rr = item[0];
                int cc = item[1];

                //explore four directions
                for(int[] dir: directions){
                    int rrr = rr + dir[0];
                    int ccc = cc + dir [1];


                    //check if this neighbor indexes ia valid
                    if(rrr>=0 && ccc>=0 && rrr<ROW && ccc<COL && grid[rrr][ccc]==1){

                        //mark this neighbor rotten
                        grid[rrr][ccc]=2;

                        //add this neighbor to queue
                        q.offer(new int[]{rrr, ccc});

                        fresh--;
                    }
                }
            }
    
            steps++;

        }

        return fresh == 0 ? steps : -1;
    }
}
