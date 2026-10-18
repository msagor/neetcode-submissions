class Solution {
    public void rotate(int[] nums, int k) {
        for(int i=0; i< k; i++){
            int rightMostVal = nums[nums.length-1];
            int prevVal = nums[0];
            for(int j=0; j< nums.length-1; j++){
                int j_plus_1 =  nums[j+1];
                nums[j+1] = prevVal;
                prevVal = j_plus_1;
            }
            nums[0] = rightMostVal;
        }
    }
}