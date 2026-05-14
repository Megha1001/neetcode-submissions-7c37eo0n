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
//TC : O(h+K)
//SC : O(h);
class Solution {
    private int count;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        //Recurive code : inorder traversal of BST is sorted
        count = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        //node
        --count;
        if(count == 0){
            ans =  root.val;
            return;
        }
        //right
        inorder(root.right);
    }
}
