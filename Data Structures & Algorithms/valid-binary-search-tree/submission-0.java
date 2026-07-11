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

//watched solution video then tried to implement myself
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return helper(root, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode node, TreeNode parent, int parentLeftRange, int parentRightRange){
        //usual break condition
        //for ghost leaf nodes
        if(node == null){
            return true;
        }
        
        if(parent == null){
            //this is root node so root doesnt have parent so no need to compare
        }else{
            //node has a parent so we need to compare that node.val is within the left-Range and right-Range
            if( (parentLeftRange < node.val) && (node.val < parentRightRange) ){
                //good condition so continue
            }else{
                //bad condition
                return false;
            }
        }

        boolean lll = helper(node.left, node, parentLeftRange, node.val);

        boolean rrr = helper(node.right, node, node.val, parentRightRange);

        if(!lll || !rrr){
            return false;
        }else{
            return true;
        }
    }
}
