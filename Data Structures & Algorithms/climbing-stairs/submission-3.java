class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return dfs(n-1, memo) + dfs(n-2, memo);
    }

    public int dfs(int n, int []memo){
        if(n==0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = dfs(n-1, memo) + dfs(n-2, memo);

        return memo[n];
    }
}
