//TC : O(M+N), O(1) : 1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1; //last index of nums1;

        while(m > 0 && n > 0){ // m and n are length not index
            if(nums1[m-1] >= nums2[n-1]){
                nums1[last] = nums1[m-1];
                --m;
            } else{
                nums1[last] = nums2[n-1];
                --n;
            }
            --last;
        }

        while(n > 0){
            nums1[last] = nums2[n-1];
            --last;
            --n;
        }
        // we dont need for nums1 as if nums2 is empty then nums1 elements are already at correct position
    }
}