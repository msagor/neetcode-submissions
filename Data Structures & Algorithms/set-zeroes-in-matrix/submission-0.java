class Solution {
    public void setZeroes(int[][] matrix) {

        //watched video but the video uses O(1) space I use two booleans O(2) space
        //get column and row count
        int rows = matrix.length;
        int cols = matrix[0].length;

        //we will use row 0 and column 0 to store metadata
        //we keep track of two variables that
        //will tell us whether to paint the row 0 and column 0
        //these variables needs to turn true once and never turns back to false
        boolean paint_row_0 = false;
        boolean paint_col_0 = false;

        //second iterate thru the matrix,
        //and turn all 0th rows and 0th columns to 0,
        //everytime we encounter a 0 

        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                int val = matrix[i][j];

                //check if the val is 0
                if(val==0){

                    //handle special row booleans
                    if(i==0){
                        //need to paint the 0th row
                        paint_row_0 = true;
                    }

                    //handle special column booleans
                    if(j==0){
                        //need to paint the 0th column
                        paint_col_0 = true;
                    }

                    //we need to turn 0th rows and 0th columns to 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //coming here means turning 0th rows and 0th columns to 0 is done
        //now we pass thru the matric again to make changes to rows and columns
        //we would normally pass thru the matrix from start to end
        //we need to go column-wise and row-wise separately

        //column-wise
        for(int i=1; i< cols; i++){
            if(matrix[0][i]==0){
                //need to paint the entire column to 0
                for(int j=1; j< rows; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        //row-wise
        for(int i=1; i< rows; i++){
            if(matrix[i][0]==0){
                //need to paint the entire row to 0
                for(int j=1; j< cols; j++){
                    matrix[i][j]=0;
                }
            }
        }

        
        //now handle the special case for 0th row and 0th collumn 
        if(paint_row_0){
            //need to paint 0th row
            for(int i=0; i< cols; i++){
                matrix[0][i] =0;
            }
        }

        if(paint_col_0){
            //need to paint 0th column
            for(int i=0; i< rows; i++){
                matrix[i][0] =0;
            }
        }
        

        
    }
}