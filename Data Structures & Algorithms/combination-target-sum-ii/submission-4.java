class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, curr, res, 0);
        return res;  
    }

    private void combinationSum(int[]candidates,int target, List<Integer> curr, List<List<Integer>> res, int i){
        if(target == 0){
            if(!res.contains(curr)){
                res.add(new ArrayList<>(curr));
            }
            
            return;
        }

        if(target < 0 || i >= candidates.length){
            return;
        }

        //consider 
        curr.add(candidates[i]);
        combinationSum(candidates, target - candidates[i], curr, res, i+1); //i+1 as we need to choose at most once
        //not consider
        curr.remove(curr.size() - 1);

        while(i < candidates.length-1 && candidates[i] == candidates[i+1]){
            ++i;
        }

        combinationSum(candidates, target, curr, res, i+1);
    }
}
