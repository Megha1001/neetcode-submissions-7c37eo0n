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
    public static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        findDia(root);
        return diameter;
        
    }

    public static int findDia(TreeNode root){
        if(root==null){
            return 0;
        }

        int height_lst = findDia(root.left);
        int height_rst = findDia(root.right);
        diameter = Math.max(diameter, height_lst + height_rst);
        return 1 + Math.max(height_lst, height_rst);
    }
}
