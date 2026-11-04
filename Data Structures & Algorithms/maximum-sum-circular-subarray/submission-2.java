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

        return Math.max(maxSum, totalSum - minSum);
    }
}