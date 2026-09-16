class Solution {
    //Suman Bhunia

    //here: changed from Set<List<Integer>> to List<List<Integer>>
    //we will prevent duplicates during recursion itself
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        //here: sort nums so we can stop early when nums[i] > target
        Arrays.sort(nums);

        List<Integer> path = new ArrayList<Integer>();

        //here: pass nums and starting index 0
        combination(nums, path, target, 0);

        //here: result is already a List, so no conversion needed
        return result;
    }

    //here: added nums and start parameters
    void combination(int[] nums, List<Integer> path, int target, int start) {

        if (target < 0)
            return;

        if (target == 0) {

            // we need to add the path

            //here: no need to sort path anymore
            //because combinations are generated in sorted order

            //here: directly add a copy of path
            result.add(new ArrayList<Integer>(path));

        } else {

            //here: start from "start" instead of checking every number again
            //this prevents duplicate combinations such as:
            //[2,2,3]
            //[2,3,2]
            //[3,2,2]
            for (int i = start; i < nums.length; i++) {

                //here: because nums is sorted,
                //if nums[i] is too large, everything after it is also too large
                if (nums[i] > target)
                    break;

                //here: get the current number using index i
                int n = nums[i];

                path.add(n);

                //here: pass i as the next starting index
                //we use i instead of i+1 because the same number
                //can be used multiple times
                //
                //example:
                //[2,2,3] is allowed
                combination(nums, path, target - n, i);

                path.remove(path.size() - 1);
            }
        }
    }
}