class Solution {
    private int[][]memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        memo = new int[m + 1][n+1];

        for(int i = 0; i <= m; i++){
            Arrays.fill(memo[i], -1);
        }

        return solve(m, n, text1, text2);
    }

    private int solve(int m , int n, String s1, String s2){
        if(m <= 0 || n <= 0){
            return 0;
        }

        if(memo[m][n] != -1){
            return memo[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return memo[m][n] = 1 + solve(m - 1, n - 1, s1, s2);
        }

        int shift_m = solve(m - 1, n , s1, s2);
        int shift_n = solve(m, n - 1, s1, s2);

        return memo[m][n] =  Math.max(shift_m, shift_n);
    }
}
