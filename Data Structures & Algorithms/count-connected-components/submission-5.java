//TC : O(N+M) : building adj matrix + O(N+M) : each node visited once and each edge visited twice
//SC : O(N+M) : building adj matrix + O(N) : for visiting + O(N) : for recursion call stack
class Solution {
    public int countComponents(int n, int[][] edges) {
        //DFS traversal
        //SC : O(N+M)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //TC : because of below two loops : O(M+N)
        for(int i = 0; i < n; i++){ // O(N)
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){ //O(M), where m is number of edges
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //SC : O(N)
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
        //SC : O(N) : recursion call stack
        //TC : O(N+M) : each node visited once and each edge visited twice
        for(int neighbor : adj.get(i)){
            if(!visited[neighbor]) dfs(adj, neighbor, visited);
        }

    }
}
