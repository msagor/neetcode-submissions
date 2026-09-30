
//done myself..
//check code blocks marked as //here, pay attention to the indexing
class Solution {
    public void setZeroes(int[][] matrix) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        boolean r0 = false;
        boolean c0 = false;

        //first check if the first row has any zero
        for(int i=0;i<colCount; i++){
            if(matrix[0][i]==0){
                r0=true;
                break;
            }
        }

        //secone check if the first col has any zero
        for(int i=0;i<rowCount; i++){
            if(matrix[i][0]==0){
                c0=true;
                break;
            }
        }

        //third, check for all zeroes
        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                if(matrix[i][j]==0){
                    //mark the column of first row into zero
                    matrix[0][j] = 0;

                    //mark the row of the first column into zero
                    matrix[i][0] = 0;
                }
            }
        }

        //here
        //fourth, paint the matrix into zeroes in place row-wisw
        for(int i=1; i<colCount; i++){
            if(matrix[0][i]==0){
                for(int j=1; j<rowCount;j++){
                    matrix[j][i]=0;
                }
            }
        }

        //here
        //fifth, paint the matrix into zeroes in place col-wisw
        for(int i=1; i<rowCount; i++){
            if(matrix[i][0]==0){
                for(int j=1; j<colCount;j++){
                    matrix[i][j]=0;
                }
            }
        }

        //sixth, paint the r0 and c0
        if(r0){
            for(int i=0; i<colCount; i++){
                matrix[0][i]=0;
            }
        }

        if(c0){
            for(int i=0; i<rowCount; i++){
                matrix[i][0]=0;
            }
        }

    }
}
