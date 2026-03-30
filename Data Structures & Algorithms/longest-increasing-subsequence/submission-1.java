class Solution {
    //By Dynamic programming
    /*
    For Ex : {1,2,4,3}  = idx : 0,1,2,3
    //LIS[idx]
    LIS[3] = 1;
    LIS[2] = Max(1 , 1+LIS[3]-> second one is not allowed, bcoz 4 !< 3)
    LIS[1] = Max(1, 1 + LIS[2], 1 + LIS[3] = 1, 1+1, 1+1 ) = 2
    LIS[0] = Max(1, 1 + LIS[1], 1 + LIS[2], 1 + LIS[3] = 1, 1+2, 1+1 ) = 3
    */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int n = nums.length;
        int LIS[] = new int[n];
        Arrays.fill(LIS, 1); // for every single element LIS is 1

        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(nums[i] < nums[j]){
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
        
    }
}
