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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return List.of();
        }

        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int levelSize = q.size();
            list = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            res.add(list);
        }

        return res;
        
    }
}
