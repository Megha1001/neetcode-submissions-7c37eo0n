class Solution {
    public int rob(int[] nums) {
        /*
        For each house i, we have two choices
         -> Not robbing it -> same money as i-1
         -> robbing it -> money at i + best up to i-2
        */

        int rob1 = 0;
        int rob2 = 0;

        //[rob1, rob2, n, n+1, ..]
        for(int n : nums){
            int temp = Math.max(n+rob1 , rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
        
    }
}
