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

//read the hint then realized this is just an extension of levelOrder traversal problem
//we do the levelOrder traversal first, then for each level return the right most (last) elements in a res array
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<List<Integer>> levelOrderTraversedRes = levelOrder(root);

        List<Integer> res = new ArrayList<>();
        for(List<Integer> l: levelOrderTraversedRes){
            res.add(l.get(l.size()-1));
        }

        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        //resultant list of lists
        List<List<Integer>> res = new ArrayList<>();

        //we can do DFS
        dfs(root, 0, res);

        return res;
    }

    public void dfs(TreeNode node, int level, List<List<Integer>> res){

        //breal condition
        if (node==null){
            return;
        }

        //at level 0, res length is 0, so we need to add a new inner list
        if(res.size()==level){
            res.add(new ArrayList<>());
        }

        //at current level push this node in its onner list
        res.get(level).add(node.val);

        //recursivelty pass along left and right children thru the same recursion
        dfs(node.left, level+1, res);
        dfs(node.right, level+1, res);
    }
}
