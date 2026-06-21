
/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}*/

//solution from chatgpt
class Solution {

    // Main method called by the judge
    public List<List<Integer>> levelOrder(TreeNode root) {

        // This list will store all levels
        List<List<Integer>> result = new ArrayList<>();

        // Start DFS from root at level 0
        dfs(root, 0, result);

        // Return the final level order result
        return result;
    }

    // DFS helper method
    //the level here is the current level number going in
    private void dfs(TreeNode node, int level, List<List<Integer>> result) {

        // If the current node is null, stop recursion
        if (node == null) {
            return;
        }

        // If this level does not exist in result yet
        // create a new list for this level
        //at 0th level, the size is 0 so we need to add a new inner list for level 0
        //at 1st level, the size if 1 so we need to add a new inner list for level 1
        //but for level 1 and beyond, the left child is the one adds the iiner list,
        //coz its being called first
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        // Add the current node's value to its corresponding level list
        result.get(level).add(node.val);

        // Recursively process the left child at the next level
        dfs(node.left, level + 1, result);

        // Recursively process the right child at the next level
        dfs(node.right, level + 1, result);
    }
}