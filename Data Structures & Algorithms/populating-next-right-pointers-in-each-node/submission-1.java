/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {

        //Approach -1 BFS with Auxiliary space
        //TC: O(N), SC : O(N)
        // if(root == null){
        //     return null;
        // }

        // Queue<Node> q = new ArrayDeque<>();
        // q.offer(root);

        // while(!q.isEmpty()){
        //     int size = q.size();
        //     Node prev = null;
        //     for(int i = 0; i < size; i++){
        //         Node curr = q.poll();
        //         if(prev != null){
        //             prev.next = curr;
        //         }
        //         prev = curr;
        //         if(curr.left != null) q.offer(curr.left);
        //         if(curr.right != null) q.offer(curr.right);
        //     }
        // }
        // return root;
        

        //Approach -2 : Use the fact of  perfect binary tree
        //TC : O(N), SC : O(1)
        if(root == null){
            return null;
        }

        Node leftStart = root;

        while(leftStart.left != null){
            Node curr = leftStart;
            //level traversing
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftStart = leftStart.left;
        }

        return root;

    }
}