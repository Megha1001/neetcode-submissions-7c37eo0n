class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //space optimized
        int prev2 = 0; //i-2
        int prev1 = 0; //i-1

        for(int i = 2; i <= n; i++){
            int curr = Math.min(prev2 + cost[i-2],
                                prev1 + cost[i-1]);

            prev2 = prev1; //i-2+1 = i-1 = prev1
            prev1 = curr; //i-1+1 = i = curr
        }

        return prev1;

    }
    public int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 0; //dp[i] = minimum cost to reach at ith step, dp[0], dp[1] can be reached in 0 cost from start

        for(int i = 2; i <= n; i++){
            //on dp[i], we can reach from dp[i-1] or dp[i-2]
            dp[i] = Math.min(dp[i-1] + cost[i-1],
                            dp[i-2] + cost[i-2]);
        }

        return dp[n];
        
    }
}
