class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp [] = new int[amount + 1];
        Arrays.fill(dp, amount + 1); //amount+1 can never be possible
        dp[0] = 0; // we need 0 coins to make 0 amount
        /*
        default value Integer.MAX_VAL can cause overflow
        default value -1 can cause invalid results
        */

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);// 1 + dp[i - coin] because we have considered coin as valid selection
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}
