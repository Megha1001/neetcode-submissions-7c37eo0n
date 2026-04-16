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
//TC : O(N) : traversing all nodes
//SC : O(H), Height of tree
class Solution {
    private int max_sum;
    public int maxPathSum(TreeNode root) {
        /*
        Case - 1 : l + r + root.val // dont return it
        Case - 2 : Math.max(l, r) + root.val
        Case - 3 : root.val
        */

        max_sum = Integer.MIN_VALUE;
        solve(root);
        return max_sum;
    }

    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int l = solve(root.left);
        int r = solve(root.right);

        int both_side = l + r + root.val;
        int only_one_side = Math.max(l, r) + root.val;
        int only_root = root.val;
        
        max_sum = Math.max(max_sum, Math.max(both_side, Math.max(only_one_side, only_root)));

        return Math.max(only_one_side, only_root); //imp

    }
}
