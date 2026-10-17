//entirely implemented myself the backtracking part
//took some help for the helper functions.
class Solution {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        backtrack(n, 0, board, 0, path);
        return res;
    }

    public void backtrack(int n, int queenIndex, int[][] board, int r, List<String> path){

        //all buckets full
        if(queenIndex==n){
            res.add(new ArrayList<>(path));
            return;
        }

        //row index overflow check
        if(r>n-1){
            return;
        }

        //test each column of a row via backtrack
        for(int i=r, j=0; j<n; j++){

            //check if we can place this queen
            if(canPlaceQueen_v3(i, j, n, board)){

                //mark board true
                board[i][j] = 1;

                //add to path
                String s = getRowWithQueenPlaced(i, n, board);
                path.add(s);

                //backtrack
                backtrack(n, queenIndex+1, board, i+1, path);

                //remove from path
                path.removeLast();

                //mark board false
                board[i][j] = 0;
            }else{
                continue;
            }
        }
    
    }

    public String getRowWithQueenPlaced(int r, int n, int[][] board){
        String s = "";
        for(int i=r, j=0; j<n; j++){
            s = s + (board[i][j]==0?".":"Q");
        }
        return s;
    }

    //version 1
    //this check all 360 degrees
    //but we dont need to check all directions,
    //since we are coming from upper-left to lower-right,
    //we only need to check - up, left, up-left, up-right,
    //we can even skip the left check, since left checking checks current row.
    public boolean canPlaceQueen_v1(int r, int c, int n, int[][] board){
        //from left to right check 
        for(int j=0; j<n; j++){
            if(board[r][j]==1){
                return false;
            }
        }

        //from up to down check
        for(int i=0; i<n; i++){
            if(board[i][c]==1){
                return false;
            }
        }

        //from elem to up-right check
        for(int i=r,j=c; i>=0 && j<n; i--, j++){
            if(board[i][j]==1){
                return false;
            }
        }

        //from elem to down-left check
        for(int i=r,j=c; i<n && j>=0; i++, j--){
            if(board[i][j]==1){
                return false;
            }
        }

        //from elem to up-left check
        for(int i=r,j=c; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }

        //from elem to down-right check
        for(int i=r,j=c; i<n && j<n; i++, j++){
            if(board[i][j]==1){
                return false;
            }
        }
        

        return true;
    }

    //version 2
    //this only checks - up, up-left, up-right,
    //head the bottom how ot write this kind of checks in a 2D array
    public boolean canPlaceQueen_v2(int r, int c, int n, int[][] board){

        //from elem to up check
        for(int i=r;i>=0;i--){
            if(board[i][c]==1){
                return false;
            }
        }

        //from elem to up-left check
        for(int i=r,j=c; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }

        //from elem to up-right check
        for(int i=r,j=c; i>=0 && j<n; i--, j++){
            if(board[i][j]==1){
                return false;
            }
        }

        return true;
    }

    //version 3
    //this only checks - up, up-left, up-right,
    //but excludes the val at i, j itself
    public boolean canPlaceQueen_v3(int r, int c, int n, int[][] board){

        //from elem to up check
        for(int i=r-1;i>=0;i--){
            if(board[i][c]==1){
                return false;
            }
        }

        //from elem to up-left check
        for(int i=r-1,j=c-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }

        //from elem to up-right check
        for(int i=r-1,j=c+1; i>=0 && j<n; i--, j++){
            if(board[i][j]==1){
                return false;
            }
        }

        return true;
    }
}



//you need to understand the direction we are going.
//suppose we are going from down-left to up-right,
//that means, value of row (i) is decreasing and column (j) is increasing.
//so we will have i-- and j++ in our for loop.
//whenever we have i--, the conditional will be i>=0,
//whenever we have j++, the conditional will be j<n.

