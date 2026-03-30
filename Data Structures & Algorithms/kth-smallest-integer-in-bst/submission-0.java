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
    public static int k_global = 0;
    public int kthSmallest(TreeNode root, int k) {
        //IDEA : InOrder traversal of binary search tree is sorted
        k_global = k;
        return inOrderTraversal(root);
    }

    public int inOrderTraversal(TreeNode root){
        if(root!=null){
            int left = inOrderTraversal(root.left);
            if(left != -1){
                return left;
            }
            --k_global;
            if(k_global == 0){
                return root.val;
            }
            int right = inOrderTraversal(root.right);
            if(right != -1){
                return right;
            }
        }
        return -1;
    }
}
