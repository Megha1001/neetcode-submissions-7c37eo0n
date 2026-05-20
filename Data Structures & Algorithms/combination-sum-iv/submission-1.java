class Solution {
    private int memo[];
    public int combinationSum4(int[] nums, int target) {
        //Recursion + Memoization
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return solve(nums, target);     
    }

    private int solve(int[]nums, int target){
        if(target == 0){
            return 1;
        }

        if(target < 0){
            return 0;
        }

        if(memo[target] != -1){
            return memo[target];
        }

        int ways = 0;
        for(int num : nums){
            ways += solve(nums, target - num);
        }
        memo[target] = ways;
        return memo[target];
    }
}