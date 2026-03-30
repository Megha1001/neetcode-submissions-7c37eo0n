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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode p = q.poll();
            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;

            if(p.left!=null){
                q.offer(p.left);
            }

            if(p.right!=null){
                q.offer(p.right);
            }
        }

        return root;
    }
}
