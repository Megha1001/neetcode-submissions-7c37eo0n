class Solution {

    public int maxProduct(int[] nums) {
        //kadane's algo
        int res = nums[0];
        int curr_max = 1, curr_min = 1;

        for(int num : nums){
            int tmp = curr_max * num; // to calculate curr_min as curr_max gets change on line number 10
            //curr_max*num, curr_min.num or start from num
            curr_max = Math.max(Math.max(curr_max * num, curr_min * num),num); 
            curr_min = Math.min(Math.min(tmp , curr_min * num), num);

            res = Math.max(res, curr_max);
        }

        return res;

    }
    public int maxProductBruteForce(int[] nums) {

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
