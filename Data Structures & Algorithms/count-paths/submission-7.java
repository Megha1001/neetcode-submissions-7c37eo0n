//TC : O(M*N)
//SC : O(M*N)
class Solution {

    public int uniquePaths(int m, int n){
        int dp[][] = new int[m][n];

        for(int r = 0; r < m; r++){
            dp[r][0] = 1;
        }

        for(int c = 1; c < n; c++){
            dp[0][c] = 1;
        }

        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                dp[r][c] = dp[r - 1][c] + dp[r][c-1];
            }
        }

        return dp[m-1][n-1];
    }


    private int memo[][];
    public int uniquePathsTopDown(int m, int n) {

        //Grid based DP
        // unique[m-1][n-1]  = unique[m-1-1][n-1] + unique[m-1][n-1-1]
        memo = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        return solve(0, 0, m, n);
    }

    private int solve(int r, int c, int m, int n){
        if(r == m-1 && c == n-1){
            return 1;
        }

        if(r >= m || c >= n){
            return 0;
        }

        if(memo[r][c] != -1){
            return memo[r][c];
        }

        int down = solve(r + 1, c, m, n);
        int right = solve(r, c + 1, m, n);

        return memo[r][c] = down + right;
    }
}
