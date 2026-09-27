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

//read hints them implemented myself, watch previous solution for more refined impl
class Solution {
    
    int currMin = Integer.MIN_VALUE;
    int k_count = 0;
    int k = -1;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return currMin;
    }

    public void inOrder(TreeNode head){

        //we have reached ghost leaf node
        if(head==null){
            return;
        }

        //check if this is leaf node
        if(head.left==null && head.right==null){
            k_count++;
            currMin = Math.max(head.val, currMin);

            //check if we no longer need to continue search
            if(k_count==k){
                return;
            }
        }else{
            //not leaf node so we proceed with the traversal
            inOrder(head.left);

            if(k_count==k){
                return;
            }

            k_count++;
            currMin = Math.max(head.val, currMin);

            if(k_count==k){
                return;
            }

            inOrder(head.right);

            if(k_count==k){
                return;
            }
        }
    }
}
