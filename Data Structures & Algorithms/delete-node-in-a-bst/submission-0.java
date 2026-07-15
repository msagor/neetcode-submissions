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
//watched video, watched solution, understood both, then implemented myself with comment
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //if root is null. return root
        if(root == null){
            return root;
        }

        //we first need to find to the key node
        if(key<root.val){
            //key must be in the left subtree
            //we pass that along recursion
            root.left = deleteNode(root.left, key);
        }else if(key>root.val){
            //key must be in the right subtree
            //we pass that along recursion
            root.right = deleteNode(root.right, key);
        }else if(key==root.val){
            //we reached the key
            //the key can have children
            //there are three cases
            //only left child exists
            //only right child exists
            //both child exists

            //if only left child exists, return that
            if(root.right==null){
                return root.left;
            }

            //if only right child exists, return that
            if(root.left==null){
                return root.right;
            }

            //coming here means key node has both left and right child
            //we need to select one of them and find a suitable candidate to replace key
            //we pick right child of key and find the smallest leaf in that subtree
            TreeNode currNode = root.right;

            //run a while loop to continue going left-wise to find the smallest leaf
            //BST guarantess that if we keep going left-wise, we will find the smallest leaf
            while(currNode.left!=null){
                currNode = currNode.left;
            }

            //coming here means we found the candidate node to replace root
            root.val = currNode.val;

            //we still need to delete the leaf node from its original position
            root.right = deleteNode(root.right, currNode.val);
        }

        return root;
    }
}
