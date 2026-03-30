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

    public boolean isBST(TreeNode root, int min, int max){
        if(root != null){
            if(root.val <= min || root.val >= max){
                return false;
            }

            return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
        }

        return true;
    }
}
