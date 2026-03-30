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
    public static int count = 0;
    public int goodNodes(TreeNode root) {
        //Maintain the max seen so far and do preorder traversal
        count = 0;
        int max = Integer.MIN_VALUE;
        countGoodNodes(root, max);
        return count;
    }

    public void countGoodNodes(TreeNode root, int max){
        if(root == null){
            return;
        }
        
        if(max <= root.val){
            max = root.val;
            ++count;
        }

        countGoodNodes(root.left, max);
        countGoodNodes(root.right, max);
        
    }
}
