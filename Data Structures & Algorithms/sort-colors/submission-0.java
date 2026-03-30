class Solution {
    public void sortColors(int[] nums) {
        
        //Three Pointer - Dutch national Flag algo
        int low = -1;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                ++low; //always 1
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                ++mid;
            }
            else if (nums[mid] == 1){
                ++mid;
            }else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                --high;
                //++mid // no as we dont know what is there in nums[mid] now
            }
        }
        
    }
}