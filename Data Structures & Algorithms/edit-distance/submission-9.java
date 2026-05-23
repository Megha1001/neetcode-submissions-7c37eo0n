class Solution {
    private int memo[][];
    public int minDistance(String word1, String word2) {
        //top down -> from right to left
        int m = word1.length();
        int n = word2.length();
        memo = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(memo[i], -1);
        }
        return solve (m, n, word1, word2);
    }

    private int solve(int m , int n, String s1, String s2){
        if(m == 0 || n == 0){
            return m + n;
        }

        if(memo[m][n] != -1){
            return memo[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return memo[m][n] = solve(m - 1, n - 1, s1, s2);
        }

        int insert = 1 + solve(m, n - 1, s1, s2);
        int delete = 1 + solve(m - 1, n, s1, s2);
        int replace = 1 + solve(m - 1, n - 1, s1, s2);

        return memo[m][n] = Math.min(Math.min(insert, delete), replace);
    }
}
