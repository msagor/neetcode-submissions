
//watched video soltion then implemented myself.
//we need to go from left to right and keep computing max upto that point.
//for any input nums = [1, 2, 3, 4] we compure runningMax
//here is runningMax = [1, 2, 4, 4] so 4 is the answer.
//this is DP bottom-up approach
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
