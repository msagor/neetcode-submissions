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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //we need to perform DFS on both trees
        return dfs(p, q);

    }

    public boolean dfs(TreeNode p, TreeNode q){
        
        //case 1 - both null check
        if(p==null && q==null){
            return true;
        }
        //case 2 - only one null check
        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }

        //case 3 - both not null but not equal check
        if(p!=null && q!=null && p.val!=q.val){
            return false;
        }

        //case 4 - both not null but equal check
        if((p.val!=q.val)){
            //p and q dont match
            return false;
        }

        //coming here means all checks have passed so its time to handle children
        //we need to pass their left and right children
        boolean lll = dfs(p.left, q.left);
        boolean rrr = dfs(p.right, q.right);

        if( !lll || !rrr){
            return false;
        }else{
            return true;
        }
    }
}
