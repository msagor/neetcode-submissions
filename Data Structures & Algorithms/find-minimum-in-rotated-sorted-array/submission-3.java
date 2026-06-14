class Solution {

    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {

        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[right]) {
            return binarySearch(nums, mid + 1, right);
        } else {
            return binarySearch(nums, left, mid);
        }
    }
}