class Solution {

    int[] dp;

    public int lengthOfLIS(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i));
        }

        return res;
    }

    public int dfs(int[] nums, int idx) {

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int res = 1;

        for (int i = idx + 1; i < nums.length; i++) {

            if (nums[i] > nums[idx]) {
                res = Math.max(res, 1 + dfs(nums, i));
            }
        }

        return dp[idx] = res;
    }
}