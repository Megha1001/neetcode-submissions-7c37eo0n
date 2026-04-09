// TC : O(logN), SC : O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while(l < h){
            int m = l + (h - l)/2;

            if(m %2 ==1){
                --m; //make mid even
            }

            if(nums[m] == nums[m+1]){
                //valid pair check on right
                l = m+2;
            }else{
                h = m; //consider m too
            }
        }

        return nums[h]; // or nums[l];
        
    }
}