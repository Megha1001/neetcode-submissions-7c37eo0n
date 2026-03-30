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
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return diameter;
    }

    private int findDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int height_lst = findDiameter(root.left);
        int height_rst = findDiameter(root.right);
        diameter = Math.max(diameter, height_lst + height_rst);
        return 1 + Math.max(height_lst, height_rst);
    }
}
