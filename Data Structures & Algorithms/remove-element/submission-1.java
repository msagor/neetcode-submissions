class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        int index = -1;
        for(int i=0; i< nums.length; i++){
            if(nums[i]==val){
                //we only do it once
                if(index==-1){
                    index = i;
                }
            }else if(nums[i]!=val){
                if(index!=-1){
                    //update array
                    nums[index] = nums[i];

                    //update index
                    index++;
                }

                //update result
                k++;
            }
        }

        return k;
    }
}