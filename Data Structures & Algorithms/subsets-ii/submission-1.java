//TC : O(N * 2 ^ N)
//SC : O(N)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int[]nums, int idx, List<Integer> path, List<List<Integer>> res){
        if(nums.length == idx){
            res.add(new ArrayList<>(path));
            return;
        }
        //pick
        path.add(nums[idx]);
        backTrack(nums, idx + 1, path, res);
        path.remove(path.size() - 1);

        //check duplicates
        while(idx+1 < nums.length && nums[idx + 1] == nums[idx]){
            ++idx;
        }

        //not pick
        backTrack(nums, idx + 1, path, res);
    }
}
