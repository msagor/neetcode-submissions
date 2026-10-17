class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (nums == null || nums.length < k) {
            return false;
        }

        Arrays.sort(nums);

        // Reverse to descending order
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        int total = 0;

        for (int n : nums) {
            total += n;
        }

        // Check if total is divisible by k
        if (total % k != 0) {
            return false;
        }

        // Get the theoretical sum of each subset
        int target = total / k;

        // Check if the largest number exceeds the target
        if (nums[0] > target) {
            return false;
        }


        boolean[] visited = new boolean[nums.length];
        int[] bucket = new int[k];

        return backtrack(nums, bucket, 0, target, visited, k);
    }

    public boolean backtrack(int[] nums, int[] bucket, int bucketIndex, int target, boolean[] visited, int k) {

        //if last bucket full then all prev buckets also full 
        if (bucket[0] == target && bucket[k-1] == target) {
            return true;
        }

        //coming here means this is not the last bucket
        //check if current bucket is full, move to the next bucket
        if (bucket[bucketIndex] == target) {
            return backtrack(nums, bucket, bucketIndex + 1, target, visited, k);
        }

        
        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            // Skip duplicate numbers //here
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            // Don't exceed the target
            if (bucket[bucketIndex] + nums[i] > target) {
                continue;
            }

            bucket[bucketIndex] += nums[i];
            visited[i] = true;

            if (backtrack(nums, bucket, bucketIndex,
                          target, visited, k)) {
                return true;
            }

            // Backtrack
            bucket[bucketIndex] -= nums[i];
            visited[i] = false;
        }

        return false;
    }
}