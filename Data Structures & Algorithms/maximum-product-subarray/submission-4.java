class Solution {
    public int maxProduct(int[] nums) {

        //Brute force ->consider every subarray
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = i; j < n; j++){
                product *= nums[j];
                max = Math.max(product, max);
            }
        }

        return max;
    }
}
