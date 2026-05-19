//TC : O(N)
//SC : O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;

        for(int i = 0; i < nums.length; i++){
            if(maxReachable < i){
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }

        return true;
        
    }
}
