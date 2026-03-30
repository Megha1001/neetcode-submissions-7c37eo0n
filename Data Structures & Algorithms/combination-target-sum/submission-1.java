class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        sumIII(nums, target, curr, res, 0);
        return res;
    }

    private void sumIII(int[]nums, int target, List<Integer> curr, List<List<Integer>> res, int i){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        //consider
        curr.add(nums[i]);
        sumIII(nums, target - nums[i], curr, res, i); //not i+1 as we can use multiple times

        //not-consider
        curr.remove(curr.size() - 1);
        sumIII(nums, target, curr, res, i+1);
    }
}
