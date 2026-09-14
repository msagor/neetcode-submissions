class Solution {
    ////notice that the array is sorted,
    //we could use two pointer technique for twoSum,
    //two pointer technique requires a sorted array.
    //but we using the hashmap solution here which does not require sorted array.
    //solve Two Integer Sum II after this.

    //also notice that we test each value as we put them in the map,
    //as opposed to first putting all values in the map first.
    //in that case, youll have to explicitly test that i!=j
    //that solution is added at the bottom in the comment.
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




/*

class Solution {

    public int[] twoSum(int[] nums, int target) {

        // key   = number from nums
        // value = index of that number
        HashMap<Integer, Integer> map = new HashMap<>();

        // -------------------------
        // PASS 1:
        // Put ALL numbers into map
        // -------------------------
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }


        // -------------------------
        // PASS 2:
        // Look for the number needed
        // to complete the target
        // -------------------------
        for (int i = 0; i < nums.length; i++) {

            int val = nums[i];

            // Find the number we need:
            // val + needed = target
            int needed = target - val;

            // Check if that needed number exists in the map
            if (map.containsKey(needed)) {

                // Get the index of the needed number
                int j = map.get(needed);

                // IMPORTANT:
                // Make sure we are NOT using the same element twice.
                //
                // Example:
                // nums = [3, 2, 4]
                // target = 6
                //
                // At i = 0:
                // val = 3
                // needed = 3
                //
                // map contains 3, but its index may also be 0.
                // We cannot use nums[0] twice.
                if (i != j) {

                    // Return smaller index first
                    int[] ret = new int[2];

                    ret[0] = i < j ? i : j;
                    ret[1] = i > j ? i : j;

                    return ret;
                }
            }
        }

        // No solution found
        return null;
    }
}
*/