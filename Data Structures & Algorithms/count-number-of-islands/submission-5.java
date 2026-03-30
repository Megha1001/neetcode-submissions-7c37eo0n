class Solution {
    private int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    private int ROWS, COLS;
    public int numIslands(char[][] grid) {

        //Way -1 BFS

        int islands = 0;
        ROWS = grid.length;
        COLS = grid[0].length;

        if(ROWS == 0){
            return 0;
        }

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    ++islands;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][]grid, int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0'; //visited

        while(!q.isEmpty()){
            int[] entry = q.poll();
            int row = entry[0];
            int col = entry[1];

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >= 0 && nr < ROWS 
                && nc >= 0 && nc < COLS
                && grid[nr][nc] == '1'){
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
