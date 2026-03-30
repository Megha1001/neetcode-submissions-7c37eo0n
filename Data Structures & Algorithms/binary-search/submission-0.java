class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int m = low+ (high-low)/2;

            if(nums[m]==target){
                return m;
            }
            else if(nums[m] > target){
                //left
                high = m-1;
            }
            else {
                low = m+1;
            }
        }

        return res;  
    }
}
