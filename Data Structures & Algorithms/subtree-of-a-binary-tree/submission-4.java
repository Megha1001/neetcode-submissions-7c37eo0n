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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return true;
        }
        if(root==null){ // subRoot!=null
            return false;
        }

        if(isSameTree(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }
    

    public boolean isSameTree(TreeNode commonNode, TreeNode subRoot){

        if(commonNode == null && subRoot == null){
            return true;
        }

        if(commonNode==null || subRoot==null){
            return false;
        }

        if(commonNode.left!=null && subRoot.left == null){
            return false;
        }
        
        if(commonNode.right == null && subRoot.right != null){
            return false;
        }

        if(commonNode.val != subRoot.val){
            return false;
        }

        return isSameTree(commonNode.left, subRoot.left) && isSameTree(commonNode.right, subRoot.right);

    }
}
