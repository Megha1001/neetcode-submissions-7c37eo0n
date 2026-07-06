class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return - 1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0}); //row, column
        int path = 1;
        grid[0][0] = 1;
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                if(r == n - 1 && c == n - 1){
                    return path;
                }
                for(int[]dir : directions){
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            ++path;
        }


        return -1;
        
    }
}