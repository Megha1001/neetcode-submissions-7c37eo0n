class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(1, n, k, new ArrayList<>(), res);
        return res;
    }
    private void backTrack(int start, int n, int k, List<Integer> path, List<List<Integer>> res){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(start > n){
            return;
        }

        //consider
        path.add(start);
        backTrack(start+1, n, k-1, path, res);

        //not consider
        path.remove(path.size() - 1);
        backTrack(start + 1, n, k, path, res);
    }
}