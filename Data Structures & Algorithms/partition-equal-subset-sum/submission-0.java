class Solution {
    public boolean canPartition(int[] nums) {
        //brute force
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        //if subset existing then it would be in pair -> pair means should be divisible by 2
        if(sum %2 != 0){
            return false;
        }

        return dfs(nums, 0, sum/2, 0);
        
    }

    public boolean dfs(int nums[], int i, int target, int sum){
        if(sum == target){
            return true;
        }
        if(i >= nums.length){
            return false;
        }

        return dfs(nums, i+1, target, sum+nums[i]) || dfs(nums, i+1,target, sum);
    }
}
