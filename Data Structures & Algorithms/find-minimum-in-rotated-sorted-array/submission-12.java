class Solution {

    public int findMin(int[] nums) {

        //since the array is sorted but rotated, the left most value is no longer the smallest value,
        //the smallest value is somewhere in the middle of the array.
        //example: [1,2,3,4,5,6], if i rotate three times then i get [4,5,6,1,2,3],
        //notice how the smallest value 1 is now in the middle of the array, not at the beginning,
        //also notice, for a regular sorted array, nums[left] < nums[mid] < nums[right] holds,
        //but for a rotated sorted array, this equation is disrupted somewhere in the array.
        //for our example: if 6 is mid, 5 is smaller than 6, so the left sub-array [4,5,6] is good.
        //but 6 is not smaller than 1, so the nums[mid] < nums[right] condition fails.
        //then we immediately know that the disruption is in the right sub-array.
        return binarySearch(nums, 0, nums.length-1);
    }


    public int binarySearch(int[] nums, int left, int right){

        //naive case when the array is already sorted
        //in an ascending sorted array, left < mid < right
        //but if the array is rotated, then left < right does not hold.
        // if already sorted, leftmost is minimum
        if(nums[left] < nums[right]){
            return nums[left];
        }

        //non-naive case - the last iteration in binary search
        //when left and right pointing the same index
        if (left == right) {
            return nums[left];
        }

        //business login of binary search
        int mid = left + (right - left)/2;

        //check for mid,
        //aka check if nums[left] < nums[mid]
        //is that case, the left portion is good
        if(nums[left] <= nums[mid]){
            return binarySearch(nums, mid+1, right);
        }else{
            return binarySearch(nums, left, mid);
        }
    }
}
