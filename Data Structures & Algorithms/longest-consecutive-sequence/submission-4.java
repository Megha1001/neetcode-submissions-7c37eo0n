class Solution {
    // public int longestConsecutive(int[] nums) {

    // //Naive Approach : sort array and find    
    // if(nums==null || nums.length == 0){
    //     return 0;
    // }
    // Arrays.sort(nums);
    // int res = 1;
    // int currMax = 1;

    // for(int i=1; i<nums.length; i++){
    //     if(nums[i]==nums[i-1]){
    //         continue;
    //     }
    //     if(nums[i] == nums[i-1]+1){
    //         ++currMax;
    //     }else{
    //         res = Math.max(currMax, res);
    //         currMax = 1;
    //     }
    // }
        
    // return Math.max(res, currMax);
    // }

    public int longestConsecutive(int[] nums) {
        /*
        IDEA : 1. Create a HashSet and populate it with nums
            2. x can only be the start of sequence when x-1 doesn't exist

        Put all the numbers in set
        For each number 
            -  if num-1 is not in the set -> start a sequence
            - count how long the subsequence goes -> num, num+1, num+2, .....
        */

        if(nums==null || nums.length==0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int longest = 0;
        for(int num : set){
            //start of sequence
            if(!set.contains(num-1)){
                int curr = num;
                int count = 1;

                while(set.contains(curr+1)){
                    ++curr;
                    ++count;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
