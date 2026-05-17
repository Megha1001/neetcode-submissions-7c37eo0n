//TC : O(N)
//SC : O(N)
class Solution {
    private int n;
    private int[]memo;
    public int numDecodings(String s) {
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
