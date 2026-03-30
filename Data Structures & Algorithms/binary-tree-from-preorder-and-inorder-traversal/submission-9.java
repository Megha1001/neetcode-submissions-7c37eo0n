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

public class Solution {
    public static int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length != inorder.length){
            return null;
        }
        preIndex = 0;
        /*
        IDEA : For every preorder element, 
        search in indorder array and buildTree
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        for(int i=0; i<n ; i++){
            map.put(inorder[i], i);
        }

        return buildTree(map, preorder, 0, n-1);
    }

    public TreeNode buildTree(HashMap<Integer, Integer>map, int []pre, int is, int ie){
        //NLR
        if(is > ie){
            return null;
        }

        TreeNode root = new TreeNode(pre[preIndex++]);

        if(root == null){
            return null;
        }
        int inIndex = map.get(root.val);
        root.left = buildTree(map, pre, is, inIndex-1);
        root.right = buildTree(map, pre, inIndex+1, ie);

        return root;
    }

}