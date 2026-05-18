class Solution {
    private int n;
    private int[][]memo;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        memo = new int[1001][1001];

        for(int[]row : memo){
            Arrays.fill(row, -1);
        }
        
        return solve(0, -1, nums);
    }

    private int solve(int currIdx, int prevIdx, int[]nums){
        if(currIdx == n){
            return 0;
        }

        if(prevIdx != -1 && memo[currIdx][prevIdx] != -1){
            return memo[currIdx][prevIdx];
        }

        int take = 0;
        if(prevIdx == -1 || nums[currIdx] > nums[prevIdx]){
            take = 1 + solve(currIdx + 1, currIdx, nums);
        }

        int skip = solve(currIdx + 1, prevIdx, nums);

        if(prevIdx != -1){
            memo[currIdx][prevIdx] = Math.max(take, skip);
        }

        return Math.max(take, skip);

    }
}
