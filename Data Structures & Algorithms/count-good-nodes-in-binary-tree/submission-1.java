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
    public int goodNodes(TreeNode root) {
        //Maintain the max seen so far and do preorder traversal
        int max = Integer.MIN_VALUE;
        return countGoodNodes(root, max);
    }

    public int countGoodNodes(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        
        int count = 0;
        if(max <= root.val){
            count = 1;
            max = root.val;
        }

        count += countGoodNodes(root.left, max);
        count += countGoodNodes(root.right, max);
        
        return count;
    }
}
