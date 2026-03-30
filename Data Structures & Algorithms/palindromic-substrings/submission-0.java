class Solution {
    public int countSubstrings(String s) {
        //Same concept as of Longest Palindromic Substring
        int count = 0;
        int n = s.length();
        int l = 0;
        int r = 0;

        if(n==1){
            return 1;
        }

        for(int i = 0; i < n; i++){
            
            //for odd length
            l = i; r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                ++count;
                --l;
                ++r;
            }

            //for even length
            l = i; r = i+1;
             while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                ++count;
                --l;
                ++r;
            }

        }


        return count;
        
    }
}
