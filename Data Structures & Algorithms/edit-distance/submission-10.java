class Solution {
    public int minDistance(String word1, String word2) {
        //Bottom up
        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m + 1][n + 1];
        
        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }

        for(int j = 0; j <= m; j++){
            dp[j][0] = j;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }

        return dp[m][n];
        
    }
}
