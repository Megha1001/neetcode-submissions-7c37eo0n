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
//TC : O(H+K) can go to O(N) skewed and k = N
// SC : O(H)
class Solution {

    public int kthSmallest(TreeNode root, int k) {
        /*
        Use stack
        - Push in stack until we go to left
        - Pop from stack and decrement k and check
        - Push right
        - repeat
        */
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(--k == 0){
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }

    // private int k;
    // private int ans;
    // public int kthSmallest(TreeNode root, int k) {
    //     this.k = k;
    //     dfs(root);
    //     return ans;
    // }

    // private void dfs(TreeNode node){
    //     if(node == null){
    //         return;
    //     }
    //     dfs(node.left);
    //     if(--k == 0){
    //         this.ans = node.val; 
    //         return;
    //     }
    //     dfs(node.right);
    // }
}
