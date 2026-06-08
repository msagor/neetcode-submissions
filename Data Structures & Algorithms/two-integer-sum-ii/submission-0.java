class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int ptx_s = 0;
        int ptx_e = numbers.length-1;

        while(numbers[ptx_s]+numbers[ptx_e]!= target){
            int possible_sub = numbers[ptx_s]+numbers[ptx_e];
            //the values at this indexes does not add up to target
    
            //check if possible_sub is greater than target
            if(possible_sub > target){
                //smallest + highest values exceed target so decrement highst value
                ptx_e--;
            }else if(possible_sub < target){
                //smallest + highest values less than target to increment smallest value
                ptx_s++;
            }
        }

        int[] res = {++ptx_s, ++ptx_e}; //need to increment the index to make 1-indexed
        return res;

    }
}
