class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int LIS [] = new int[n]; //LIS[i] = represent LIS from the index i
        Arrays.fill(LIS, 1);

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(nums[j] > nums[i]){
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
        
    }
}
