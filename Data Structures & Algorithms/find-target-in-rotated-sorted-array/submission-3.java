class Solution {
    public int search(int[] nums, int target) {
        //Idea : One of the half will always be sorted
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }
            //key addition for duplicates
            else if(nums[mid]== nums[low] && nums[mid] == nums[high]){
                ++low;
                --high;
            }
            else if(nums[mid] <= nums[high]){
                //right half is sorted
                if(nums[mid] < target && target <= nums[high]){
                    //go to right
                    low = mid + 1;
                }else{
                    //go to left
                    high = mid - 1;
                }
            }

            else{
                if(nums[mid] > target && target >= nums[low]){
                    //go to left
                    high = mid - 1;
                }else{
                    //go to right
                    low = mid + 1;
                }
            }
        }

        return -1;
        
    }
}
