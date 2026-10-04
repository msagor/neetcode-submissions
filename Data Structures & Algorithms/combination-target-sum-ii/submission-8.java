

//solution from chatgpt,
//i was very close, but could not handle duplicate, see //here below
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int target, int currSum, int currIndex, List<Integer> path){

        //match
        if(currSum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        //currSum or currIndex overflow
        if(currSum > target || currIndex >= candidates.length){
            return;
        }


        for(int i = currIndex; i < candidates.length; i++){

            //here - i was missing this part
            if(i > currIndex && candidates[i] == candidates[i-1]){
                continue;
            }

            int n = candidates[i];
            path.add(n);
            dfs(candidates, target, currSum+n, i+1, path); //here - combination sum 1 has i
            path.remove(path.size()-1);
        }
    }
}