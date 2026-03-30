/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        //BFS
        if(node == null){
            return node;
        }


        Queue<Node> q = new ArrayDeque<>();
        HashMap<Node, Node> oldToNew = new HashMap<>();

        q.offer(node);
        oldToNew.put(node, new Node(node.val));

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(Node neighbor : curr.neighbors){
                if(!oldToNew.containsKey(neighbor)){
                    oldToNew.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                oldToNew.get(curr).neighbors.add(oldToNew.get(neighbor));
            }
        }

        return oldToNew.get(node);
        
    }
}