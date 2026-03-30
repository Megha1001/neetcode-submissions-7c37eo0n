class Solution {
    public boolean validTree(int n, int[][] edges) {

        // IDEA
        /*
        If there is a cycle in the un-directed graph then it can't be graph valid tree
        */

        //create adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);

        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // Pass parent to check for cycle

        boolean []visited = new boolean[n];
        int components = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                ++components;
                if(isCycleExists(adj, i, -1, visited)){
                    return false;
                }
            }
        }

        if(components > 1){
            return false;
        }

        return true;
    }

    public boolean isCycleExists(ArrayList<ArrayList<Integer>>adj, int curr, int parent, boolean [] visited){
        visited[curr] = true;

        //check for neighbor
        for(int neighbor : adj.get(curr)){
            if(!visited[neighbor]){
                if(isCycleExists(adj, neighbor, curr, visited)){
                    return true;
                }
            }else if (parent != neighbor){
                return true;
            }
        }
        return false;
    }
}
