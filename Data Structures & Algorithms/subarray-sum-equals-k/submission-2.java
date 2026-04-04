class Solution {
    public int subarraySum(int[] nums, int k) {
        // input can be negative -> prefix Sum
        Map<Integer, Integer> prefix_sum = new HashMap<>(); //sum, count of that sum
        prefix_sum.put(0, 1); //empty array
        int curr_sum = 0;
        int res = 0;
        for(int num : nums){
            curr_sum += num;
            int diff = curr_sum - k;
            res += prefix_sum.getOrDefault(diff, 0);
            prefix_sum.put(curr_sum, prefix_sum.getOrDefault(curr_sum, 0) + 1);
        }

        return res;
        
    }
}