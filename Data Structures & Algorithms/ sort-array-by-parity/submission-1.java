//from leetcode
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            
            //increment left pointer
            //we are looking for odd
            while(l<r && nums[l]%2==0){
                l++;
            }

            //decrement right pointer
            //we are looking for even
            while(l<r && nums[r]%2!=0){
                r--;
            }


            //swap if l<r
            if(l<r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        return nums;

    }
}
