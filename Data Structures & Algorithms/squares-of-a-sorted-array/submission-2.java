class Solution {
    public int[] sortedSquares(int[] nums) {
        //Two Pointer
        int l = 0;
        int r = nums.length - 1;
        int ans [] = new int[nums.length];
        int idx = nums.length - 1;

        while(l <= r){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                ans[idx--] = nums[l] * nums[l];
                ++l;
            }else{
                ans[idx--] = nums[r] * nums[r];
                --r;
            }
        }

        return ans;
        
    }
}