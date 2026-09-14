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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));

        int both_side = l + r + root.val;

        int one_side = Math.max(l, r) + root.val;

        int root_val = root.val;

        maxSum = Math.max(Math.max(Math.max(both_side, one_side), root_val), maxSum);

        return Math.max(one_side, root_val);
    }
}
