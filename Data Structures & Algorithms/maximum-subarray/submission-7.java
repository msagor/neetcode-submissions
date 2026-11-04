//Kadane's Algorithm - https://www.youtube.com/watch?v=AHZpyENo7k4
//watched the video then implemented myself

//at every index, we have two choice - 
    //we can either continue this subarray
    //we can start a new subarray
//We keep a runningSum that cannot go below zero.
    //if it goes below zero, we set it to zero
    //after every iteration, we take the max between maxSum and runningSum


//i was putting line //here1 before the less than 0 check, it should be after.


//below is another implementation by Amran Haroon
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

            runningSum = runningSum + num;  //here1

            //we always test for a new max sum
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;

    }
}


/*

//we always keep the one larger between (runningSum + num, num)
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

*/
