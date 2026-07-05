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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot);
    }

    public boolean helper(TreeNode head, TreeNode subRoot){
        if (head==null){
            return false;
        }else{
            boolean isSame = isSameTree(head, subRoot);

            if(isSame){
                return true;
            }else{
                boolean isSameLeft = helper(head.left, subRoot);
                if(isSameLeft){
                    return true;
                }else{
                    boolean isSameRight = helper(head.right, subRoot);
                    if(isSameRight){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //we need to perform DFS on both trees
        return dfs(p, q);

    }

    public boolean dfs(TreeNode p, TreeNode q){
        
        //both null check
        if(p==null && q==null){
            return true;
        }
        //only one null check
        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }

        //both not null but not equal check
        if(p!=null && q!=null && p.val!=q.val){
            return false;
        }

        //both null check.
        //no need to check this separately.
        //becase if both nodes are null or same value, then we good to proceed
        if((p.val==q.val)){
            //p and q match
            //we need to pass their left and right children
            if( !dfs(p.left, q.left) || !dfs(p.right, q.right) ){
                return false;
            }
        }

        return true;

    }
}
