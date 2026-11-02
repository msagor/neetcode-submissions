//entirely implemented myself after getting the hint from Suman Bhunia
class Solution {

    int ROW = -1;
    int COL = -1;

    List<List<Integer>> result = new ArrayList<>();

    int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;

        //make two visited array
        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];


        //run dfs from pacific edge
        //0th row, all columns
        //4,2,7,3,4
        for(int c=0; c<COL; c++){
            dfs(heights, pacific, 0, c, -1);
        }

        //all rows, 0th column
        //4,7,6
        for(int r=0; r<ROW; r++){
            dfs(heights, pacific, r, 0, -1);
        }

        //run dfs from atlantic edge
        //all rows, last column
        //4,7,6
        for(int r=0; r<ROW; r++){
            dfs(heights, atlantic, r, COL-1, -1);
        }

        //last row, all columns
        //6,3,5,3,6
        for(int c=0; c<COL; c++){
            dfs(heights, atlantic, ROW-1, c, -1);
        }

        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    result.add(res);
                }
            }
        }

        return result;
    }


    public void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight){

        //index check
        if(r<0 || c<0 || r>=ROW || c>= COL){
            return;
        }

        //already visited check
        if(visited[r][c]){
            return;
        }

        //island height check
        //note that we are not checking if water can from this island to next island.
        //we are check if water can flow from next island to this island.
        //ex: when dfs from (0,0) at value 4, when we test neighbor 7 at (1,0),
        //we are not testing if water flows from 4 ot 7, instead the opposite.
        if(heights[r][c]>=prevHeight){
            //this island is valid so mark visited
            visited[r][c] = true;

            //get new prevHeight
            prevHeight = heights[r][c];

            //we do dfs for its neighbors
            for(int[] dirs: directions){
                int rr = r + dirs[0];
                int cc = c + dirs[1];

                dfs(heights, visited, rr, cc, prevHeight);
            }

        }
    }
}
