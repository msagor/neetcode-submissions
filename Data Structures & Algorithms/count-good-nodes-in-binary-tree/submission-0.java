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

//watche video solution then implemented myself
class Solution {
    
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    public void dfs(TreeNode node, int maxvalue){
        if(node==null){
            return;
        }
        
        if(node.val>=maxvalue){
            res+=1;
        }

        dfs(node.left, Math.max(maxvalue, node.val));
        dfs(node.right, Math.max(maxvalue, node.val));
    }
}
