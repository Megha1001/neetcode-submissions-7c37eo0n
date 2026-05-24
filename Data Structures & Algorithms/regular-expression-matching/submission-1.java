//TC : O(2^(max(m, n)))
//SC : O(max(m,n))
class Solution {
    public boolean isMatch(String s, String p) {
        return solve(0, 0, s, p);
    }

    private boolean solve(int i, int j, String s, String p){
        if(j == p.length()){
            return i == s.length();
        }

        boolean is_first_char_matched = false;
        if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            is_first_char_matched = true;
        }

        if((j + 1) < p.length() && p.charAt(j+1) == '*'){
            boolean not_take = solve(i, j + 2, s, p);
            boolean take = is_first_char_matched && solve(i+1, j, s, p);
            return not_take || take;
        }else {
            return is_first_char_matched && solve(i + 1, j + 1, s, p);
        }
    }
}
