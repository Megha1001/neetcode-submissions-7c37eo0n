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
    public boolean isValidBST(TreeNode root) {
        //Every Node is valid for BST when its exists in valid range
        // root -> -INF, +INF, root.left = -INF, root.val, root.right = root.val, INF

        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(TreeNode root, int left, int right){
        if(root != null){
            if(root.val <= left || root.val >= right){
                return false;
            }

            return isBST(root.left, left, root.val) && isBST(root.right, root.val, right);
        }

        return true;
    }
}
