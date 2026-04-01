class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //Sort + Two Pointer
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){

            //for skip duplicates
            if(i > 0 && nums[i] == nums[i-1]){ //that means we have already considered same pair with i-1 nums value
                continue;
            }

            //fixing i as first member and applying two pointer for rest
            int left = i+1;
            int right = n - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   
                    //to skip duplicates
                    while(left < right && nums[left] == nums[left+1]) ++left;
                    while(left < right && nums[right] == nums[right - 1]) --right;

                    ++left;
                    --right;
                }
                else if (sum > 0){
                    --right;
                }else{
                    ++left;
                }
                
            }
        }

        return res;
        
    }
}
