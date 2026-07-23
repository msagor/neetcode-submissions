class Solution {
    //watched solution then implemented myself
    public int minSubArrayLen(int target, int[] nums) {

        //note that we cannot sort the array.
        //since we need to find the minimum subarray,
        //order is important to preserve.
        //example: target = 10, nums = [2,1,5,1,5,3]
          //answer is [5,1,5]=3
          //if we sorted then the answer would be [5,5]=2 which is incorrect
    

        int total = 0;
        int res = Integer.MAX_VALUE;
        
        int l =0;
        int r = 0;

        //first, we run a sliding window from 0 ---> right and find the total
        while(r<nums.length){

            total = total + nums[r];

            //second, we detech total went over target
            if(total>=target){

                //third, we need to keep increasing left pointer, 
                //until we our sum went under the target.
               while(total>=target){

                    //always keep the smaller res
                    res = Math.min(res, r-l+1);

                    //reduce total and increase left pointer
                    total = total - nums[l];

                    l++;
               }
                
                //coming here means we have moved l towoards the right of the array,
                //sufficient enough to get target/
                //but we cannto stop we still need to continue going to fins even smaller pairs
                //example: target = 10, nums = [1,1,1,1,1,5,5]
                  //after first iteration, l=0, r=5, total=10,
                    //resultant subarry=[1,1,1,1,1,5]
                    //but there could exist a smaller subarray,
                    //so we keep running the algorithm.
                  //after second iteration, l=0, r=6, total=15,
                    //resultant subarray=[1,1,1,1,1,5,5] which goes over target
                    //so we move left pointer to reduce the total
                    //when l=1, r=6, total=14, still gove sover target ❌
                    //when l=2,r=6, total=13, still goves over target ❌
                    //when l=3,r=6, total=12, still goves over target ❌
                    //when l=4,r=6, total=11, still goves over target ❌
                    //when l=5,r=6, total=10, equals to target with subarray =[5,5]✅

            }

            r++;
        }
        
        if(res==Integer.MAX_VALUE){
            return 0;
        }else{
            return res;
        }

    }
}