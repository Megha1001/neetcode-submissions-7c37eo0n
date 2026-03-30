class Solution {
    public int minCostClimbingStairsUsingBottomUpApproach(int[] cost) {

        /*
        Minimum cost from i to reach end is = cost[i] + Math.min(min cost to reach at end from i+1, min cost to reach at end from i+2)
        */
        int n = cost.length;
        int dp[] = new int[n+1];
        dp[n] = 0; //to reach top , out of bound from problem index
        dp[n-1] = cost[n-1];

        for(int i = n-2; i >= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
        
    }


    public int minCostClimbingStairs(int[] cost) {

        /*
        Minimum cost from i to reach end is = cost[i] + Math.min(min cost to reach at end from i+1, min cost to reach at end from i+2)
        */
        int n = cost.length;
        int prev1 = cost[n-1];
        int prev2 = 0; //top position

        for(int i = n-2; i >= 0; i--){
            int temp = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = temp;
        }

        return Math.min(prev1, prev2);
        
    }

}
