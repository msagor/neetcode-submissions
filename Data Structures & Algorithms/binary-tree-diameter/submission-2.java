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

//we need to find the depth (aka height) of binary tree,
//and while doing that we will compute the diameter as a bi-product
//binary-tree-diameter and balanced-binary-tree - both problems ascends from depth-of-binary-tree problem
class Solution {

    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }else{
            //compute left height
            int leftHeight = dfs(node.left);

            //compute right height
            int rightHeight = dfs(node.right);


            //compute diameter
            int diameter = leftHeight + rightHeight;

            //only keep the max diameter
            res = Math.max(res, diameter);


            //keep computing height of binary tree
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
