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

        while(root!=null){
            if(p.val > root.val && q.val > root.val){
                //both values are on right subtress
                root = root.right;
            }else if(p.val < root.val && q.val < root.val){
                //both values are on left subtress
                root = root.left;
            }else{
                //p and q are one different subtree, this is the LCA
                return root;
            }
        }

        return null;
    }
}
