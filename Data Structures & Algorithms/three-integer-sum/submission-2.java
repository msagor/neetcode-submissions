class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //implemented myself did not work, then AI did minor fix
        //first you need to solve TwoSum II problem (LC #15)

        //first sort the array in ascending order
        //then basically you need to solve for nums[j] + nums[k] = - nums[i],
        // for all j , k right of index i

        //example, given array : [-1,0,1,2,-1,-4]
        //after sorting we get : [-4, -1, -1, 0, 1, 2]
        //iterate over each values of i
        //for nums[i] = -4, we perform Two Sum for array [-1, -1, 0, 1, 2] with target -(-4)


        //sort
        Arrays.sort(nums);

        
        //create return data structure
        List<List<Integer>> res = new ArrayList<>();

        //run loop from start to end of nums
        for(int i=0; i< nums.length; i++){

            //recalc index i
            //we dont redo work for same values
            //for above example, the values of i==1 and i ==2 are the same.
            //so we need to do it once only.
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }

            //coming here means we have found a valid i
            //now based on i we need to calculate valid j and k

            //recalc index j and k
            int j = i+1;
            int k = nums.length-1;

            int target = - (nums[i]);

            //compute two sum II
            //note that we will compute multiple (j,k) pairs for this i.
            //in above example, for i==1, we will first compute j,k= (2,5),
            //and then in next iteration we will compute j,k = (3,4)
            while(j < k){
                int possible_target = nums[j] + nums[k];
                //check if possible_target is greater than target
                if(possible_target > target){
                    //we need rto decrement index k
                    k--;
                }else if (possible_target < target){
                    //we need to increment index j
                    j++;
                }else{
                    //its a match so put the solutions in the res
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(nums[k]);

                    res.add(r);

                    //we need to move the indexes j and k here
                    //first increment index j
                    j++;

                    //second  decrement index k
                    k--;

                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                }
            }
        }

        return res;

    }
}
