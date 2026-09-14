class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(adj, 0, -1, hasApple);
    }

    private int dfs(List<List<Integer>>adj, int curr, int parent, List<Boolean>hasApple){
        int time = 0;

        for(int child : adj.get(curr)){
            if(child == parent){
                continue;
            }

            int childTime = dfs(adj, child, curr, hasApple);
            if(childTime > 0 || hasApple.get(child)){
                time += 2 + childTime;
            }
        }

        return time;
    }
}