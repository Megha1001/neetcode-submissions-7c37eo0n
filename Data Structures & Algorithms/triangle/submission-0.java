class Solution {
    private int n;
    private int [][]memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        memo = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        return solve(triangle, 0, 0);
    }

    private int solve(List<List<Integer>> triangle, int row, int col){
        if(row == n-1){
            return triangle.get(row).get(col);
        }

        if(memo[row][col] != Integer.MAX_VALUE){
            return memo[row][col];
        }

        int minPath = triangle.get(row).get(col) +
                        Math.min(
                            solve(triangle, row + 1, col),
                            solve(triangle, row + 1, col + 1)
                        );

        return memo[row][col] = minPath;
    }
}