class Solution {

    //solved in leetcode - https://leetcode.com/problems/contiguous-array/
    //watched video multiple times, then watched code, then typed myself
    //this is a tricky problem
    //for each index, compute diff between 0 and 1 and store (diff, index) in map
    //for exmaple - given 1110010
      //at index 00 - one - 1, zero - 0, diff - 1 at index 0, push (1, 0 )in map
      //at index 01 - one - 2, zero - 0, diff - 2 at index 1, push (2,0) in map
      //at index 02 - one - 3, zero - 0, diff - 3 at index 2, push (3,0) in map
      //at index 03 - one - 3, zero - 1, diff - 2 at index 3, dont push in map
      //at index 04 - one - 3, zero - 2, diff - 1 at index 4, dont push in map
      //at index 05 - one - 4, zero - 2, diff - 2 at index 5, dont push in map
      //at index 06 - one - 4, zero - 3, diff - 1 at index 6, dont push in map
      //at last index, check if count of zero == one, 
        //if yes, return 2x count
        //if no, return index - map.get(diff for last index)

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> diffMap = new HashMap<>();

        int zeros = 0;
        int ones = 0;
        int res = 0;
    
        for(int i=0; i< nums.length; i++){
            int n = nums[i];

            //check if its a 0 or 1
            if(n==0){
                zeros++;
            }else if(n==1){
                ones++;
            }

            //get the different between zeros and ones upto this point
            //you can use ones - zeros as well
            //but absolute doest work
            int diff = zeros - ones; //Math.abs(zeros - ones);


            //check if this diff already in diffMap,
            //otherwise put
            if(!diffMap.containsKey(diff)){
                diffMap.put(diff, i); //<diff, index>
            }

            //at every iteration we check if zeros==ones and record the res
            if(zeros == ones){
                res = zeros + ones;
            }else{
                //if they are not equal, that means we have inequality still
                res = Math.max(res, i - diffMap.get(diff));
            }
        }

        return res;
    }
}
