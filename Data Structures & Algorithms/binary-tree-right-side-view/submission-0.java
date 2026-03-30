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
    public List<Integer> rightSideView(TreeNode root) {
        //levelOrder right most child on every level
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0; i<levelSize; i++){
                TreeNode curr = queue.poll();
                if(i == levelSize-1){
                    res.add(curr.val);
                }

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }

        return res;

    }
}
