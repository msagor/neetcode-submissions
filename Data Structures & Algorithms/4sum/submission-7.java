//solution from chatgpt
class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Must sort array to use the two-pointer technique
        Arrays.sort(nums);

        // Stores all unique quadruplets
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        // First number
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate values for the first number
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second number
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate values for the second number
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Calculate remaining target needed from the two remaining numbers
                // Use long to avoid integer overflow
                long newTarget = (long) target - nums[i] - nums[j];

                // Find all pairs after index j that sum to newTarget
                List<List<Integer>> pairs = twoSum(nums, j + 1, newTarget);

                // Add each pair together with nums[i] and nums[j]
                for (List<Integer> pair : pairs) {

                    List<Integer> quadruplet = new ArrayList<>();

                    // Add first fixed number
                    quadruplet.add(nums[i]);

                    // Add second fixed number
                    quadruplet.add(nums[j]);

                    // Add the two numbers returned by twoSum
                    quadruplet.add(pair.get(0));
                    quadruplet.add(pair.get(1));

                    // Store the complete quadruplet
                    result.add(quadruplet);
                }
            }
        }

        return result;
    }

    //two pointer based twoSum solution which returns all possible pairs, not just one.
    //using two pointer technique for twoSum
    //two pointer technique requires a sorted array
    private List<List<Integer>> twoSum(int[] nums, int start, long target) {

        // Stores all unique pairs of values that add up to the target
        List<List<Integer>> pairs = new ArrayList<>();

        // Left pointer starts from the given index
        // (because indexes before start are already used by 4Sum)
        int left = start;

        // Right pointer starts from the end of the array
        int right = nums.length - 1;

        // Search while the two pointers have not crossed
        while (left < right) {

            // Calculate current pair sum
            // Cast to long to avoid integer overflow for large values
            long sum = (long) nums[left] + nums[right];

            // Found a valid pair
            if (sum == target) {

                // Store the pair values as a List<Integer>
                pairs.add(Arrays.asList(nums[left], nums[right]));

                // Move both pointers to continue searching for other pairs
                left++;
                right--;

                // Skip duplicate values on the left side
                // Prevents returning duplicate pairs
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

                // Skip duplicate values on the right side
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

            }

            // Current sum is smaller than target
            // Move left pointer right to increase the sum
            else if (sum < target) {
                left++;
            }

            // Current sum is larger than target
            // Move right pointer left to decrease the sum
            else {
                right--;
            }
        }

        // Return all unique pairs found
        return pairs;
    }
}