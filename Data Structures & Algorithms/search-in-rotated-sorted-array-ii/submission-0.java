//chatgpt solution but following my template
class Solution {
    public boolean search(int[] nums, int target) {

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public boolean binarySearch(int[] nums, int target, int start, int end) {

        //basic test case
        if (start > end) {
            return false;
        }

        //another basic test case
        if (start == end && nums[start] == target) {
            return true;
        }

        int mid = start + (end - start) / 2;

        //System.out.println("start- " + start + " end- " + end + " mid- " + mid);

        if (nums[mid] == target) {
            return true;
        }

        if (nums[start] == nums[mid]) {
            //cannot determine the sorted half because of duplicates,
            //so shrink the search space by one element
            return binarySearch(nums, target, start + 1, end);

        } else if (nums[start] <= nums[mid]) {
            //left subarray is sorted

            if (nums[start] <= target && target < nums[mid]) {
                //target in the left subarray
                return binarySearch(nums, target, start, mid - 1);
            } else {
                //target in the right subarray
                return binarySearch(nums, target, mid + 1, end);
            }

        } else {
            //right subarray is sorted

            if (nums[mid] < target && target <= nums[end]) {
                //target in the right subarray
                return binarySearch(nums, target, mid + 1, end);
            } else {
                //target in the left subarray
                return binarySearch(nums, target, start, mid - 1);
            }
        }
    }
}