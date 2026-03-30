class Solution {
    //dp[i][j] = dp[i+1][j] + dp[i][j+1]
    public int uniquePaths(int m, int n) {
        int board[][] = new int[m+1][n+1];// +1 so we dont go out of bound
        board[m-1][n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                board[i][j] += board[i+1][j] + board[i][j+1]; //+= so last m-1,n-1 value dont get override
            }
        }

        return board[0][0];
        
    }
}
