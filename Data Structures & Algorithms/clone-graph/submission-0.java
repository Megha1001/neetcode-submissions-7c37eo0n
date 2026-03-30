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
    //Method - 1 Use BFS
    public Node cloneGraph(Node node) {
        //base case - node is null
        if(node == null){
            return null;
        }

        Map<Node, Node> cloned = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);
        cloned.put(node, new Node(node.val));

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(Node neighbor : curr.neighbors){
                //check visited
                if(!cloned.containsKey(neighbor)){ //this creates node
                    cloned.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }

                //this creates connection/branch b/w node
                cloned.get(curr).neighbors.add(cloned.get(neighbor));
                /* cloned.get(curr) -> cloneNode
                cloned.get(neighbor) -> clonedNeighbor
                cloneNode.add(cloned.get(neighbor)); // creates connection/branch b/w cloneNode and clonedNeighbor
                */

            }
        }

        return cloned.get(node);

    }
}