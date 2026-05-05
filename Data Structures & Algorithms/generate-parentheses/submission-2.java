class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTrack(n, 0, 0, "");
        return res;
    }

    private void backTrack(int n , int open, int close, String curr){
        if(curr.length() == 2 * n){
            res.add(curr);
            return;
        }

        if(open < n){
            backTrack(n, open + 1, close, curr+"(");
        }

        if(close < open){
            backTrack(n, open, close + 1, curr+ ")");
        }
    }
}
