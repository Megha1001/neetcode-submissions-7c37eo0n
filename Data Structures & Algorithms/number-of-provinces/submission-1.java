class Solution {
    public int findCircleNum(int[][] isConnected) {
        //Using BFS
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(isConnected, visited, i);
                ++provinces;
            }
        }

        return provinces;
        
    }

    private void bfs(int[][]isConnected, boolean[]visited, int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int i = 0; i < isConnected.length; i++){
                if(isConnected[curr][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}