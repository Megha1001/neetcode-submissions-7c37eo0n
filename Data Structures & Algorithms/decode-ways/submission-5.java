//TC : O(N)
//SC : O(N)
class Solution {

    //Bottom up approach
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }else {
                dp[i] = dp[i + 1];
                if(i + 1 < n){
                    if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')){
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }
        return dp[0];
    }
    
    private int n;
    private int[]memo;
    public int numDecodingsTopDown(String s) {
        //Top down approach
        n = s.length();
        memo = new int[101]; //n+1 possible states --> compute for them and every state compute once
        Arrays.fill(memo, -1);

        return solve(0, s);
    }

    private int solve(int idx, String s){
        if(memo[idx] != -1){
            return memo[idx];
        }

        if(idx == n){
            return memo[idx] = 1;
        }

        if(s.charAt(idx) == '0'){
            return memo[idx] = 0;
        }

        int result = solve(idx + 1, s);
        if(idx + 1 < n){
            if(s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6')){
                result += solve(idx + 2, s);
            }
        }
        return memo[idx] = result;
    }
}
