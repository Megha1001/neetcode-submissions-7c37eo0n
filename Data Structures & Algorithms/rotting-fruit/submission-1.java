//TC : O(rows * cols), SC : O(rows * cols)
class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int fresh = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < ROWS; i++){ //O(rows * cols)
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    ++fresh;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int time = 0;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();

                for(int []dir : directions){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr >= 0 && nr < ROWS
                    && nc >=0 && nc < COLS
                    && grid[nr][nc] == 1){
                        --fresh;
                        grid[nr][nc] = 2; //marked rotten
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            ++time;
        }

        return fresh == 0 ? time : -1;

        
    }
}
