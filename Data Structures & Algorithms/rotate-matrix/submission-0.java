class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Reverse the matrix vertically
        // First row <-> last row, second row <-> second-last row, etc.
        int top = 0;
        int bottom = n - 1;

        while (top < bottom) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;

            top++;
            bottom--;
        }

        // Step 2: Transpose the matrix
        // Swap matrix[i][j] with matrix[j][i].
        // We only go through the upper triangle to avoid
        // swapping each pair twice.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}