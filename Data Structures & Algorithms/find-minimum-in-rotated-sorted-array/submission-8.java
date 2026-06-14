class Solution {

    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {

        //in an ascending sorted array, left < mid < right
        //but if the array is rotated, then left < right does not hold.
        // if already sorted, leftmost is minimum
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        //both left and right pointing to the same index
        if (left == right) {
            return nums[left];
        }

        //get mid point
        int mid = left + (right - left) / 2;

        //we could also use - if (nums[mid] > nums[right])
        //we need the equal sign because for subarray of size 2 or size 1.
        //for example, nums = [2,5], both left and mid values are 2
        //another example, nums = [2], both left and mid values are 2
        if (nums[left] <= nums[mid]) {
            return binarySearch(nums, mid + 1, right);
        } else {
            return binarySearch(nums, left, mid);
        }
    }
}