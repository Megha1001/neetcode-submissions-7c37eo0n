//TC : O((V+E) * E); // *E for each edge we run hasPath = E~V = O(V*V) = O(N*N)
//SC : O(V+E)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){ // =n since 1...n  // TC : O(V), SC : (V)
            adj.add(new ArrayList<>());
        }

        for(int e[] : edges){ // TC : O(E) for each edge we run hasPath
            int u = e[0];
            int v = e[1];

            boolean[]visited = new boolean[n+1]; // n+1 since 1...n , SC : (V)

            if(!adj.get(u).isEmpty() && !adj.get(v).isEmpty() && hasPath(adj, u, v, visited)){
                return e;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
        
    }

    private boolean hasPath(List<List<Integer>>adj, int u, int v, boolean[]visited){
        if(u == v){
            return true;
        }
        visited[u] = true;
        for(int nei : adj.get(u)){ // SC : O(E)
            if(!visited[nei]){
                if(hasPath(adj, nei, v, visited)){
                    return true;
                }
            }
        }

        return false;
    }
}
