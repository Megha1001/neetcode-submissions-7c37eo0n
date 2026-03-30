class Solution {
    private int memo[][];
    public int longestCommonSubsequence(String text1, String text2) {
       int m = text1.length();
       int n = text2.length();

       memo = new int[m+1][n+1];

       for(int i = 0; i <= m; i++){
            Arrays.fill(memo[i], -1);
       }

       return dfs(text1, text2, m, n);
    }

    private int dfs(String text1, String text2, int m, int n){
        if(memo[m][n] != -1){
            return memo[m][n];
        }

        if(m == 0 || n == 0){
            memo[m][n] = 0;
        }

        else{
            if(text1.charAt(m-1) == text2.charAt(n-1)){
                memo[m][n] = 1 + dfs(text1, text2, m - 1, n - 1);
            }else{
                memo[m][n] = Math.max(dfs(text1, text2, m, n - 1), dfs(text1, text2, m - 1, n));
            }
        }

        return memo[m][n];
    }
}
