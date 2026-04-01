// TC : O(N) [Traversing all elements once ], SC : O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //Pattern : Two pointer
        int i = 0;
        int j = numbers.length - 1;

        while(i < j){ //why not = because we can't take same element twice
            int sum = numbers[i] + numbers[j];

            if(sum == target){
                return new int[]{i+1, j+1};
            }
            else if (sum > target){
                --j;
            }else {
                ++i;
            }
        }
        
        return new int[]{};
    }
}