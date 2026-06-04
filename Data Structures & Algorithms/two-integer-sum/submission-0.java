class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        
        for(int i=0; i< nums.length; i++){
            int d = target - nums[i];
            if(diff.containsKey(d)){
                return new int[]{i<diff.get(d)?i:diff.get(d), i>diff.get(d)?i:diff.get(d)};
            }else{
                diff.put(nums[i], i);
            }
        }

        return null;

    }
}
