class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int index = -1;
        int prev = -1;
        for(int i=0; i < nums.length; i++){
            if(i==0){
                //first time init prev
                prev = nums[i];
                k++;
            }else if(nums[i]==prev){
                //if prev matches,
                //
                if(index==-1){
                    index = i;
                }else if(index!=-1 && nums[index]==nums[i]){
                    index=index;
                }
            }else if(nums[i]!=prev){

                //update prev for next iteration
                prev = nums[i];

                //we found a new item so increase k
                k++;

                //if index not -1, 
                // that means we need to update the slot
                if(index!=-1){
                    nums[index] = nums[i];
                    index++;
                }
            }
        }
        return k;
    }
}