class Solution {
    public static int directions [][] = {{0,1},{0,-1},{1,0},{-1,0}};
    /*
    IDEA : Use BFS from desitination to possible sources
        1. Find all the nodes with value 0 (that will be our source) and enqueue in queue
        2. For each element in queue 
            -> check the all the neighbors with value INF and update the value with popNode value + 1
    */
    public void islandsAndTreasure(int[][] grid) {

        //Method -1 BFS
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        //find all the nodes with val zero
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[]{r, c});
                }
            }
        }
        

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            //traverse all neighbors
            for(int [] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr < 0 || nc < 0 
                || nr >= grid.length || nc >= grid[0].length 
                || grid[nr][nc] != Integer.MAX_VALUE){
                    continue;
                }
                
                grid[nr][nc] = grid[row][col] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
    }
}
