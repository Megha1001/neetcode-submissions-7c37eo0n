class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        //Two Pointer pattern
        res = new ArrayList<>();
        //to avoid duplicates later
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){ //nums.length - 2 because we have to intitialize left and right. should have atleast three numbers
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length - 1;
            //two pointer
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) ++left;
                    while(left < right && nums[right] == nums[right - 1]) --right;

                    ++left;
                    --right;
                } else if (sum < 0){
                    ++left;
                } else{
                    --right;
                }
            }
        }


        return res;
    }
}
