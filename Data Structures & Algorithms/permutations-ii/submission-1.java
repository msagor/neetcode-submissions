class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, path, visited);

        return res;
    }

    public void backtrack(int[] nums, List<Integer> path, boolean[] visited) {

        // Check
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        } else if (path.size() > nums.length) {
            return;
        }

        for (int i = 0; i < visited.length; i++) {

            // FIXED: Skip an index already used in the current path
            if (visited[i]) { // here
                continue;    // here
            }

            // FIXED: Moved duplicate check BEFORE choosing the number
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { // here
                continue; // here
            }

            // Choose
            visited[i] = true;
            path.add(nums[i]);

            // Explore
            backtrack(nums, path, visited);

            // Backtrack
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}