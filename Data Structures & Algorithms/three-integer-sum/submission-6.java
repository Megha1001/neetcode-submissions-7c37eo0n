class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //sort the nums array that helps to not to consider duplicates
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<n-2; i++){ // -3 as we need to consider b,c as well

            if(nums[i]>0){
                break; //since array is sorted if curr element is positive then triplet is not present starting from curr index to rest
            }

            if(i>0 && nums[i]==nums[i-1]){
                //not consider duplicates
                continue;
            }

            if(twoSum(i+1, n-1, nums[i], res, nums)){
                continue;
            }
        }

        return res;
        
    }

    public boolean twoSum(int l, int h, int target, List<List<Integer>> list, int [] nums){
        while(l<h){
            int sumThree = nums[l] + nums[h] + target;

            if(sumThree == 0)
            {
                list.add(Arrays.asList(target,nums[l], nums[h]));
                ++l;
                --h;

                while(l < h && nums[l] == nums[l-1]){
                    ++l;
                }

                while(l<h && nums[h] == nums[h+1]){
                    --h;
                }
            }
            else if(sumThree >0){
                --h;
            }else{
                ++l;
            }
        }

        return false;
    }
}
