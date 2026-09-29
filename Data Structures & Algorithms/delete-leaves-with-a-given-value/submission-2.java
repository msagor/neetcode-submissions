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

//doen entirely by myself
//used a dummy nullNode to assign to the parent when a heads val==target and both child null
class Solution {
    public enum Branch {LEFT, RIGHT}
    static TreeNode nullNode;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode parentOfroot = new TreeNode(-1);
        parentOfroot.left = root;

        boolean res = deleteLeafNode(root, parentOfroot, Branch.LEFT, target);
        return parentOfroot.left;
    }

    public static boolean deleteLeafNode(TreeNode head, TreeNode parentOfHead, Branch branch, int target){
        if(head==null){
            return true;
        }

        boolean lc = deleteLeafNode(head.left, head, Branch.LEFT, target);
        boolean rc = deleteLeafNode(head.right, head, Branch.RIGHT,  target);

        if(lc && rc && head.val==target){
            if(branch==Branch.LEFT){
               parentOfHead.left = nullNode; 
            }else if(branch==Branch.RIGHT){
                parentOfHead.right = nullNode; 
            }
            return true;
        }

        return false;
    }
}