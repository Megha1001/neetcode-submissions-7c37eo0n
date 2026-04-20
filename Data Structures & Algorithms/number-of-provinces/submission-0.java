//TC : O(N)
// SC : O(N)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, i, visited);
                ++provinces;
            }
        }
        return provinces;
    }

    private void dfs(int[][]isConnected, int i, boolean[]visited){
        visited[i] = true;

        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(isConnected, j, visited);
            }
        }
    }
}