class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Two Pointer approach 
        //since array is sorted so no need sorting
        //exactly one valid solution. -> NO duplicates that means hence no need to check for 
        /*
            if(i>0 && numbers[i] == numbers[i-1]){
                continue;
            }
        */

        int l = 0, r = numbers.length - 1;
        while(l < r){
            int sum = numbers[l] + numbers[r];

            if(sum == target){
                return new int[]{l+1, r+1}; // 1-indexed
            }else if(sum > target){
                --r;
            }else{
                ++l;
            }

        }

        return new int[0]; // guaranteed solution exists
        
    }
}
