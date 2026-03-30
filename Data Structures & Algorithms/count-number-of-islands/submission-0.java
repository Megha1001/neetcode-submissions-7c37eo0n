class Solution {

    /*
    Idea : for every grip Use dfs when grid[r][c] == '1'
        -> Enque the positioin int[]{r,c} in queue;
        and make grid[r][c] as visited by setting grip[r][c] = '0'
        -> while q is not empty
            -> pop from queue
            -> int row = pop[0], int col= pop[1]
            -> Run a for loop for all directions = {{1,0},{-1,0},{0,1},{0,-1}} //dont consider diagonal as mentioned in question consider horizontal, vertical
                -> check the position limits && pos[nr][nc]=='1'
                    ->enque in queue
                    ->pos[nr][nc]='0';
    */

    public static int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int islands=0;
        int ROWS = grid.length;
        int COL = grid[0].length;

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COL; c++){
                if(grid[r][c]=='1'){
                    bfs(grid, r, c);
                    ++islands;
                }
            }
        }

        return islands;
    }

    public void bfs(char[][]grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c] = '0'; //marking visited

        while(!q.isEmpty()){
            int [] element = q.poll();
            int row = element[0];
            int col = element[1];

            //check in all four directions
            for(int [] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >= 0 && nr < grid.length
                && nc >= 0 && nc < grid[0].length
                && grid[nr][nc] == '1'){
                    grid[nr][nc] ='0'; //visited
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
