class Solution {
    public int orangesRotting(int[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;

        int fresh = 0;
        int time = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    ++fresh;
                }

                else if(grid[r][c] == 2){ //rotten
                    q.offer(new int[]{r, c});
                }
            }
        }
        
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        while(fresh > 0 && !q.isEmpty()){
            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++){
                int []p = q.poll();
                int row = p[0];
                int col = p[1];

                //check in directions
                for(int[] dir : directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr >=0 && nc>=0 
                    && nr < grid.length && nc < grid[0].length
                    && grid[nr][nc] == 1){
                        grid[nr][nc] = 2; //mark rotten/visited
                        --fresh;
                        q.offer(new int[]{nr, nc});
                    }
                }

            }

            ++time; // IMP : when we have multiple sources it should increment when we discover neighbor of multiple sources
        }

        return fresh == 0 ? time : -1;

    }
}
