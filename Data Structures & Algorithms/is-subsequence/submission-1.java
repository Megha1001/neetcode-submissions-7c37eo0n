class Solution {
    public boolean isSubsequence(String s, String t) {
        //Recursive - Brute force
        // return isSubsequence(s, t, s.length(), t.length());  
        
        int m = s.length();
        int n = t.length();
        
        boolean dp[][] = new boolean[m+1][n+1];

        //for first row
        for(int i = 0; i <= n; i++){
            dp[0][i] = true;
        }

        //for first column
        for(int j = 1; j <= m; j++){
            dp[j][0] = false;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }

    public boolean isSubsequence(String s, String t, int m, int n){
        if(m == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(s.charAt(m-1) == t.charAt(n-1)){
            return isSubsequence(s, t, m - 1, n - 1);
        }else{
            return isSubsequence(s, t, m, n - 1);
        }

    }
}