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
//TC : O(N), traversing every node once, SC : O(N) : width of tree , in case of complete BST it can be N/2
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                if(leftToRight){
                    TreeNode curr = q.pollFirst();
                    list.add(curr.val);
                    if(curr.left != null){
                        q.offerLast(curr.left);
                    }

                    if(curr.right != null){
                        q.offerLast(curr.right);
                    }
                }else{
                    TreeNode curr = q.pollLast();
                    list.add(curr.val);
                    if(curr.right != null){
                        q.offerFirst(curr.right);
                    }
                    if(curr.left != null){
                        q.offerFirst(curr.left);
                    }
                }
            }
            res.add(list);
            leftToRight = !leftToRight;
        }

        return res;
        
    }
}