class Solution {
    private int n;
    private int[]memo;
    public int jump(int[] nums) {
        //Approach - 1 Memoization
        //TC : O(N*N), SC : O(N)
        //solve(i) = 1 + min(solve(i + jump)) for all valid jumps
        //solve(i) = minimum jumps needed to reach the last index starting from index i
        // n = nums.length;
        // memo = new int[n];
        // Arrays.fill(memo, - 1);
        // return solve(0, nums);

        //Approach - 2 Bottom up
        //TC : O(N*N)
        //SC : O(N)
        int n = nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //dp[i] = minimum number of jump to reach index i;
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int jump = 1; jump <= nums[i] && i + jump < n; jump ++){
                dp[i+jump] = Math.min(dp[i+jump], dp[i] + 1);
            }
        }
        return dp[n-1];
    }

    private int solve(int idx, int[] nums){
        if(idx >= n - 1){
            return 0;
        }

        if(memo[idx] != -1){
            return memo[idx];
        }

        int minJump = Integer.MAX_VALUE;

        for(int jump = 1; jump <= nums[idx]; jump ++){
            int sub = solve(idx + jump, nums);
            if(sub != Integer.MAX_VALUE){
                minJump = Math.min(minJump, 1 + sub);
            }
            
        }

        memo[idx] = minJump;
        return memo[idx];
    }
}
