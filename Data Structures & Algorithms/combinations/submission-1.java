class Solution {

    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        
        dfs(1, n, k, new ArrayList<>());

        return res;
    }


    public void dfs(int startValue, int n, int k, List<Integer> path){

        //check
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }else if(path.size()>k){
            return;
        }

        for(int i=startValue; i<=n; i++){

            //forward
            path.add(i);

            //dfs
            dfs(i+1, n, k, path);

            //backtrack
            path.removeLast();
        }
    }
}