
//solution from chatgpt, written in my style
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        // Current boundaries of the unvisited rectangle
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        String direction = "RIGHT";

        while (top <= bottom && left <= right) {

            if (direction.equals("RIGHT")) {

                // Traverse the current top row
                for (int c = left; c <= right; c++) {
                    res.add(matrix[top][c]);
                }

                // Entire top row has been visited,
                // so move the top boundary down.
                top++;

                // Next direction is DOWN.
                direction = "DOWN";
            }

            if (direction.equals("DOWN")) {

                // Traverse the current right column.
                for (int r = top; r <= bottom; r++) {
                    res.add(matrix[r][right]);
                }

                // Entire right column has been visited,
                // so move the right boundary left.
                right--;

                // Next direction is LEFT.
                direction = "LEFT";
            }

            if (direction.equals("LEFT")) {

                // It is possible that there are no rows left.
                if (top <= bottom) {

                    // Traverse the current bottom row.
                    for (int c = right; c >= left; c--) {
                        res.add(matrix[bottom][c]);
                    }

                    // Entire bottom row has been visited,
                    // so move the bottom boundary up.
                    bottom--;
                }

                // Next direction is UP.
                direction = "UP";
            }

            if (direction.equals("UP")) {

                // It is possible that there are no columns left.
                if (left <= right) {

                    // Traverse the current left column.
                    for (int r = bottom; r >= top; r--) {
                        res.add(matrix[r][left]);
                    }

                    // Entire left column has been visited,
                    // so move the left boundary right.
                    left++;
                }

                // Next direction is RIGHT.
                direction = "RIGHT";
            }
        }

        return res;
    }
}



/*
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        String direction = "RIGHT";
        int r = 0;
        int c = 0;
        while(ROWS>0 && COLS>0){
            if(direction.equals("RIGHT")){
                while(c<COLS){
                    res.add(matrix[r][c]);
                    c++;
                }

                //coming here means we hit the right wall
                //now we need to go down so we change direction
                direction = "DOWN";
                
                //since we visited an entire row worth of data,
                //we need to reduce ROWS
                ROWS--;
                
                //also current c is overflown (c==COLS) so we reduce c
                c--;

                //also current r has already been visited so we increment r
                r++;
            }

            if(direction.equals("DOWN")){
                while(r<ROWS){
                   res.add(matrix[r][c]);
                   r++; 
                }

                //coming here means we hit the down wall
                //now we need to go left so we change direction
                direction = "LEFT";

                //since we visited an entire column worth of data,
                //we need to reduce COLS
                COLS--;

                //also current r is overflown (r==ROWS) so we reduce r
                r--;

                 //also current c has already been visited so we decrement c
                c--;
            }

            if(direction.equals("LEFT")){
                while(c>=0){
                    res.add(matrix[r][c]);
                    c--;
                }

                //coming here means we hit the left wall
                //now we need to go up so we change direction
                direction = "UP";
                
                //since we visited an entire row worth of data,
                //we need to reduce ROWS
                ROWS--;
                
                //also current c is overflown (c==COLS) so we reduce c
                c--;

                //also current r has already been visited so we decrement r
                r--;
            }


            if(direction.equals("UP")){
                while(r>=0){
                   res.add(matrix[r][c]);
                   r--; 
                }

                //coming here means we hit the up wall
                //now we need to go right so we change direction
                direction = "RIGHT";

                //since we visited an entire column worth of data,
                //we need to reduce COLS
                COLS--;

                //also current r is overflown (r==ROWS) so we reduce r
                r--;

                 //also current c has already been visited so we decrement c
                c--;
            }
        }

        return res;
    }
}
*/
