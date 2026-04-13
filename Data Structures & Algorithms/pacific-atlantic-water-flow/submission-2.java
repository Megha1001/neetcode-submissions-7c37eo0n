//TC : O(rows * cols), SC : O(rows * cols)
class Solution {
    private int ROWS;
    private int COLS;
    private int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //Reversing thinking for bfs and dfs
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][]pacific = new boolean[ROWS][COLS];
        boolean[][]atlantic = new boolean[ROWS][COLS];

        //for top and bottom row
        for(int c = 0; c < COLS; c++){
            dfs(heights, 0, c, pacific);
            dfs(heights, ROWS - 1, c, atlantic);
        }

        //left and right column
        for(int r = 0; r < ROWS; r++){
            dfs(heights, r, 0, pacific);
            dfs(heights, r, COLS - 1, atlantic);
        }

        List<List<Integer>>res = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
        
    }

    private void dfs(int[][]heights, int r, int c, boolean[][]visited){
        if(visited[r][c]) return;
        visited[r][c] = true;

        for(int[]dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nc >= 0
            && nr < ROWS && nc < COLS
            && !visited[nr][nc] 
            && heights[nr][nc] >= heights[r][c]){
                dfs(heights, nr, nc, visited);
            }
        }
    }
}
