class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        For example : "neetcode", wordDict = ["neet", "leet", "code"];
        dp[] = new boolean[s.length()+1]
        dp[8] = true
        dp[7] = invalid length(i+w.length = 7+4 <= 8(s.length)-> not) = false;
        dp[6] = false
        dp[5] = false
        dp[4] = true
        dp[3] = false
        dp[2] = false
        dp[1] = false
        dp[0] = true = dp[i + w.length() for which that matched]

        return dp[0]
        */
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        //base case
        dp[n] = true;

        for(int i = n - 1; i >= 0; i--){
            for(String w : wordDict){
                if((i + w.length() <= n) && (s.substring(i, i+w.length()).equals(w))){ // this is making sure that i+w.length has matching string in wordDict
                    dp[i] = dp[i + w.length()]; //for rest after i+w.length
                } //dp[i]  = s.substring(i, i+w.length()).equals(w) && dp[i+w.length()];
                if(dp[i] == true){
                    break;
                }
            }
        }

        return dp[0];

    }
}
