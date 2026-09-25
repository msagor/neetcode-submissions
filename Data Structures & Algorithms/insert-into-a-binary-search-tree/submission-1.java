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


//done all by myself
//For BST insertion: Never move existing nodes. 
//Only add the new value at the appropriate empty child position.
//so for example #1, [6,5,9,3,1,4] would not be a valid answer.
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }

        insert(root, new TreeNode(val));

        return root;
    }

    public void insert(TreeNode head, TreeNode val){

        TreeNode prev = null;
        while(head!=null){
            prev = head;
            if(head.val < val.val){
                head = head.right;
            }else if(head.val > val.val){
                head = head.left;
            }
        }

        //at htis point head point to the slot where new node will be added
        //and prev point to the parent of head
        if(prev.val<val.val){
            prev.right = val;
        }else{
            prev.left = val;
        }
    }
}