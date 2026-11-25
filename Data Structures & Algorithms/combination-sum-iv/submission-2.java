
class Solution {
    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);

        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int currSum) {
        if (currSum == target) {
            return 1;
        }

        if (currSum > target) {
            return 0;
        }

        if (memo[currSum] != -1) {
            return memo[currSum];
        }

        int count = 0;

        for (int num : nums) {
            count += dfs(nums, target, currSum + num);
        }

        memo[currSum] = count; // Cache result
        return count;
    }
}
