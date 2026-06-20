class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {

        //both left and right pointing to the same index
        if (left == right) {
            //check target found
            if(target == nums[left]){
                return left;
            }else{
                return -1;
            }
        }

        //get mid point
        int mid = left + (right - left) / 2;

        //mid check
        if(target==nums[mid]){
            return mid;
        }

        //we need the equal sign because for subarray of size 2 or size 1.
        //for example, nums = [2,5], both left and mid values are 2
        //another example, nums = [2], both left and mid values are 2
        if (nums[left] <= nums[mid]) {
            //left part is sorted
            //check if target is in left part
            if(nums[left] <= target && target <= nums[mid]){
                //we found the left sorted part where target is
                //do a regular binary search here
                return binarySearch(nums, left, mid, target);
            }else{
                //target not in the left sorted part
                //so we pass right unsorted part in the recursion
                return binarySearch(nums, mid + 1, right, target);
            }
        } else {
            //the right portion is sorted
            //check if target is in right part
            if(nums[mid] <= target && target <= nums[right]){
                //we found the right sorted part where target is
                //do a regular binary search here
                return binarySearch(nums, mid + 1, right, target);
            }else{
                //target not in the right sorted part
                //so we pass left unsorted part in the recursion
                return binarySearch(nums, left, mid, target);
            }
        }
    }
}
