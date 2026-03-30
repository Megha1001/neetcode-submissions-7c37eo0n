class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        //prefix sum
        int prefix_sum [] = new int[n];
        prefix_sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix_sum[i] = prefix_sum[i - 1] * nums[i];
        }

        //postfix sum
        int postfix_sum[] = new int[n];
        postfix_sum[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            postfix_sum[i] = postfix_sum[i+1] * nums[i];
        }

        int output[] = new int[n];
        for(int i = 0; i < n; i++){
            int prefix_product = i == 0 ? 1 : prefix_sum[i - 1];
            int postfix_product = i == n - 1 ? 1 : postfix_sum[i + 1];

            output[i] = prefix_product * postfix_product;
        }

        return output;
        
    }
}  
