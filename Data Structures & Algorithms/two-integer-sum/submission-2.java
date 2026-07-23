class Solution {
    public int[] twoSum(int[] nums, int target) {

        //notice that the array is sorted
        //key is the val, value is the index of the value
        HashMap<Integer, Integer> diff = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            int val = nums[i];

            //find how much val is short of target
            int d = target - val;

            //check if the diff contains d
            if(diff.containsKey(d)){
                int j = diff.get(d);

                //coming here means we found the indeces
                //they are i and j
                //we dont know which one is smaller
                int[] ret = new int[2];
                ret[0] = i<j?i:j; //small first
                ret[1] = i>j?i:j; //big second
                return ret;
            }else{
                diff.put(val, i);
            }

        }

        return null;
    }
}