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


 //did entirely myself after multiple tries.
 //see- //here
 //see the diagram - https://drive.google.com/file/d/1Q5IVWaBf1pEmysW2QkSIshu00mQ49rhB/view?usp=sharing

class Solution {
    public int rob(TreeNode root) {

        int[] fromRoot =  dfs(root);
         
        int maxFromRoot = fromRoot[0];
        int maxFromChildOfRoot = fromRoot[1];

        return Math.max(maxFromRoot, maxFromChildOfRoot);        
    }

    public int[] dfs(TreeNode head){

        //reached null
        if(head==null){
            return new int[]{0, 0};
        }

        //get the max if we started from child
        //each return has two parts - with head, without head aka from its childred
        int[] leftChildMax = dfs(head.left);
        int[] rightChildMax = dfs(head.right);

        int robHead = head.val + leftChildMax[1] + rightChildMax[1];

        //here - i was taking a max between two, instead of adding them, if can rom both child simultaneously
        int skipHead = Math.max(leftChildMax[0], leftChildMax[1]) + Math.max(rightChildMax[0], rightChildMax[1]);

        return new int[]{robHead, skipHead};

    }
}