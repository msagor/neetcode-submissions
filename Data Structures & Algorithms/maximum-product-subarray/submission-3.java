//must do Maximum Subarray before this - https://neetcode.io/problems/maximum-subarray/question?list=neetcode250

class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = nums[0], curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            //Flip min and max
            if (num < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(num, curMax * num);
            curMin = Math.min(num, curMin * num);

            res = Math.max(res, curMax);
        }

        return res;
    }
}