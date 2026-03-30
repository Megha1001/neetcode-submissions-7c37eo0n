class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), 0);
        return res;
    }

    private void backTrack(int nums[], List<Integer>curr, int i){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        //consider
        curr.add(nums[i]);
        backTrack(nums, curr, i+1);

        //so duplicate sets can be avoided
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            ++i;
        }

        //not consider
        curr.remove(curr.size()-1);
        backTrack(nums, curr, i+1);
    }
}
