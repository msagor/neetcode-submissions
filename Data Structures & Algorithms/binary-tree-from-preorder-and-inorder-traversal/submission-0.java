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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Base case:
        // If either array is empty, there is no tree to build.
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // The first element of preorder is always the root.
        TreeNode root = new TreeNode(preorder[0]);

        // Variable to store the index of the root in inorder traversal.
        int mid = -1;

        // Search for the root value inside the inorder array.
        // Everything to the left of this index belongs to the left subtree.
        // Everything to the right belongs to the right subtree.
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        // ---------------- Left Subtree ----------------

        // Left subtree has 'mid' nodes.
        //
        // preorder:
        // [root | left subtree | right subtree]
        //
        // Skip index 0 (the root).
        // Take the next 'mid' elements for the left subtree.
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);

        // In inorder, everything before 'mid' belongs to the left subtree.
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);

        // Recursively build the left subtree.
        root.left = buildTree(leftPreorder, leftInorder);

        // ---------------- Right Subtree ----------------

        // After removing the root and left subtree from preorder,
        // the remaining elements belong to the right subtree.
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);

        // In inorder, everything after 'mid' belongs to the right subtree.
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        // Recursively build the right subtree.
        root.right = buildTree(rightPreorder, rightInorder);

        // Return the completed tree rooted at 'root'.
        return root;
    }
}