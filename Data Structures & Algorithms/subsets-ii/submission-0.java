
//did myself, chatgpt fixed the //here part
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int startIndex, int[] nums, List<Integer> path) {
        
        res.add(new ArrayList<>(path));

        if(startIndex>nums.length){
            return;
        }

        int i = startIndex;
        while(i<nums.length){
            
            path.add(nums[i]);
            backtrack(i+1, nums, path);
            path.removeLast();

            //here - my logic here was wrong
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }

            i++; 
        }
    }
}