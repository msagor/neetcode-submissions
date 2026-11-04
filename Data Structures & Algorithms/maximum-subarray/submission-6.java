class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];

        int runningSum = nums[0];
        for(int i=1; i<nums.length; i++){

            int num = nums[i];

            runningSum = Math.max(runningSum + num, num);

            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;
    }
}
