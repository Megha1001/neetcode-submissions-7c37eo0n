//TC : O(N*N)
//SC : O(1)
class Solution {
    public String longestPalindrome(String s) {
        //sliding window
        int resLength = 0;
        String res = "";
        int n = s.length();

        for(int i = 0; i < n; i++){
            //for odd length;
            int l = i;
            int r = i;

            while(l >=0 && r <= n - 1 && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > resLength){
                    resLength = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                --l;
                ++r;
            }

            l = i;
            r = i + 1;

            while(l >=0 && r <= n - 1 && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > resLength){
                    resLength = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                --l;
                ++r;
            }

        }

        return res;
        
    }
}
