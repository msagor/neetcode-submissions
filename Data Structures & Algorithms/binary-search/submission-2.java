class Solution {
    public int search(int[] nums, int target) {
        
        return binarySesrch(nums, target, 0, nums.length-1);
    }

    public int binarySesrch(int[] nums, int target, int sIdx, int eIdx){

        if (sIdx > eIdx) {
            return -1; // target not found
        }

        int middle = (int) (Math.ceil((eIdx+sIdx)/2));
        if(nums[middle]==target){
            return middle;
        }else{
            if(nums[middle]>target){
                return binarySesrch(nums, target, sIdx, middle-1);
            }else{
                return binarySesrch(nums, target, middle+1, eIdx);
            }
        }
    }
}
