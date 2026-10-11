
//permutation means rearranging all the original elements, without adding, removing, or repeating any element.
//that is why [1, 1, 1] or [3, 3, 3] ar enot permutations.
//done entirely by myself
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, nums.length, path, visited);

        return res;
    }

    public void backtrack(int[] nums, int k, List<Integer> path, boolean[] visited){

        //check
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }else if(path.size()>k){
            return;
        }

        for(int i=0; i<visited.length; i++){
            if(visited[i]==false){
                //we need to visit this
                visited[i]=true;
                path.add(nums[i]);
                backtrack(nums, k, path, visited);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
}
