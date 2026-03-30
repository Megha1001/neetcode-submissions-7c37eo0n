class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backTrack(nums, target, curr, 0);
        return res;
    }

    private void backTrack(int nums[], int target, List<Integer>curr, int i){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        //consider
        curr.add(nums[i]);
        backTrack(nums, target - nums[i], curr, i);

        //not consider
        curr.remove(curr.size() - 1);
        backTrack(nums, target, curr, i+1);

    } 
}
