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
                // only done once when index used first time
                if(index==-1){
                    index = i;
                }
            }else if(nums[i]!=prev){

                //update prev for next iteration
                prev = nums[i];

                //we found a new item so increase k
                k++;

                //if index not -1, 
                // that means we need to update the slot
                if(index!=-1){
                    //update slot
                    nums[index] = nums[i];

                    //increment index for next slot
                    index++;
                }
            }
        }
        return k;
    }
}