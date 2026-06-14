class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return isTargetExistsInArray(matrix, target, 0, matrix.length-1);
    }

    /*public boolean isTargetExistsInArray(int[][] matrix, int target, int left, int right){
        
        //check it the left and right pointing to the same array
        if(left==right){
            int[] candidate = matrix[left];
            for(int i=0; i< candidate.length; i++){
                if(candidate[i]==target){
                    return true;
                }
            }
            return false;
        }

        //find mid
        int mid = left + (right - left)/2;
        int mid_len = matrix[mid].length;

        //find mid_previous
        //guard against when mid is 0, then mid_previous is also 0
        int mid_previous = (mid==0?0:mid-1);
        int mid_previous_len = matrix[mid_previous].length;

        //coming here means mid is not at index 0
        //check if matrix[mid_previous][first_value] <= target and target <= matrix[mid][first_value]
        if(matrix[mid][0] <= target && target <= matrix[mid][mid_len-1]){
            int[] candidate = matrix[mid];
            for(int i=0; i< candidate.length; i++){
                if(candidate[i]==target){
                    return true;
                }
            }
            return false;
        }else if(matrix[mid_previous][0] <= target && target <= matrix[mid_previous][mid_previous_len-1]){
            //we found target must be in the left side of the 2D matrix
            return isTargetExistsInArray(matrix, target, left, mid==0?0:mid+1);
        }else{
            //target not found in the left portion of the array so it may be in the right portion
            return isTargetExistsInArray(matrix, target, mid+1, right);
        }
    }
    */

    public boolean isTargetExistsInArray(int[][] matrix, int target, int left, int right) {

        if (left > right) return false;

        if (left == right) {
            int[] midRow = matrix[left];
            for (int val : midRow) {
                if (val == target) return true;
            }
            return false;
        }

        int mid = left + (right - left) / 2;
        int[] midRow = matrix[mid];

        if (midRow[0] <= target && target <= midRow[midRow.length - 1]) {
            // target must be in this midRow
            for (int val : midRow) {
                if (val == target) return true;
            }
            return false;
        } else if (target < midRow[0]) {
            return isTargetExistsInArray(matrix, target, left, mid - 1);
        } else {
            return isTargetExistsInArray(matrix, target, mid + 1, right);
        }
    }

}
