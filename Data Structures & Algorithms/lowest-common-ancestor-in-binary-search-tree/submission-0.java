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

class Solution {

    //watched the video and solution in python then implemented myself in java
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;

        while(curr!=null){
            if(p.val > curr.val && q.val > curr.val){
                //both values are on right subtress
                curr = curr.right;
            }else if(p.val < curr.val && q.val < curr.val){
                //both values are on left subtress
                curr = curr.left;
            }else{
                //p and q are one different subtree, this is the LCA
                return curr;
            }
        }

        return null;
    }
}
