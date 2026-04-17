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
//TC : O(N)
//SC : O(H), height of tree
class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }

    private int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left_height = findHeight(root.left);
        int right_height = findHeight(root.right);
        diameter = Math.max(diameter, left_height + right_height);
        return 1 + Math.max(left_height, right_height);
    }
}
