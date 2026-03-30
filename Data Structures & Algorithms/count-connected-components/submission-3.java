class Solution {

    public int countComponents(int n, int[][] edges) {
    
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        } 

        for(int i=0; i<edges.length; i++){
           int u = edges[i][0];
           int v = edges[i][1];
           addAnEdge(adj, u, v);
        }

        return countComponents(adj,n);
    }

    public void addAnEdge(ArrayList<ArrayList<Integer>> adj , int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static int countComponents(ArrayList<ArrayList<Integer>> adj, int n){
        int components=0;
        boolean [] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                ++components;
                bfs(adj, i, visited);
            }
        }
        return components;
    }

    public static void bfs(ArrayList<ArrayList<Integer>>adj, int s, boolean[] visited){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int p = q.poll();
            for(int i : adj.get(p)){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
