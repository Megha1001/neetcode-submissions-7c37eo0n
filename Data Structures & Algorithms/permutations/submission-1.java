class Solution {
    //Recursive
    public List<List<Integer>> permuteRecursive(int[] nums) {
        if(nums.length == 0){
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> p : perms){
            //insert nums[0] at every position in p
            for(int i = 0; i<= p.size(); i++){ // why <= since we can insert at the end too
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i, nums[0]);
                res.add(p_copy);
            }
        }

        return res;
        
    }

    //Backtracking
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean [] pick = new boolean[nums.length];
        backTrack(new ArrayList<>(), nums, pick);
        return res;
    }

    private void backTrack(List<Integer> perm, int[]nums, boolean[]pick){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                pick[i] = true;
                perm.add(nums[i]);
                backTrack(perm, nums, pick);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }
}
