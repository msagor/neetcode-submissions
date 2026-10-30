

//from chatgpt, with my solution form part 1
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int sameCount = 1;
        int prev = nums[0];
        int idx = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != prev) {
                // Reset count for a new number
                sameCount = 1;

                nums[idx] = nums[i];
                idx++;

            } else {

                sameCount++;

                if (sameCount <= 2) {
                    nums[idx] = nums[i]; // here
                    idx++;
                }
            }

            prev = nums[i];

            System.out.println(Arrays.toString(nums));
        }

        return idx;
    }
}
