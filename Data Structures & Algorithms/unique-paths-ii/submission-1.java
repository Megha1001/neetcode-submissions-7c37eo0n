class Solution {
    private int m;
    private int n;
    private int[][]memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        //Top down approach
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        memo = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }

        return solve(0, 0, obstacleGrid);
        
    }

    private int solve(int r, int c, int[][]obstacleGrid){
        if(r >= m || c >= n || obstacleGrid[r][c] == 1){
            return 0;
        }

        if(r == m-1 && c == n-1){
            return 1;
        }

        if(memo[r][c] != -1){
            return memo[r][c];
        }

        int down = solve(r + 1, c, obstacleGrid);
        int right = solve(r, c + 1, obstacleGrid);

        return memo[r][c] = down + right;
    }
}