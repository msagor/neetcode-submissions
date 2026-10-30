//Kadane's Algorithm - https://www.youtube.com/watch?v=AHZpyENo7k4
//watched the video then implemented myself

//at every index, we have two choice - 
    //we can either continue this subarray
    //we can start a new subarray
//We keep a runningSum that cannot go below zero.
    //if it goes below zero, we set it to zero
    //after every iteration, we take the max between maxSum and runningSum

class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;

        int runningSum = 0;
        for(int num:nums){

            if(runningSum<0){
                runningSum = 0;
            }

            runningSum = runningSum + num;

            //we always test for a new max sum
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;

    }
}
