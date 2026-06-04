class Solution {
    //watched the video then implemented myself
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int current = 0;
        for(int i=0; i<nums.length; i++){
            int candidate = nums[i];
            if(candidate==res){
                current++;
            }else{
                current--;
                if(current==0){
                    current=1;
                    res=candidate;
                }
            }

        }

        return res;
    }
}