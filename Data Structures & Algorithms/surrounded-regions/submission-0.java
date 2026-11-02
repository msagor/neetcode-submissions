class Solution {

    int ROW = -1;
    int COL = -1;

    List<int[]> borderZeros = new ArrayList<>();

    int[][] directions = {{-1,0},{1,-0},{-0,1},{0,-1}};

    public void solve(char[][] board) {
        
        ROW = board.length;
        COL = board[0].length;

        //first, get all indexes around border which are 0
        for(int r=0; r<ROW; r++){
            if(board[r][0]=='O'){
                borderZeros.add(new int[]{r, 0});
            }
            if(board[r][COL-1]=='O'){
                borderZeros.add(new int[]{r, COL-1});
            }
        }
        for(int c=0; c<COL; c++){
            if(board[0][c]=='O'){
                borderZeros.add(new int[]{0, c});
            }
            if(board[ROW-1][c]=='O'){
                borderZeros.add(new int[]{ROW-1, c});
            }
        }

        //second, starting from borderZeros indexes, 
        //we run dfs and turn any adjacent 0 into T
        for(int[] idx: borderZeros){
            dfs(board, idx[0], idx[1]);
        }

        // third, mark all remaining O's into X
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        // fourth, mark all T's back into O
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    public void dfs(char[][] board, int r, int c){
        
        //index check
        if(r<0 || c<0 || r>=ROW || c>=COL){
            return;
        }

        //check for this slot being 0
        if(board[r][c]!='O'){
            return;
        }

        //mark this slot into T
        board[r][c] = 'T';

        //dfs neighbors
        for(int[] dirs: directions){
            int rr = r + dirs[0];
            int cc = c + dirs[1];
            dfs(board, rr, cc);
        }
    }
}
