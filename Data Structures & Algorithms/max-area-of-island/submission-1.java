class Solution {

    public static int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    

    //Method - 1 : DFS : Use count number of island approach
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int maxArea = 0;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //indicate unvisited island
                if(grid[r][c] == 1){
                   maxArea = Math.max(maxArea, dfs(grid, r, c, 0));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int [][]grid, int r, int c, int localMax){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0; //visited
        int area = 1;

        for(int [] dir : directions){
            int row = dir[0];
            int col = dir[1];

            area += dfs(grid, r + row, c + col, localMax);
        }

        return area;
    }


}
