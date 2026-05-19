class Solution {
    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(n);
    }

    private int solve(int n) {
        if (n == 0) {
            return 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int minSquares = Integer.MAX_VALUE;

        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            int sq = i * i;
            minSquares = Math.min(minSquares, 1 + solve(n - sq));
        }

        return memo[n] = minSquares;
    }
}
