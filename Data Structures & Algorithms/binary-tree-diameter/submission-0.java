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

//watched solution then implemented myself,
//did not work.
//chatgpt fixed bugs.
//bug - put the +1 at the wrong place.
class Solution {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return res;
    }

    //computes the max height of a BST
    //while doing it also computes the diameter for each node.
    public int dfs(TreeNode root){

        if(root==null){
            return 0;
        }

        //we need to get left and righ heights
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        //get the diameter of this node
        int diameter = leftHeight + rightHeight;

        //check if this diameter is new res
        res = Math.max(diameter, res);
        
        //now, get the max height for this node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
