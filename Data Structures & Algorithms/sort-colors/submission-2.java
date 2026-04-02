class Solution {
    public void sortColors(int[] nums) {
        //Dutch National Flag Algo
        int l = -1;
        int m = 0;
        int h = nums.length - 1;

        while(m <= h){
            if(nums[m] == 0){
                int temp = nums[l+1];
                nums[l+1] = nums[m];
                nums[m] = temp;
                ++m;
                ++l;
            }else if(nums[m] == 1){
                ++m;
            }else {
                int temp = nums[m];
                nums[m] = nums[h];
                nums[h] = temp;
                --h;
            }
        }
        
    }
}