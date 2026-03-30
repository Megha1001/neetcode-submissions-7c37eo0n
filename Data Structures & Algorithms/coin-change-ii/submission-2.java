class Solution {

    //bottom up
    public int change(int amount, int []coins){
        int n = coins.length;
        Arrays.sort(coins);
        int dp[][] = new int[n+1][amount+1];
        /*
        dp[i][a] = Number of ways to make amount a using coins from i index onwards
        dp[i][a] = dp[i+1][a] + dp[i][a-coin[i]]; //skip or dont skip. help to remove duplicates as well
        */
        
        //populate first column with value 1
        /*
        dp[i][0] = there is always 1 way to make amount 0 , i.e. dont choose anything
        */

        for(int i = 0 ; i <= n; i++){
            dp[i][0] = 1;
        }


        for(int i = n-1; i >= 0; i--){
            for(int a = 0; a <= amount; a++){ //starting from 1 as for 0 we have for loop above
                if(a >= coins[i]){
                    dp[i][a] = dp[i+1][a] + dp[i][a - coins[i]]; //skip or consider
                }
            }
        }

        return dp[0][amount];

    }


    public int changeTopDown(int amount, int[] coins) {
        Arrays.sort(coins);
        int memo[][] = new int[coins.length + 1][amount + 1];

        for(int[]row : memo){
            Arrays.fill(row, -1);
        }
        return dfs(0, amount, coins, memo);
    }

    private int dfs(int i, int a, int coins[], int[][]memo){
        if(a == 0){
            return 1;
        }

        if(i >= coins.length){
            return 0;
        }

        if(memo[i][a]!=-1){
            return memo[i][a];
        }

        int res = 0;
        if(a >= coins[i]){
            res = dfs(i+1, a, coins, memo) + dfs(i, a - coins[i], coins, memo);
        }
        memo[i][a] = res;
        return res;
    }
}
