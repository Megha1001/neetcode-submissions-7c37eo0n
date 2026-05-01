//TC : O(!n * N)
//SC : O(N) [used boolean array + recursive call]
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int []nums, boolean[]used, List<Integer>path,  List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            if(i > 0 && nums[i] == nums[i-1]&& !used[i-1]){ //IMP
                continue;
            }

            //taken
            used[i] = true;
            path.add(nums[i]);

            //explore
            backTrack(nums, used, path, res);

            //un-taken
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}