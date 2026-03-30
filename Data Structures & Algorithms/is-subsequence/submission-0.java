class Solution {
    public boolean isSubsequence(String s, String t) {
        //Recursive - Brute force
        return isSubsequence(s, t, s.length(), t.length());   
    }

    public boolean isSubsequence(String s, String t, int m, int n){
        if(m == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(s.charAt(m-1) == t.charAt(n-1)){
            return isSubsequence(s, t, m - 1, n - 1);
        }else{
            return isSubsequence(s, t, m, n - 1);
        }

    }
}