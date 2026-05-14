class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //binary search
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int l = 0, h = m;
        while(l <= h){
            int p_x = l + (h - l)/2;
            int p_y = (m+n+1)/2 - p_x;

            int x_1 = p_x == 0 ? Integer.MIN_VALUE : nums1[p_x - 1];
            int x_3 = p_x == m ? Integer.MAX_VALUE : nums1[p_x];

            int x_2 = p_y == 0 ? Integer.MIN_VALUE : nums2[p_y - 1];
            int x_4 = p_y == n ? Integer.MAX_VALUE : nums2[p_y];

            if(x_1 <= x_4 && x_2 <= x_3){
                if((m + n) % 2 == 0){
                    return (Math.max(x_1, x_2) + Math.min(x_3, x_4))/2.0;
                }
                return Math.max(x_1, x_2);
            }else if (x_1 > x_4){
                h = p_x - 1;
            }else {
                l = p_x + 1;
            }
        }

        return -1;
        
    }
}
