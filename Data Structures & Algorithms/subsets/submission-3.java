//done myself..
///do Combination Sum after this problem - 
//https://neetcode.io/problems/combination-target-sum/question

//note that we dont have to sort the array coz the values are unique
//also note that we pass i+1 in next iteration coz we cannot pick same value many times

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        //Arrays.sort(nums);

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
