
//implemented myself but had bugs that chatgpt fixed
//see //here
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, visited, i, j, word, "")){
                    return true;
                }
            }
        }
        
        return false;
    }


    public boolean dfs(char[][] board, boolean[][] visited, int r, int c, String word, String currStr){

        //out of bound
        if(r<0 || r>board.length-1 || c<0 || c >board[0].length-1){
           return false; 
        }
        
        //already visited
        if(visited[r][c]){
            return false;
        }
    
        //here - get the string for this iteration here, not in the loop below
        currStr = currStr + board[r][c];

        //here - i was missing this block
        if(!word.startsWith(currStr)){
            return false;
        }

        //check if match found
        if(word.equals(currStr)){
            return true;
        }

        visited[r][c] = true;

        if(
            dfs(board, visited, r-1, c, word, currStr) ||
            dfs(board, visited, r+1, c, word, currStr) ||
            dfs(board, visited, r, c-1, word, currStr) ||
            dfs(board, visited, r, c+1, word, currStr)
        ){
            return true;   
        }

        visited[r][c] = false;
        return false;
    
    }
}
