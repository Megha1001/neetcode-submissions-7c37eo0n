class Solution {
    public void moveZeroes(int[] nums) {

        //Two Pointer - SLow and fast pointer variation
        int left = -1;
        int right = 0; //find non zero

        while(right < nums.length){
            if(nums[right] != 0){
                ++left;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            ++right;
        }
        
    }
}