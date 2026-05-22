//TC : O(M*N)
//SC : O(M*N)
class Solution {
    private int m;
    private int n;
    private int[][]memo;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }

        return solve(0, 0, grid);
    }

    private int solve(int r, int c, int[][]grid){
        if(r == m-1 && c == n-1){
            return grid[r][c];
        }

        if(r >=m || c >=n){
            return Integer.MAX_VALUE;
        }

        if(memo[r][c] != -1){
            return memo[r][c];
        }

        int down = solve(r + 1, c , grid);
        int right = solve(r, c + 1, grid);

        int bestValue = Math.min(down, right);
        return memo[r][c] = grid[r][c] + bestValue;
    }
}