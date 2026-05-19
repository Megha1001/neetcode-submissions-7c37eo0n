class Solution {
    private int n;
    private int[]memo;
    public int jump(int[] nums) {
        //Approach - 1 Memoization
        //TC : O(N*N), SC : O(N)
        //solve(i) = 1 + min(solve(i + jump)) for all valid jumps
        n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, - 1);
        return solve(0, nums);
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
