//TC : O(2^(max(m, n)))
//SC : O(max(m,n))
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length() == 0;
        }

        boolean is_first_char_matched = false;
        if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
            is_first_char_matched = true;
        }

        if(p.length() >= 2 && p.charAt(1) == '*'){
            boolean not_take = isMatch(s, p.substring(2));
            boolean take = is_first_char_matched && isMatch(s.substring(1), p);
            return not_take || take;
        }else {
            return is_first_char_matched && isMatch(s.substring(1), p.substring(1));
        }
        
    }
}
