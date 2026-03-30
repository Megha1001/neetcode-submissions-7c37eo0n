class Solution {
    private Set<String> set;
    private Boolean[] memo;
    private int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        //Recursion + Memoization

        n = s.length();
        memo = new Boolean[n];
        set = new HashSet<>(wordDict);
        return helper(s, 0, wordDict);
    }

    private boolean helper(String s, int idx, List<String>wordDict){
        if(idx == n){
            return true;
        }

        if(memo[idx] != null){
            return memo[idx];
        }

        for(int end = idx+1; end <= n; end++){
            if(wordDict.contains(s.substring(idx, end)) && helper(s, end, wordDict)){
                return memo[idx] = true;
            }
        }

        return memo[idx] = false;
    }
}
