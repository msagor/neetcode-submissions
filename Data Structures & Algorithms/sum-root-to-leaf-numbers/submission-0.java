/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //solution from chatgpt
 //i got the idea of dfs, but couldnt implement it
class Solution {

    int total = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    private void dfs(TreeNode node, int current) {

        // If we reached the end of a path
        if (node == null) {
            return;
        }else{
            // Build the number from root to current node
            current = current * 10 + node.val;

            //we need to explicitly check here if this is the leaf node,
            //because the top node == null check was for cases when at least one child exists
            // If this is a leaf node, aka no children
            if (node.left == null && node.right == null) {
                total += current;
                return;
            }else{
                //children exists
                dfs(node.left, current);
                dfs(node.right, current);
            }
        }
    }
}