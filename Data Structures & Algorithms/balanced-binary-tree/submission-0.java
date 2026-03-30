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

    //Solution 1 : Do Level order traversal and for each node calculate height_lst and height_rst if at any point of time difference >1 return false;

    /*
     Recursion based - TC : O(N*N)
        1. calculate height of every node
    */

    // public boolean isBalanced(TreeNode root) {

    //     if(root==null){
    //         return true;
    //     }

    //     int height_lst = height(root.left);
    //     int height_rst = height(root.right);

    //     return Math.abs(height_lst - height_rst) <=1
    //     && isBalanced(root.left) 
    //     && isBalanced(root.right);     
    // }

    // public int height(TreeNode root){
    //     if(root == null){
    //         return 0;
    //     }

    //     return 1 + Math.max(height(root.left), height(root.right));
    // }

    /* 
    IDEA : Our function will return -1 or height of tree
        -> if return -1 that means its not balanced;
    */
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root)==-1? false : true;
    }

    public int checkBalanced(TreeNode root) {

        if(root==null){
            return 0;
        }

        int lh = checkBalanced(root.left);
        if(lh == -1){
            return -1;
        }

        int rh = checkBalanced(root.right);
        if(rh == -1){
            return -1;
        }

        if(Math.abs(lh-rh)>1){
            return -1;
        }else{
            return 1 + Math.max(lh, rh);
        }
        
    }
}
