class Solution {
    private int ROWS;
    private int COLS;
    private int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int islands = 0;

        if(ROWS == 0){
            return islands;
        }

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == '1'){
                    bfs(grid, r, c);
                    ++islands;
                }
            }
        }
        return islands;
    }

    private void bfs(char [][] grid, int r, int c){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0'; //visited

        while(!q.isEmpty()){
            int node[] = q.poll();
            int row = node[0];
            int col = node[1];

            for(int [] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >=0 && nr < ROWS
                && nc >=0 && nc < COLS
                && grid[nr][nc] == '1'){
                    grid[nr][nc] = '0';
                    bfs(grid, nr, nc);
                }
            }
        }
    }
}
