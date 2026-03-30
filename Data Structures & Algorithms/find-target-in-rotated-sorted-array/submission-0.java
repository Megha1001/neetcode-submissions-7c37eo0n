class Solution {
    public int search(int[] nums, int target) {
        //binary search

        int l = 0;
        int h = nums.length-1;


        while(l <= h){
            int m = l + (h-l)/2;

            if(nums[m] == target){
                return m;
            }

            //if left half is sorted
            else if(nums[m] >= nums[l]){
                if(target < nums[m] && target >= nums[l]){
                    h = m-1;
                } else{
                    l = m+1;
                }
            }

            //right half sorted
            else if(nums[m] <= nums[h]){
                if(target > nums[m] && target <= nums[h]){
                    l = m+1;
                }else{
                    h = m-1;
                }
            }
        }
        

        return -1;
    }
}
