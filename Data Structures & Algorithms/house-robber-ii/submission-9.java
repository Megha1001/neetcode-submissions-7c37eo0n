//TC : O(N)
//SC : O(1)
class Solution {
    public int rob(int[] nums) {
        /*
        We can't select first and last
        house-II = Math.max(house-I(0, n-2), house-I(1, n-1))
        */

        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        return Math.max(houseRobber1(nums, 0, n-2), houseRobber1(nums, 1, n-1));
    }

    private int houseRobber1(int []nums, int start, int end){
        int rob2 = 0; // best answer up to the previous house
        int rob1 = 0; //bset answer upto the house before that

        for(int i = start; i <= end; i++){
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;

    }
}
