class NumMatrix {

    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int one_p1 = row1;
        int one_p2 = col1;

        int two_p1 = row1;
        int two_p2 = col2;

        int three_p1 = row2;
        int three_p2 = col1;

        int four_p1 = row2;
        int four_p2 = col2;

        
        int total = 0;
        for(int i=row1; i<=row2;i++){
            for(int j=col1;j<=col2; j++){
                total = total + matrix[i][j];
            }
        }
        
        return total;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */