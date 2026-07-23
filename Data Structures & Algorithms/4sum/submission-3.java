//solution from chatgpt
class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        //must sort array to use two pointer technique
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                long newTarget = (long) target - nums[i] - nums[j];

                List<int[]> pairs = twoSum(nums, j + 1, newTarget);

                for (int[] pair : pairs) {
                    result.add(Arrays.asList(
                        nums[i],
                        nums[j],
                        nums[pair[0]],
                        nums[pair[1]]
                    ));
                }
            }
        }

        return result;
    }

    //using two pointer technique for twoSum
    //two pointer technique requires a sorted array
    private List<int[]> twoSum(int[] nums, int start, long target) {
        List<int[]> pairs = new ArrayList<>();

        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            long sum = (long) nums[left] + nums[right];

            if (sum == target) {
                pairs.add(new int[]{left, right});

                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }
}