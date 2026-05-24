//TC : O(M*N)
//SC : O(M*N)
class Solution {
    private int m;
    private int n;
    private int o;
    private Boolean memo[][];
    /*
     null -> undiscovered
     false -> not found
     true -> found
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        o = s3.length();

        if(m + n != o){
            return false;
        }

        memo = new Boolean[m + 1][n + 1];

        return solve(s1, s2, s3, 0 , 0);
    }

    private boolean solve(String s1, String s2, String s3, int i, int j){
        if(i == m && j == n && (i + j) == o){
            return true;
        }

        if((i + j) >= o){
            return false;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        boolean result = false;

        if(i < m && s1.charAt(i) == s3.charAt(i + j)){
            result = solve(s1, s2, s3, i + 1, j);
        }

        if(result){
          return memo[i][j] = result;
        }

        if(j < n && s2.charAt(j) == s3.charAt(i + j)){
            result = solve(s1, s2, s3, i, j + 1);
        }

        return memo[i][j] = result;
    }
}
