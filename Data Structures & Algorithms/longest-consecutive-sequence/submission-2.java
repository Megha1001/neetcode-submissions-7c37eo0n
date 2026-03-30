class Solution {
    public int longestConsecutive(int[] nums) {
        
    if(nums==null || nums.length == 0){
        return 0;
    }
    //Naive Approach : sort array and find
    Arrays.sort(nums);
    int res = 1;
    int currMax = 1;

    for(int i=1; i<nums.length; i++){
        if(nums[i]==nums[i-1]){
            continue;
        }
        if(nums[i] == nums[i-1]+1){
            ++currMax;
        }else{
            res = Math.max(currMax, res);
            currMax = 1;
        }
    }
        
    return Math.max(res, currMax);
    }
}
