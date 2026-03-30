class Solution {
    public String longestPalindrome(String s) {
        int resLength = 0;
        String res = "";
        int n = s.length();

        for(int i = 0; i < n; i++){
            
            //odd
            int l = i;
            int r = i;
            while(l >=0 && r < n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > resLength){
                    resLength = r-l+1;
                    res = s.substring(l, r+1);
                }
                --l;
                ++r;
            }

            //even
            l = i; r = i+1;
            while(l>=0 && r < n && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > resLength){
                    resLength = r-l+1;
                    res = s.substring(l, r+1);
                }
                --l;
                ++r;
            }
        }

        return res;
        
    }
}
