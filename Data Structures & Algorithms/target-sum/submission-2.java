//TC : O(N*S)
//SC  :O(N*S)
class Solution {
    private int n;
    private int offset;
    private int[][]memo;
    private int target;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        this.target = target;
        int total = 0;
        for(int num : nums){
            total += num;
        }

        offset = total;
        memo = new int[n][2 * total + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        
        return solve(0, 0, nums);
    }

    private int solve(int i, int sum, int[]nums){
        if(i == n){
            return target == sum ? 1 : 0;
        }

        if(memo[i][sum + offset] != Integer.MIN_VALUE){
            return memo[i][sum + offset];
        }

        int plus = solve(i + 1, sum + nums[i], nums);
        int minus = solve(i + 1, sum - nums[i], nums);

        return memo[i][sum + offset] = plus + minus;
    }
}
