
class Solution {


    //Bottom up
    public boolean canJump(int[] nums) {
        //Approach - 1 Top down
        int n = nums.length;
        boolean [] dp = new boolean[n];
        dp[0] = true;
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; --j){
                if(dp[j] && j+nums[j] >= i){
                    dp[i] = true;
                }
            }
        }
        return dp[n-1];
    }

    //Top down
    //TC : O(N*N)
    //SC : O(N)
    private int memo[];
    public boolean canJumpTopDown(int[] nums) {
        //Approach - 1 Memoization
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, - 1);

        return solve(nums, n, 0);
    }

    boolean solve(int[] nums, int n, int idx){
        if(idx == n-1){
            return true;
        }
        if(memo[idx] != -1){
            return memo[idx] == 1;//1 is true
        }

        for(int i = 1; i <= nums[idx]; i++){
            if(solve(nums, n, idx + i)){
                memo[idx] = 1;
                return true;
            }
        }
        memo[idx] = 0;
        return false;
    }
}
