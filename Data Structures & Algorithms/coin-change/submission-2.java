class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; //we need 0 coint to make amount of 0. dp[i] = x; we need x coins to make amount i

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}
