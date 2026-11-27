//did not do this yself but the solution is very obvious
//solve isSubsetSum for sum/2
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        //if sum is odd then return false;
        if (sum % 2 != 0) {
            return false;
        }

        return isSubsetSum(nums, sum / 2);
    }

    static Boolean isSubsetSum(int arr[], int target) {
        Boolean[][] memo = new Boolean[arr.length][target + 1];

        return dfs(arr, 0, 0, target, memo);
    }

    private static boolean dfs(int[] arr, int index, int currSum,
                               int target, Boolean[][] memo) {

        if (currSum == target) {
            return true;
        }

        if (currSum > target || index == arr.length) {
            return false;
        }

        if (memo[index][currSum] != null) {
            return memo[index][currSum];
        }

        for (int i = index; i < arr.length; i++) {

            if (dfs(arr, i + 1, currSum + arr[i], target, memo)) {
                return memo[index][currSum] = true;
            }
        }

        return memo[index][currSum] = false;
    }

}
