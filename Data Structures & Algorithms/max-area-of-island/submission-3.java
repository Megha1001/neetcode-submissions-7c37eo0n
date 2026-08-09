class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int maxArea = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    maxArea = Math.max(maxArea, bfs(grid, r, c));
                }
            }
        }
        
        return maxArea;
    }

    private int bfs(int[][]grid, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();

        grid[r][c] = 0;
        q.offer(new int[]{r, c});
        int area = 0;

        int directions[][] = {{1, 0}, {- 1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int p[] = q.poll();
            ++area;
            int row = p[0];
            int col = p[1];
            for(int dir[] : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >= 0 && nc >= 0
                && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return area;
    }
}
