/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        HashMap<Node, Node> cloned = new HashMap<>();

        //populate all nodes
        for(Node curr = head; curr != null; curr = curr.next){
            cloned.put(curr, new Node(curr.val));
        }

        //attach connections
        for(Node curr = head; curr != null; curr = curr.next){
            Node clone = cloned.get(curr);
            clone.next = cloned.get(curr.next);
            clone.random = cloned.get(curr.random);
        }

        return cloned.get(head);
        
    }
}
