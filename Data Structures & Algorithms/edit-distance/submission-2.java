class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        return editDistanceUsingDP(word1, word2, m , n);
    }

    //Tabulation
    public int editDistanceUsingDP(String s1, String s2, int m, int n){

        int dp[][] = new int[m+1][n+1];

        //base cases 

        //1. for first row
        for(int i = 0; i <=n; i++){
            dp[0][i] = i;
        }

        //2. for first column
        for(int i = 0; i <=m; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                }
            }
        } 

        return dp[m][n];

    }

    // Without DP -> cause TLE in leetcode
    public int editDistance(String s1, String s2, int m , int n){

        if(m == 0){
            return n; //n insertions
        }

        if(n == 0){
            return m; //m deletions
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return editDistance(s1, s2, m-1, n-1);
        }

        else {
            return 1 + Math.min(Math.min(editDistance(s1, s2, m, n-1), //insert
                            editDistance(s1, s2, m-1, n)),//delete
                            editDistance(s1, s2, m-1, n-1)) ; //replace
                            //1 is for the operations
        }


    }
}
