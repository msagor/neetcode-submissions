//did the subset computation part myself, but had to look up xor function
class Solution {
    int total = 0;
    public int subsetXORSum(int[] nums) {
        
        dfs(nums, 0, new ArrayList<>());
        return total;
    }

    public void dfs(int[] nums, int currIndex, List<Integer> path){

        if(!path.isEmpty()){
            //compute XOR for current path and add to total
            total = total + computeXOR(path);
        }

        if(currIndex>=nums.length){
            return;
        }

        for(int i=currIndex; i< nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i+1, path);
            path.removeLast();
        }
    }


    public int computeXOR(List<Integer> path) {
        int a = 0;

        for (int b : path) {
            a = a ^ b;
        }

        return a;
    }
}