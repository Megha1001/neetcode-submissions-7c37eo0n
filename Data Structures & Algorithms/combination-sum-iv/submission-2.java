class Solution {
    //TC : O(N*t)
    //SC : O(t)
    public int combinationSum4(int[] nums, int target) {
        //Bottom up
        //dp[i] = number of ways to make sum i
        int dp[] = new int[target + 1];
        dp[0] = 1; //to make sum 0 choose nothing

        for(int t = 1; t <= target; t++){
            for(int num : nums){
                if(t - num >= 0){
                    dp[t] += dp[t - num];
                }
            }
        }
        return dp[target];
    }


    private int memo[];
    public int combinationSum4TopDown(int[] nums, int target) {
        //Recursion + Memoization
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return solve(nums, target);     
    }

    private int solve(int[]nums, int target){
        if(target == 0){
            return 1;
        }

        if(target < 0){
            return 0;
        }

        if(memo[target] != -1){
            return memo[target];
        }

        int ways = 0;
        for(int num : nums){
            ways += solve(nums, target - num);
        }
        memo[target] = ways;
        return memo[target];
    }
}