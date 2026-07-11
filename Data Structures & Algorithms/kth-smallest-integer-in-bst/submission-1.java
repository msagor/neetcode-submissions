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

//we need to do an inOrder traversal,
//because inOrder traversal visits the nodes for smallest to largest values,
//so we keep doing inOrder traversal while keep track of k count.
//read solution and once i understood above phenomenon, i implemented myself.
class Solution {
    int res = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }


    public void inOrder(TreeNode node, int k){
        //basic break condition
        if(node == null){
            return;
        }else{
            //process the left child
            inOrder(node.left, k);

            //process node
            //we are not storing the node value in this problem, 
            //we are just keeping track of count and compare against k,
            //since we processing this node, count should increase
            count++;
            if(count==k){
                //this node contains the kth smallest value
                res = node.val;
                return;
            }

            //process the right child
            inOrder(node.right, k);

        }
    }
}
