class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashDup = new HashSet<Integer>();
        for(int i=0; i< nums.length; i++){
            if(!hashDup.contains(nums[i])){
                hashDup.add(nums[i]);
            }else{
                return true;
            }
        }
        // test comment
        return false;
    }
}
