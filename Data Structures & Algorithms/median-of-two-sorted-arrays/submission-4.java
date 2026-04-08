class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Brute Force
        /*
            1. Build temp array of size m+n by merging two sorted array approach
            2. find median
        */

        int m = nums1.length;
        int n = nums2.length;

        if(m==0 && n == 1){
            return nums2[0];
        }

        if(n == 0 && m == 1){
            return nums1[0];
        }

        int temp [] = new int[m+n];
        int i = 0, j = 0, idx = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                temp[idx++] = nums1[i++];
            }else{
                temp[idx++] = nums2[j++];
            }
        }
        
        while(i < m){
            temp[idx++] = nums1[i++];
        }

        while(j < n){
            temp[idx++] = nums2[j++];
        }

        int size = m+n;

        if(size % 2 == 0){
            return (temp[size/2] + temp[size/2 - 1])/2.0; // to convert in double
        }
        return (double)temp[size/2];
    }
}
