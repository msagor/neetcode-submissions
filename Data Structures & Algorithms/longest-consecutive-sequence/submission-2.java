class Solution {
    public int longestConsecutive(int[] nums) {
        // we need to convert the array in to a hashset for O(1) lookup to check if a value exists.
        //hashset constructor does not take an array so we need to do it manually
        Set<Integer> set = new HashSet<>();

        // Iteration using enhanced for loop
        for (int element : nums) {
            set.add(element);
        }

        //iterate thru every element and find the starters
        //hint3 says, We can consider a number num as the start of a sequence if and only if num - 1 does not exist in the given array.
        List<Integer> starters = new ArrayList<>();
        for(int i=0;i<nums.length; i++){
            int candidate = nums[i];
            if(!set.contains(candidate-1)){
                starters.add(candidate);
            }
        }

        //System.out.println(starters); 

        //for each starters, count their max run
        //aka keep adding +1 and check if the value exists in the set

        //variable to keep score for the whole array
        int global_res = 0;

        //iterate thru each starters
        for(int i=0; i<starters.size(); i++){
            int starter = starters.get(i);

            //variable that keep score for this starter
            int local_res=0;
            while(set.contains(starter)){
                local_res++;
                starter++; //add +1 for itself
            }

            global_res = Math.max(local_res, global_res);
        }


        return global_res;

    }
}
