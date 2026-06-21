class Solution {
    public boolean isValidSudoku(char[][] board) {

        int rowCount = board.length;
        int colCount = board[0].length;

        //create one map for rows
        Map<Integer, Set<Character>> rows = new HashMap<>();

        //create one map for columns
        Map<Integer, Set<Character>> cols = new HashMap<>();

        //create one map for big squares
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int i=0; i< rowCount; i++){
            for(int j=0; j< colCount; j++){

                if(board[i][j]=='.'){
                    continue;
                }

                //get the target val
                char val = board[i][j];

                //first check row
                //key is row index i
                //value is a list of vals
                Set<Character> r_val = rows.getOrDefault(i, new HashSet<>());
                if(r_val.contains(val)){
                   return false; 
                }else{
                    r_val.add(val);
                    rows.put(i, r_val);
                }

                //second check columns
                //key is columns index j
                //value is a list of vals
                Set<Character> c_val = cols.getOrDefault(j, new HashSet<>());
                if(c_val.contains(val)){
                   return false; 
                }else{
                    c_val.add(val);
                    cols.put(j, c_val);
                }

                //third check squares
                //get the index for row and column
                int idx = (int) Math.floor(i/3);
                int idy = (int) Math.floor(j/3);

                //make a unique key for this val
                String delimeter = "_";
                String key = /*Integer.toString(i) + 
                                delimeter + 
                                Integer.toString(j) + 
                                delimeter +//////*/
                                Integer.toString(idx) + 
                                delimeter + 
                                Integer.toString(idy);
                
                System.out.println("key - " + key);
                Set<Character> sq_set = squares.getOrDefault(key, new HashSet<>()); 
                if(sq_set.contains(val)){
                    return false;
                }else{
                    sq_set.add(val);
                    squares.put(key, sq_set);
                }
            }
        }

        return true;

    }
}
