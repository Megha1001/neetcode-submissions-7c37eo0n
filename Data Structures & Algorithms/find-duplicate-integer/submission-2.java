class Solution {
    public int findDuplicate(int[] nums) {
        
        //brute force
        // HashSet<Integer> set = new HashSet<>();

        // for(int num : nums){
        //     if(set.contains(num)){
        //         return num;
        //     }
        //     set.add(num);
        // }

        // return -1;

        //Using slow and fast pointer
        // Treat the array like LL where each index points to next index in the value;
        //first can never form cycle because its index is 0 and numbers are from [1,n]

        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        int slow2 = 0;

        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];

            if(slow == slow2){
                return slow;
            }
        }

    }
}
