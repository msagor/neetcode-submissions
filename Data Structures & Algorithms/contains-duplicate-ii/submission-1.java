class Solution {
    //implemented myself but chatgpt fixed one edge case
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i< nums.length; i++){
            if(map.keySet().contains(nums[i])){
                //get the old key
                int i_old = map.get(nums[i]);

                if(Math.abs(i_old-i)<=k){
                    return true;
                }else{
                    //need to update the index for this key
                    //missed this chatgpt fixed it
                    //ex - 1,0,1,1 and k = 1
                    map.put(nums[i], i);
                }

            }else{
                map.put(nums[i], i);
            }
        }

        return false;
    }
}