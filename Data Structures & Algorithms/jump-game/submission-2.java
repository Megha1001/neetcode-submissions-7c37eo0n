//TC : O(N*N)
//SC : O(N)
class Solution {
    private int memo[];
    public boolean canJump(int[] nums) {
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
