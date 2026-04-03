class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(); //shorter
        int n = s2.length();
        if(m > n){
            return false;
        }

        int need[] = new int[26];
        int window[] = new int[26];
        
        for(char c : s1.toCharArray()){
            ++need[c - 'a'];
        }

        for(int i = 0; i < m; i++){
            ++window[s2.charAt(i) - 'a'];
        }

        if(Arrays.equals(need, window)){
            return true;
        }

        //sliding window
        for(int right = 1; right <= n-m; right++){
            window[s2.charAt(right - 1) - 'a']--;
            window[s2.charAt(right + m - 1) - 'a']++;

            if(Arrays.equals(need, window)){
                return true;
            }
        }

        return false;
        
    }
}
