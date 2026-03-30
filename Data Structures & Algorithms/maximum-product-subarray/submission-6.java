class Solution {
    public int maxProduct(int[] nums) {

        //Use Kadane
        /*
        Maintain two variables
            - curr_max = maximum product ending at this index
            - curr_min = minimum product ending at this index
            why we are maintaining curr_min -> if the curr element is -ve then the whole thing will become +ve
        */

        int curr_min = 1;
        int curr_max = 1;
        int res = nums[0];
        for(int n : nums){
            int temp = n * curr_max;
            curr_max = Math.max(Math.max(temp, curr_min * n), n);
            curr_min = Math.min(Math.min(temp, curr_min * n), n);
            res = Math.max(res, curr_max);
        }

        return res;
        
    }
}
