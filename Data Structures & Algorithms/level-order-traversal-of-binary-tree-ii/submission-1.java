class Solution {
    //neetcode does not have this problem so solved in leetcode
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    //first need to solve the binary tree level traversal i
    //solution from chatgpt
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> res) {

        if (node == null) {
            return;
        }

        // Add a new level at the front
        if (level == res.size()) {
            //here is the trick
            res.add(0, new ArrayList<>());
        }

        // Convert top-down level to bottom-up index
        //here is the trick
        res.get(res.size() - level - 1).add(node.val);

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}
