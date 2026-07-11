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

 //trees have left to right bias.
 //when we say inorder, preorder, postorder - we mesn that for the root node.
 //inorder - left child, root, right child
 //preorder - root, left child, right child
 //postorder - left child, right child, root

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }else{

            //left
            if(root.left!=null){
                inOrder(root.left, res);
            }

            //itself
            res.add(root.val);

            //right
            if(root.right!=null){
                inOrder(root.right, res);
            }
        }
    }
}