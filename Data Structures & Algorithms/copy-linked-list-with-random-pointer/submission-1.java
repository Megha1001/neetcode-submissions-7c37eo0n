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
    // public Node copyRandomList(Node head) {
    //     if(head == null){
    //         return null;
    //     }

    //     HashMap<Node, Node> cloned = new HashMap<>();

    //     //populate all nodes
    //     for(Node curr = head; curr != null; curr = curr.next){
    //         cloned.put(curr, new Node(curr.val));
    //     }

    //     //attach connections
    //     for(Node curr = head; curr != null; curr = curr.next){
    //         Node clone = cloned.get(curr);
    //         clone.next = cloned.get(curr.next);
    //         clone.random = cloned.get(curr.random);
    //     }

    //     return cloned.get(head);
        
    // }

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            Node random = new Node(curr.val);
            curr.next = random;
            random.next = next;
            curr = next;
        }

        //copy random reference
        for(Node oldHead = head; oldHead != null ; oldHead = oldHead.next.next){
            oldHead.next.random = oldHead.random == null ? null : oldHead.random.next;
        }

        //seperate
        Node randomHead = head.next;
        Node clonedHead = head.next;

        for(Node oldHead = head; oldHead != null ; oldHead = oldHead.next){
            oldHead.next = oldHead.next.next;
            clonedHead.next = clonedHead.next == null ? null : clonedHead.next.next;
            clonedHead = clonedHead.next;
        }

        return randomHead;


    }
}
