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
    // Using BFS
    // public int goodNodes(TreeNode root) {
    //     //Maintain the max seen so far and do preorder traversal
    //     int max = Integer.MIN_VALUE;
    //     return countGoodNodes(root, max);
    // }

    // public int countGoodNodes(TreeNode root, int max){
    //     if(root == null){
    //         return 0;
    //     }
        
    //     int count = 0;
    //     if(max <= root.val){
    //         count = 1;
    //         max = root.val;
    //     }

    //     count += countGoodNodes(root.left, max);
    //     count += countGoodNodes(root.right, max);
        
    //     return count;
    // }

    //USING DFS
    public int goodNodes(TreeNode root) {
        int count=0;
        //root can never be null; 1 <= number of nodes in the tree <= 100

        ArrayDeque<Pair<TreeNode, Integer>> q = new ArrayDeque<>(); //Node, maxSeenSoFar
        q.offer(new Pair<>(root, Integer.MIN_VALUE));


        while(!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();
            int maxValue = p.getValue();
            TreeNode node = p.getKey();
            if(node.val >= maxValue){
                ++count;
                maxValue = node.val;
            }

            if(node.left != null){
                q.offer(new Pair<>(node.left, maxValue));
            }

            if(node.right != null){
                q.offer(new Pair<>(node.right, maxValue));
            }
        }


        return count;
    }
}
