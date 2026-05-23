//TC : O(M*N)
//SC : O(M*N)
class Solution {
    private int m;
    private int n;
    private int [][]memo;
    public int minDistance(String word1, String word2) {
        //Recursion + Memoization
        m = word1.length();
        n = word2.length();

        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }

        return solve(word1, word2, 0, 0);
    }

    private int solve(String s1, String s2, int i, int j){
        //base case
        if(i == m){
            return n-j; //insert
        }
        else if(j == n){
            return m-i; //deletion
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return memo[i][j] = solve(s1, s2, i + 1, j + 1);
        }

        int insert = 1 + solve(s1, s2, i, j + 1);
        int delete = 1 + solve(s1, s2, i + 1, j);
        int replace = 1 + solve(s1, s2, i + 1, j + 1);

        return memo[i][j] = Math.min(Math.min(insert, delete), replace);
    }
}
