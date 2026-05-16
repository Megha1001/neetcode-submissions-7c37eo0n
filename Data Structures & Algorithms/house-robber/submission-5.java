class Solution {
    public int rob(int[] nums) {
        //Approach - 1 Recursion. - TLE
        // return solve(0, nums);

        //Approach - 2 Memoization
        int[]memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return solve(0, memo, nums);
    }

    private int solve(int i, int []memo, int[]nums){
        if(i >= nums.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }
        int steal = nums[i] + solve(i + 2, memo, nums);
        int skip = solve(i + 1, memo, nums);
        return memo[i] =  Math.max(steal, skip);
    }

    private int solve(int i , int[]nums){
        if(i >= nums.length){
            return 0;
        }

        int steal = nums[i] + solve(i + 2, nums);
        int skip = solve(i + 1, nums);

        return Math.max(steal, skip);
    }
}
