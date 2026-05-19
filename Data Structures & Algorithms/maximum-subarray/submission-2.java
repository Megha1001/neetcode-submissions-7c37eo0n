//TC : O(N)
//SC : O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int curr_max = nums[0];

        for(int i = 1; i < nums.length; i++){
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            res = Math.max(res, curr_max);
        }

        return res;
        
    }
}