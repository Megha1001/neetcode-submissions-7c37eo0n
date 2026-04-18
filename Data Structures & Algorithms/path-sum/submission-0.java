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
//TC : O(N) traverse all nodes
//SC : O(H) where H is height 
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //dfs
        if(root == null){
            return false;
        }

        targetSum -= root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        
    }
}