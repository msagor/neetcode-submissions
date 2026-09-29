
//watched video soltion then implemented myself.
//we need to go from left to right and keep computing max upto that point.
//for any input nums = [1, 2, 3, 4] we compure runningMax
//here is runningMax = [1, 2, 4, 4] so 4 is the answer.
//this is DP bottom-up approach
//anogther implementation at the bottom
class Solution {
    public int rob(int[] nums) {

        int[] runningMax = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            //special trreatment for the first value
            if(i==0){
                runningMax[i] = nums[i];
            }else if(i==1){
                runningMax[i] = Math.max(runningMax[i-1], nums[i]);
            }else{
                int newMax = Math.max(runningMax[i-1], (runningMax[i-2] + nums[i])); //see example above
                runningMax[i] = newMax;
            }
        }

        return runningMax[runningMax.length-1];
    }
}


/*
    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i=2; i< nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }

        return dp[dp.length-1];
    }
*/