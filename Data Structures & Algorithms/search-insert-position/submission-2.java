class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int res = nums.length;

        while(l <= h){//find target so =
            int m = l + (h - l)/2;

            if(nums[m] >= target){
                res = m;
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        return res;
        
    }
}