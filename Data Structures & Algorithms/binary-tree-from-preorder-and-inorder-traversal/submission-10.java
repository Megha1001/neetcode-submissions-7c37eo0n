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
    private int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        IDEA : For every preorder element search in inorder array and buidtree
        */
        if(preorder.length != inorder.length){
            return null;
        }

        int n = preorder.length;
        preIndex = 0;
        Map<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        return buildTree(map, preorder, 0, n-1);
    }

    private TreeNode buildTree(Map<Integer, Integer>map, int[]pre, int is, int ie){
        if(is > ie){
            return null;
        }

        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = map.get(root.val);
        root.left = buildTree(map, pre, is, inIndex - 1);
        root.right = buildTree(map, pre, inIndex + 1, ie);
        return root;
    } 
}
