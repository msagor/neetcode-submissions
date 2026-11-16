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
 //below impl was a random retry 
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


/*
//did entirely myself on a random night
class Solution {
    public int rob(TreeNode root) {
        
        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }


    // 0 - including root
    // 1 -excluding root
    public int[] dfs(TreeNode head){
        if(head==null){
            return new int[]{0, 0};
        }

        int[] res = new int[2];

        //get left child result
        int[] leftChildRes = dfs(head.left);
        int[] rightChildRes = dfs(head.right);

        //get result with this node
        res[0] = head.val + leftChildRes[1] + rightChildRes[1];

        res[1] = Math.max(leftChildRes[0], leftChildRes[1]) +
                                Math.max(rightChildRes[0], rightChildRes[1]);

        return res;

    }
}*/