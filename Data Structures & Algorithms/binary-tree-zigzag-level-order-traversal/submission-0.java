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

//chatgopt implementation following my style below
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        dfs(root, res, 0);

        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, int level) {

        // Base case
        if (node == null) {
            return;
        }

        // If this is the first node at this level,
        // create a new list for the level.
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        // Even levels: left-to-right
        // Odd levels: right-to-left
        //this is what implementation was missing.
        if (level % 2 == 0) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }

        // Always traverse the tree normally.
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }
}

/*
//my implementation which is wrong, 
//the zigzag happens when you sore the node val, 
//not whow you pass the children along the recursion.
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, res, 0);

        return res;

    }

    public void dfs(TreeNode node, List<List<Integer>> res, int level){
        //basic null check
        if(node == null){
            return;
        }

        //check the size of res at this level.
        //ex - for level 0, if size sould be 0, 
        //so we need to add an inner list
        if(res.size() == level){
            res.add(new ArrayList<>());
        }

        //now add this node at its level array
        res.get(level).add(node.val);

        //now pass the children along the recursion with zigzag
        //for level 0 = left-to-right
        //for level 1 = right-to-left
        //for level 2 = left-to-right etc...
        if(level%2==0){
            //we do left-to-right
            dfs(node.left, res, level+1);
            dfs(node.right, res, level+1);
        }else{
            //we do right-to-left
            dfs(node.right, res, level+1);
            dfs(node.left, res, level+1);
        }
    }
}
*/