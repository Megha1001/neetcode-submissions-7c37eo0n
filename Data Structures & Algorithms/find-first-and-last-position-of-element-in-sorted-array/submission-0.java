class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*
        Find first occurence and find last occurence
        */

        int n = nums.length;
        if(n == 0){
            return new int[]{-1,-1};
        }

        //first occurrence
        int l = 0;
        int h = n-1;
        int first = -1;

        while(l <= h){
            int m = l + (h - l)/2;
            if(target == nums[m]){
                first = m;
                h = m - 1;
            }else if(target > nums[m]){
                l = m + 1;
            }else{
                h = m - 1;
            }
        }

        if(first == -1){
            return new int[]{-1,-1};
        }

        //second occurrence
        int last = -1;
        l = 0;
        h = n-1;

        while(l <= h){
            int m = l + (h - l)/2;
            
            if(nums[m] == target){
                last = m;
                l = m + 1;
            }else if(target > nums[m]){
                l = m + 1;
            }else {
                h = m - 1;
            }
        }

        return new int[]{first, last};
        
    }
}