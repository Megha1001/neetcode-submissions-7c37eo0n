class Solution {
    public int countComponents(int n, int[][] edges) {
        //DFS traversal
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            addAnEdge(adj, u, v);
        }

        boolean[]visited = new boolean[n]; //for vertex
        int components = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(adj, i, visited);
                ++components;
            }
        }
        return components;
    }


    private void dfs(ArrayList<ArrayList<Integer>>adj, int i, boolean[] visited){
        visited[i] = true; //marked

        //get the neighbor
        for(int neighbor : adj.get(i)){
            if(!visited[neighbor]) dfs(adj, neighbor, visited);
        }

    }

    private void addAnEdge(ArrayList<ArrayList<Integer>> adj, int u , int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
