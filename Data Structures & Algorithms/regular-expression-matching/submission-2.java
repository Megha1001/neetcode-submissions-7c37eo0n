//TC : O(2^(max(m, n)))
//SC : O(max(m,n))
class Solution {
    private int[][]memo;
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        memo = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(memo[i], -1);
        }
        return solve(0, 0, s, p);
    }

    private boolean solve(int i, int j, String s, String p){
        if(j == p.length()){
            return i == s.length();
        }

        if(memo[i][j] != -1){
            return memo[i][j] == 1;
        }

        boolean ans = false;

        boolean is_first_char_matched = false;
        if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            is_first_char_matched = true;
        }

        if((j + 1) < p.length() && p.charAt(j+1) == '*'){
            boolean not_take = solve(i, j + 2, s, p);
            boolean take = is_first_char_matched && solve(i+1, j, s, p);
            ans = not_take || take;
        }else {
            ans = is_first_char_matched && solve(i + 1, j + 1, s, p);
        }

        return (memo[i][j] = ans ? 1 : 0) == 1;
    }
}
