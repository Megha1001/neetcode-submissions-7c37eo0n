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
 //TC : O(H)
 // SC : O(H)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        /*
         - Node with value k is leaf delete it make value null;
         - node has only one child -> replace it with the children value
         - node has two child -> find successor or predecessor and delete the succ or predecessor node
        */

        if(root == null){
            return null;
        }

        if(root.val > key){
            //go to left
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            //go to right
            root.right = deleteNode(root.right, key);
        }

        else{
            // found key
            //have zero child or have only right child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            //two childrens - find successor
            TreeNode succ = findSuccessor(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }

        return root;
        
    }

    private TreeNode findSuccessor(TreeNode curr){
        while(curr.left != null) curr = curr.left;
        return curr;
    }
}