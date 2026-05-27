class Solution {
    public int countSubstrings(String s) {
        //based on longest palindrome substring

        int count = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            //for odd length
            int l = i;
            int r = i;

            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                ++count;
                --l;
                ++r;
            }

            //for event length
            l = i;
            r = i+1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                ++count;
                --l;
                ++r;
            }
        }

        return count;
    }
}
