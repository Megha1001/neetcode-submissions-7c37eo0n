class Solution {
    private int memo[];
    public int numSquares(int n) {
        //Approach - 1 Recursion + memoization
        //solve(n) = minimum number of perfect square needed to make n
        memo = new int[n + 1]; //because we want to return memo[n]
        Arrays.fill(memo, - 1);
        return solve(n);
    }

    private int solve(int n){
        if(n == 0){
            return 0;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int minSquares = Integer.MAX_VALUE;
        for(int i = (int)(Math.sqrt(n)); i >= 1; i--){
            int result = 1 + solve(n - (i * i));
            minSquares  = Math.min(minSquares, result);
        }
        
        return memo[n] = minSquares;
    }
}