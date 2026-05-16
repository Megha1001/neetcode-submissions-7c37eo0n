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
        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);
        solve(n, memo);
        return memo[n];
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
