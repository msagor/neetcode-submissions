class Solution {

    //3sum using my two sum solution
    public List<List<Integer>> threeSum(int[] nums) {

        //notice that the array is not sorted
        //to use twoSum solution to solve threeSum we must first sort the array
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // Skip duplicate values for nums[i]
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // We need:
            // nums[j] + nums[k] = -nums[i]
            int target = -nums[i];

            // Call our Two Sum helper
            List<List<Integer>> pairs = twoSum(nums, i + 1, target);

            // Add nums[i] to every pair found
            for (List<Integer> pair : pairs) {

                List<Integer> triplet = new ArrayList<>();

                triplet.add(nums[i]);
                triplet.add(pair.get(0));
                triplet.add(pair.get(1));

                res.add(triplet);
            }
        }

        return res;
    }

    //two pointer based twoSum solution which returns all possible pairs, not just one.
    //using two pointer technique for twoSum
    //two pointer technique requires a sorted array
    private List<List<Integer>> twoSum(int[] nums, int start, long target) {

        // Stores all unique pairs of values that add up to the target
        List<List<Integer>> pairs = new ArrayList<>();

        // Left pointer starts from the given index
        // (because indexes before start are already used by 4Sum)
        int left = start;

        // Right pointer starts from the end of the array
        int right = nums.length - 1;

        // Search while the two pointers have not crossed
        while (left < right) {

            // Calculate current pair sum
            // Cast to long to avoid integer overflow for large values
            long sum = (long) nums[left] + nums[right];

            // Found a valid pair
            if (sum == target) {

                // Store the pair values as a List<Integer>
                pairs.add(Arrays.asList(nums[left], nums[right]));

                // Move both pointers to continue searching for other pairs
                left++;
                right--;

                // Skip duplicate values on the left side
                // Prevents returning duplicate pairs
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

                // Skip duplicate values on the right side
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

            }

            // Current sum is smaller than target
            // Move left pointer right to increase the sum
            else if (sum < target) {
                left++;
            }

            // Current sum is larger than target
            // Move right pointer left to decrease the sum
            else {
                right--;
            }
        }

        // Return all unique pairs found
        return pairs;
    }

    /*
     * Two Sum helper - hashmap solution which does not require sorted array
     *
     * Searches nums starting from startIndex.
     *
     * Returns all pairs whose sum equals target.
     */
    public List<List<Integer>> twoSum_(
            int[] nums,
            int startIndex,
            int target) {

        // key   = value
        // value = index
        HashMap<Integer, Integer> diff = new HashMap<>();

        List<List<Integer>> res = new ArrayList<>();

        for (int i = startIndex; i < nums.length; i++) {

            int val = nums[i];

            // Find how much val is short of target
            int d = target - val;

            // Check whether we have already seen d
            if (diff.containsKey(d)) {

                // We found:
                // d + val = target
                List<Integer> pair = new ArrayList<>();
                pair.add(d);
                pair.add(val);

                res.add(pair);

                /*
                 * Skip duplicate values.
                 *
                 * Since the array is sorted, if the next value
                 * is the same as val, it would create the same pair.
                 */
                while (i + 1 < nums.length &&
                       nums[i] == nums[i + 1]) {
                    i++;
                }

            } else {

                // Store the current value
                diff.put(val, i);
            }
        }

        return res;
    }
}

/*
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
*/