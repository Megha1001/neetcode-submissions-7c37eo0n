class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Approach - 1 TC : O(M+N), SC : O(M+N)
        // Brute Force
        /*
            1. Build temp array of size m+n by merging two sorted array approach
            2. find median
        */

        // int m = nums1.length;
        // int n = nums2.length;

        // if(m==0 && n == 1){
        //     return nums2[0];
        // }

        // if(n == 0 && m == 1){
        //     return nums1[0];
        // }

        // int temp [] = new int[m+n];
        // int i = 0, j = 0, idx = 0;

        // while(i < m && j < n){
        //     if(nums1[i] <= nums2[j]){
        //         temp[idx++] = nums1[i++];
        //     }else{
        //         temp[idx++] = nums2[j++];
        //     }
        // }
        
        // while(i < m){
        //     temp[idx++] = nums1[i++];
        // }

        // while(j < n){
        //     temp[idx++] = nums2[j++];
        // }

        // int size = m+n;

        // if(size % 2 == 0){
        //     return (temp[size/2] + temp[size/2 - 1])/2.0; // to convert in double
        // }
        // return temp[size/2];


        //Approach -2 Without space
        int m = nums1.length;
        int n = nums2.length;

        int size = m+n;

        int idx1 = size/2 - 1;
        int element1 = -1;
        int idx2 = size/2;
        int element2 = -1;

        int i = 0, j = 0, k = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                if(k == idx1){
                    element1 = nums1[i];
                }
                if(k == idx2){
                    element2 = nums1[i];
                }
                ++i;
            }else {
                if(k == idx1){
                    element1 = nums2[j];
                }
                if(k == idx2){
                    element2 = nums2[j];
                }
                ++j;
            }
            ++k;
        }

        while(i < m){
            if(k == idx1){
                element1 = nums1[i];
            }
            if(k == idx2){
                element2 = nums1[i];
            }
            ++i;
            ++k;
        }

        while(j < n){
           if(k == idx1){
                element1 = nums2[j];
            }
            if(k == idx2){
                element2 = nums2[j];
            }
            ++j;
            ++k;
        }

        if(size % 2 == 1){
            return element2;
        }

        return (element1 + element2)/2.0;
    }
}
