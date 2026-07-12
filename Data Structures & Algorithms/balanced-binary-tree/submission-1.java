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

//implemented myself
//after you solve Invert Binary Tree, Maximum Depth of Binary Tree, Diameter of Binary Tree - this problem is easy
////binary-tree-diameter and balanced-binary-tree - both problems ascends from depth-of-binary-tree problem
class Solution {

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return result;

    }

    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        //get the left and right height
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        //check if the left == right height
        if(leftHeight==rightHeight){
            //nothing to do
        }else{
            //get the diff
            int diff = Math.abs(leftHeight - rightHeight);

            //deduct maxAllowedDiscripenceyLeft from diff
            if(diff > 1){
                result = false;
            }


        }

        //get the height for next iteration
        return 1 + Math.max(leftHeight, rightHeight);

    }
}
