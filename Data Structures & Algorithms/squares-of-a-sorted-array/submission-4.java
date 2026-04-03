//TC : O(N), SC : O(N)
class Solution {
    public int[] sortedSquares(int[] nums) {
        //Two pointer
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int ans [] = new int[n];
        int idx = n-1;

        while(l <= r){
            if(Math.abs(nums[l]) <= Math.abs(nums[r])){
                ans[idx] = nums[r] * nums[r];
                --r;
            }else {
                ans[idx] = nums[l] * nums[l];
                ++l;
            }
            --idx;
        }

        return ans;
        
    }
}