class Solution {
    public int[] sortedSquares(int[] nums) {
        /*
        Non decreasing order -> increasing but cnan have duplicate numbers
        Two pointer approach
        */

        int l = 0;
        int h = nums.length-1;

        int res [] = new int[nums.length];
        int idx = nums.length-1;

        while(l<=h){
            if(Math.abs(nums[l]) >= Math.abs(nums[h])){
                res[idx--] = nums[l] * nums[l];
                ++l;
            }else{
                res[idx--] = nums[h] * nums[h];
                --h;
            }
        }

        return res;
        
    }
}