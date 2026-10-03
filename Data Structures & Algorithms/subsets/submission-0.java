class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int currIndex, List<Integer> path){

        res.add(new ArrayList<>(path));

        if(currIndex>=nums.length){
            return;
        }

        for(int i=currIndex; i< nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i+1, path);
            path.removeLast();
        }
    }
}
