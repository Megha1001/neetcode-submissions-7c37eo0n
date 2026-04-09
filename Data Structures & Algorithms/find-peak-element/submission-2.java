class Solution {
    public int findPeakElement(int[] nums) {
        //Peak element always exist where slop is higher - Binary Search

        int n = nums.length;
        
        if(n==1){
            return 0;
        }

        int l = 0;
        int h = n - 1;
        while(l < h){ // not = otherwise it will go in infinite loop
            int m = l + (h - l)/2;

            if(nums[m] < nums[m+1]){
                //go to right
                l = m + 1;
            }else{
                //go to left including m
                h = m;
            }
        }

        return l; // or h 
    }
}