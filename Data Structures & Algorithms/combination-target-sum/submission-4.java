
//totally implemented myself without seeing the solution
//needed slight helpf rom chatgpt - see //here comments
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        //this will prevent picking duplicate sets
        Arrays.sort(nums);

        List<Integer> path = new ArrayList<>();

        dfs(nums, target, path, 0, 0);

        return res; //at this point path set should be empty
    }

    public int dfs(int[] nums, int target, List<Integer> path, int startIndex, int currSum){

        //here - i was not keeping track of the startIndex
        if(startIndex>=nums.length){
            return 1; //overflow return
        }
        if(currSum==target){
            res.add(new ArrayList<>(path));
            return 0; //match return
        }

        if(currSum>target){
            return 1; //overflow return
        }

        //here - previously i was running the loop from 0 every time,
        //instead, you need to start from startIndex.
        //note that i pass i instead of (i+1) in next iteration,
        //coz you can select the same element multiple times.
        int ret = -1;
        for(int i=startIndex; i<nums.length; i++){
            int n = nums[i];
            path.add(n);
            ret = dfs(nums, target, path, i, currSum+n);
            path.removeLast();
            if(ret==0 || ret == 1){
                break;
            }
        }

        return 100; //ok return
    }
}
