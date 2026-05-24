//TC : O(N*N*N)
//SC : O(N*N)
class Solution {
    private int[][]memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[]arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;

        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }

        memo = new int[n + 2][n + 2];

        return solve(arr, 0, n + 1);
    }

    private int solve(int[]arr, int left, int right){
        if(right - left <= 1){
            return 0;
        }

        if(memo[left][right] != 0){
            return memo[left][right];
        }

        int best = 0;

        for(int k = left + 1; k < right ; k++){
            int coins = solve(arr, left, k) +
                        arr[left] * arr[k] * arr[right] + 
                        solve(arr, k , right);
            best = Math.max(best, coins);
        }

        return memo[left][right] = best;
    }
}
