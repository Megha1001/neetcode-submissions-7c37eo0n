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

//We visit each node once and store up to one full level at a time.
//TC : O(n), SC : O(N), in complete binary tree last level has O(n/2)nodes
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return res;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);

                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
