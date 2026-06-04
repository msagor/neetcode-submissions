class Solution {
    //read the hints, then done myself
    //not a big fan of while inside for loop
    public int longestConsecutive(int[] nums) {

        // Hash Set Initialisation
        Set<Integer> set = new HashSet<>();

        // Iteration using enhanced for loop
        for (int element : nums) {
            set.add(element);
        }

        //find all the numbers from which a new sequence starts
        List<Integer> starters = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            int candidate = nums[i];
            if(!set.contains(candidate-1)){
                starters.add(candidate);
            }
        }

        int res = 0;
        for(int i=0; i< starters.size(); i++){
            int cand_starter = starters.get(i);

            int new_res = 0;
            while(set.contains(cand_starter)){
                new_res++;
                cand_starter++;
            }

            res = Math.max(res, new_res);
        }

        return res;
        
    }
}
