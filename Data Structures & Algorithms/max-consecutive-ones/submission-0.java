class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int left = 0;
        int count = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right]==1){
                ++count;
            }else{
                res = Math.max(res, count);
                count = 0;
            }
        }
        return Math.max(res, count);
    }
}