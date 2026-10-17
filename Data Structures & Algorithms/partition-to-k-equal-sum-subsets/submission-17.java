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

        //if first and last bucket full then all buckets are full 
        if (bucket[0] == target && bucket[k-1] == target) {
            return true;
        }

        //bucket index check
        if (bucketIndex > bucket.length-1) {
            return false;
        }

        //check if bucket overflows already
        if (bucket[bucketIndex]> target) {
            return false;
        }

        //if this bucket full increment bucket
        if (bucket[bucketIndex] == target) {
            bucketIndex++;
        }

        
        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            bucket[bucketIndex] += nums[i];
            visited[i] = true;

            if (backtrack(nums, bucket, bucketIndex, target, visited, k)) {
                return true;
            }

            // Backtrack
            bucket[bucketIndex] -= nums[i];
            visited[i] = false;
        }

        return false;
    }
}