class Solution {

    //TC : O(N*T)
    //SC : O(N*T)
    private int memo[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;
        int target = sum/2;
        int n = nums.length;
        memo = new int[n][target+1];

        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        return solve(0, nums, target);
    }

    private boolean solve(int i, int []nums, int target){
        if(target == 0){
            return true;
        }
        if(i == nums.length || target < 0){
            return false;
        }

        if(memo[i][target] != -1){
            return memo[i][target] == 1;
        }

        boolean take = solve(i + 1, nums, target - nums[i]);
        boolean skip = solve(i + 1, nums, target);
        memo[i][target] = (take || skip) ? 1 : 0;
        return memo[i][target] == 1;
    }
}
