//solution from chatgpt
//in a circular array - there can be two types of max subarray
    //straight or circular
    //so we need to compute both and return the highest
//1. compute straight max subarray - 
    //a.same as Maximum Subarray problem
//2. compute circular max subarray - 
    //a. compute total
    //b. compute min subarray
    //c. compute total - min subarray
//on edge case - 
    //if max subarray is negative, means all numbers are negative 
    //if even one value would be a positive number, max subarray would be that number
    //if that is the case then - 
        //a. max subarray - largest negative number
        //b. min subarray - smallest negative number
        //c. total = a very negative number
    //so if all numbers are negative, we return the max subarray

class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = nums[0];

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            totalSum += num;

            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }

        // All numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        int curcularMaxSubarray = totalSum - minSum;
        return Math.max(maxSum, curcularMaxSubarray);
    }
}