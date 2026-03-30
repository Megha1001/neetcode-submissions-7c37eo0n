class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();
    private int n;
    public List<List<Integer>> permute(int[] nums) {
        //backtracking
        /*
            do something
            explore
            revert step-1 and further explore
        */
        n = nums.length;
        helper(new ArrayList<>(), nums);
        return res;
    }

    private void helper(ArrayList<Integer> temp, int[]nums){
        if(temp.size() == n){
            res.add(new ArrayList<>(temp));
            return;
        }

        //run for all elements
        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i])){
                temp.add(nums[i]);
                set.add(nums[i]);
                helper(temp, nums);
                //un-explore
                temp.remove(temp.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}
