class Solution {
    public int maxProduct(int[] nums) {
        //kadanes
        int res = nums[0];
        int curr_max = 1;
        int curr_min = 1;

        for(int num : nums){
            int tmp = curr_max * num;
            curr_max = Math.max(Math.max(tmp, num * curr_min), num);
            curr_min = Math.min(Math.min(tmp, num * curr_min), num);
            res = Math.max(curr_max, res);
        }

        return res;
        
    }
}
