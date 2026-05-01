//TC : O(N! * N)
//SC : O(N)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, new ArrayList<>(), res);
        return res;
    }
    private void backTrack(int[] nums, boolean[]used, List<Integer> path, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            // choose
            used[i] = true;
            path.add(nums[i]);

            //explore
            backTrack(nums, used, path, res);

            //unexplore
            path.remove(path.size() - 1);
            used[i] = false;

        }
        
    }
}
