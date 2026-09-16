//Suman Bhunia

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        // Sort the numbers so that:
        // 1. combinations naturally stay sorted
        // 2. we can stop early when nums[i] > target
        Arrays.sort(nums);

        List<Integer> path = new ArrayList<>();

        // Start searching from index 0
        combination(nums, path, target, 0);

        return result;
    }

    void combination(int[] nums, List<Integer> path, int target, int start) {

        // We found a valid combination
        if (target == 0) {

            // Make a copy because path will continue changing
            result.add(new ArrayList<>(path));

            return;
        }

        // Start from "start", NOT from index 0 every time.
        //
        // This prevents duplicate permutations.
        //
        // Example:
        // If we picked nums[1],
        // we can pick nums[1], nums[2], nums[3]...
        // but we cannot go backward and pick nums[0].
        for (int i = start; i < nums.length; i++) {

            // Since nums is sorted,
            // if this number is already too large,
            // every number after it will also be too large
            if (nums[i] > target)
                break;

            // Choose nums[i]
            path.add(nums[i]);

            // We pass i instead of i + 1 because
            // the same number can be reused.
            //
            // Example:
            // target = 7
            // nums = [2,3,6,7]
            // [2,2,3] is allowed,
            // so after choosing 2 we must be allowed
            // to choose 2 again.
            combination(nums, path, target - nums[i], i);

            // Backtrack:
            // remove the number we just added
            path.remove(path.size() - 1);
        }
    }
}