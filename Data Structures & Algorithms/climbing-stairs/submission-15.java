class Solution {
    public int climbStairs(int n) {
        //Approach - 1 Recursion - TLE

        // if(n == 0){
        //     return 1;
        // }

        // if(n < 0){
        //     return 0;
        // }

        // return climbStairs(n - 1) + climbStairs(n - 2);


        //Approach-2 : 1D - memoization
        // int memo[] = new int[n + 1];
        // Arrays.fill(memo, -1);
        // solve(n, memo);
        // return memo[n];

        // //Approach - 3 : 1D - bottom up approach
        // if (n == 0 || n == 1 || n == 2){
        //     return n;
        // }

        // int dp[] = new int[n+1];
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 2;
        // for(int i = 3; i <= n; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }

        // return dp[n];

        if(n == 0 || n == 1 || n == 2){
            return n;
        }

        int a = 1;
        int b = 2;
        int c = 0;

        for(int i = 3; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private int solve(int n , int[] memo){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        return memo[n] = solve(n-1, memo) + solve(n-2, memo);
    }
}
