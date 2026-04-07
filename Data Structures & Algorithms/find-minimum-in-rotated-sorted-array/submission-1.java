class Solution {
    public int findMin(int[] nums) {
        //Min will always be present on unsorted half
        int l = 0;
        int h = nums.length - 1;

        while(l < h){ // not = otherwise it will go in infinite loop
            int mid = l + (h-l)/2;
            if(nums[mid] > nums[h]){
                //right half is not sorted
                l = mid+1;
            }else{
                h = mid;
            }

        }

        return nums[l];
        
    }
}
