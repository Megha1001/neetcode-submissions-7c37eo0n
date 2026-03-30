class Solution {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        int res = nums[0];

        while(l <= r){
            //is sorted part
            if(nums[l] <= nums[r]){
                res = Math.min(nums[l], res);
                break;
            }

            int m = l + (r-l)/2;
            res = Math.min(nums[m], res);
            if(nums[m] >= nums[l]){
                //go to right
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return res;
        
    }
}
