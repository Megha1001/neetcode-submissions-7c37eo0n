class Solution {
    private int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        //Approach - 1 Recursion : TLE
        // solve(coins, amount , 0);
        // return res == Integer.MAX_VALUE ? -1 : res;

        //Approach - 2 Memoization
        int memo[] = new int[amount + 1]; //min coins needed for this amount
        Arrays.fill(memo, - 1);
        int ans = solve(coins, memo, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int[]coins, int[]memo, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        if(memo[amount] != -1){
            return memo[amount];
        }
        
        int minCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int sub = solve(coins, memo, amount - coins[i]);
            if(sub != Integer.MAX_VALUE){ // if otherwise 1+sub will overflow when sub = Integer.MAX_VALUE
                minCoins = Math.min(minCoins, 1 + sub); 
            }
            
        }
        memo[amount] = minCoins;

        return memo[amount];
    }

    private void solve(int[] coins, int amount, int count){
        if(amount == 0){
            res = Math.min(res, count);
            return;
        }
        if(amount < 0){
            return;
        }

        for(int i = 0; i < coins.length; i++){
            solve(coins, amount - coins[i], count + 1);
        }
    }
}
