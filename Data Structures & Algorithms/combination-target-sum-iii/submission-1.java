class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        //first, create nums array and populate
        int[] nums = new int[9];
        for(int i=1; i<=9; i++){
            nums[i-1] = i;
        }

        //second, create visited list
        List<Integer> visited = new ArrayList<>();

        //third, pass thru dfs
        dfs(nums, 0, visited, 0, k, n);

        return result;
    }

    public void dfs(int[] nums, int idx, List<Integer> visited, int visitedSum, int k, int n){
        
        //check reached answer
        if(visited.size()==k && visitedSum==n){
            result.add(new ArrayList<>(visited));
            return;
        }

        //check out of index
        if(idx==nums.length){
            return;
        }
        
        for(int i=idx; i<nums.length; i++){
            if(!visited.contains(nums[i])){

                visited.add(nums[i]);
                visitedSum = visitedSum + nums[i];

                dfs(nums, i+1, visited, visitedSum, k, n);
                
                visited.removeLast();
                visitedSum = visitedSum - nums[i];
            }
        }
    }
}
