class Solution {
    public int maxProduct(int[] nums) {

        //Brute force ->consider every subarray
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int curr_max = 1;
            for(int j = i; j < n; j++){
                curr_max *= nums[j];
                max = Math.max(max, curr_max);
            }
        }

        return max;
    }
}
