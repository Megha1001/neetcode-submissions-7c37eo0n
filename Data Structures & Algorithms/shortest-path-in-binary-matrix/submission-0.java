class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        /*
        Patter : BFS (Shortest, 8 directional visit)
        */
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1; //visited

        int path = 1; // explored q.offer(new int[]{0,0});
        
        int [][] directions = {{0,-1},{0,1},{1,0},{-1,0},{1,-1},{1,1},{-1,1},{-1,-1}};

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();

                if(curr[0] == n-1 && curr[1] == n-1){
                    return path;
                }

                for(int[] dir : directions){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0){
                        grid[nr][nc] = 1; //visited
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            ++path;
        }


        return -1;
        
    }
}