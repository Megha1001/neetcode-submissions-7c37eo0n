class Solution {
    public boolean canPartition(int[] nums) {

        /*
         Idea : find the sum of nums
            -> if sum %2 != 0 return false
            ->  target = sum/2; (two choices at every idx select it or not select it)
                target = sum/2
                    -> select ith value -> target - nums[i], i = i+1
                    -> not select ith value -> target, i = i+1
        */
        
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        return dfs(nums, 0, sum/2);
    }

    private boolean dfs(int nums[], int i, int target){
        if(target == 0){
            return true;
        }
        if(i >= nums.length){
            return false;
        }

        return dfs(nums, i+1, target - nums[i]) ||  //select
                dfs(nums, i+1, target); //not select
    }
}
