class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if(n == 1){
            return 1;
        }

        int left = 0;
        int right = 1;
        int count = 1;

        while(right < n){
            if(right < n && nums[left] == nums[right]){
                ++right;
            }else{
                ++left;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                ++right;
                ++count;
            }

            
        }
        
        return count;
    }
}
