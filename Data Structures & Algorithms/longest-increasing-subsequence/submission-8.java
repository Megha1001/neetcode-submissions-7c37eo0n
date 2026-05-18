//TC : O(N*N)
//SC : O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        //Bottom up approach
        //LIS[i] = LIS ending at index i;
        int n = nums.length;
        int LIS[] = new int[n];
        Arrays.fill(LIS, 1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
    }
}
