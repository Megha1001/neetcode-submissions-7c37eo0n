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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(p.val == root.val || q.val == root.val){
            return root;
        }
        
        TreeNode lca_left = lowestCommonAncestor(root.left, p, q);
        TreeNode lca_right = lowestCommonAncestor(root.right, p, q);

        if(lca_left != null && lca_right != null){
            return root;
        }

        if(lca_left != null){
            return lca_left;
        }else {
            return lca_right;
        }
        
    }
}
