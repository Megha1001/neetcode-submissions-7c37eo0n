class Solution {
    private int n;
    private Set<String> set;
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        set = new HashSet<>(wordDict);
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(s, 0);
    }

    private boolean solve(String s, int idx){
        if(idx == n){
            return true;
        }
        if(set.contains(s.substring(idx, n))){
            return true;
        }

        if(memo[idx] != -1){
            return memo[idx] == 1;
        }

        for(int len = 1; len <= n; len++){
            if(idx + len > n){
                break;
            }
            String temp = s.substring(idx, idx + len);
            if(set.contains(temp) && solve(s, idx + len)){
                memo[idx] = 1;
                return true;
            }
        }
        memo[idx] = 0;
        return false;
    }
}
