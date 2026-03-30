class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int curr_max = nums[0];

        for(int i = 1; i < nums.length; i++){
            curr_max = Math.max(curr_max + nums[i], nums[i]);
            res = Math.max(curr_max, res);
        }

        return res;
        
    }
}
