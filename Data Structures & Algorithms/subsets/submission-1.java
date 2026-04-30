//TC : O(N* 2^N), SC : O(N)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //backtracking
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int[]nums, int idx, List<Integer> path, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //not pick
        backTrack(nums, idx + 1, path, res);

        //pick
        path.add(nums[idx]);
        backTrack(nums, idx + 1, path, res);
        //unexplore
        path.remove(path.size() - 1);
    }
}
