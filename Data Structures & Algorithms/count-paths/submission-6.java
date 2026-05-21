//TC : O(M*N)
//SC : O(M*N)
class Solution {
    private int memo[][];
    public int uniquePaths(int m, int n) {

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
