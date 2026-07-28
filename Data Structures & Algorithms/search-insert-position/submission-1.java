
//implemented myself
class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }


    public int binarySearch(int[] nums, int start, int end, int target){
        
        //i put start == end, chatgpt fixed this
        if(start > end){
            return start;
        }

        //find the mid
        int mid = start + (end - start)/2;

        System.out.println("start- " + start + " end- " + end + " mid- " + mid);

        //check mid
        if(nums[mid]==target){
            return mid;
        }

        //check left
        if(target < nums[mid]){
            //the value is in the left subarray
            return binarySearch(nums, start, mid-1, target);
        }else{
            //the value is in the right subarray
            return binarySearch(nums, mid+1, end, target);
        }
    }
}