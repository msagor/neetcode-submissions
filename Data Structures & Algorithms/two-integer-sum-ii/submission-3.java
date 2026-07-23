class Solution {

    //note that the array is sorted
    //using the two sum I solution which requires more than O(1) space
    public int[] twoSum(int[] nums, int target) {

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
                ret[0] = i<j?i+1:j+1; //small first
                ret[1] = i>j?i+1:j+1; //big second
                return ret;
            }else{
                diff.put(val, i);
            }

        }

        return null;
    }

    //using two pointer solution which requires O(1) space
    public int[] twoSum_(int[] numbers, int target) {
        
        int ptx_s = 0;
        int ptx_e = numbers.length-1;

        while(numbers[ptx_s]+numbers[ptx_e]!= target){
            int possible_sum = numbers[ptx_s]+numbers[ptx_e];
            //the values at this indexes does not add up to target
    
            //check if possible_sum is greater than target
            if(possible_sum > target){
                //smallest + highest values exceed target so decrement highst value
                ptx_e--;
            }else if(possible_sum < target){
                //smallest + highest values less than target to increment smallest value
                ptx_s++;
            }
        }

        int[] res = {++ptx_s, ++ptx_e}; //need to increment the index to make 1-indexed
        return res;

    }
}