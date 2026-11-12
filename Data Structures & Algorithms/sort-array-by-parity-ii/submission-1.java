//from leetcode
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        int even = 0;

        while(even<nums.length && odd<nums.length){
            
            while(even<nums.length && nums[even]%2==0){
                even = even + 2;
            }


            while(odd<nums.length && nums[odd]%2!=0){
                odd = odd + 2;
            }

            //swap if unmatvhed value found
            if(even<nums.length && odd<nums.length){
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }

        return nums;
    }
}
