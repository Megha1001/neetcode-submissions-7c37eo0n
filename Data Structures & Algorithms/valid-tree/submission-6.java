// TC : O(V+E)
// SC : O(V+E) : due to adjacency list
class Solution {
    public boolean validTree(int n, int[][] edges) {
        /*
        Tree is valid when
        -> it has no cycle
        -> all nodes are reachable from node 0;
        -> edges == n-1
        */

        if(edges.length != n-1){
            return false;
        }

        //build adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // O(V+E)
        for(int i = 0; i < n; i++){ //O(V)
            adj.add(new ArrayList<>());
        }

        for(int [] e : edges){ //O(E)
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean [] visited = new boolean[n];
        if(hasCycle(adj, 0, -1, visited)){
            return false;
        }

        for(boolean v : visited){
            if(!v){
                return false;
            }
        }

        return true;

    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int curr, int parent, boolean[]visited){
        visited[curr] = true;
        for(int u : adj.get(curr)){
            if(!visited[u]){
                if(hasCycle(adj, u, curr, visited)){
                    return true;
                }
            }else if(u != parent){
                return true;
            }
        }
        return false;
    }
}
