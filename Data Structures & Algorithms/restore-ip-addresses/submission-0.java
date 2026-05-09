class Solution {
    private List<String> res = new ArrayList<>();
    private int n;
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        if(n > 12){
            return res;
        }

        solve(s, 0, 0 , "");
        return res;
    }

    private void solve(String s, int idx, int parts, String curr){
        if(idx == n && parts == 4){
            res.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if(parts >= 4){
            return;
        }

        if(idx + 1 <= n){
            solve(s, idx + 1, parts + 1, curr + s.substring(idx, idx + 1) + ".");
        }

        if(idx + 2 <= n && isValid(s.substring(idx, idx + 2))){
            solve(s, idx + 2, parts + 1, curr + s.substring(idx, idx + 2) + ".");
        }

        if(idx + 3 <= n && isValid(s.substring(idx, idx + 3))){
            solve(s, idx + 3, parts + 1, curr + s.substring(idx, idx + 3) + ".");
        }
    }

    private boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }

        return Integer.parseInt(s) <= 255;
    }
}