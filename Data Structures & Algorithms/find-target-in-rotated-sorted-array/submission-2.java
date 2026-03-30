class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private int binarySearch(int [] nums, int l, int h, int x){
        while(l <= h){
            int m = l + (h - l)/2;
            int mid = nums[m];
            if(mid == x){
                return m;
            }else if (mid <= nums[h]){
                //right sorted
                if(mid < x && x <= nums[h]){
                    //right
                    l = m + 1;
                }else{
                    h = m - 1;
                }
            }else {
                //left sorted
                if(x < mid && x >= nums[l]){
                    h = m-1;
                }else{
                    l = m+1;
                }
            }
        }

        return -1;
    }
}
