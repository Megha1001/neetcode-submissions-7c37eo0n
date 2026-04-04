class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int left = 0;
        int res = 0;
        int maxF = 0;

        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(right) - 'A']);
            
            //shrink
            while((right - left + 1) - maxF > k){
                count[s.charAt(left) - 'A']--;
                ++left;
            }

            res = Math.max(res, right - left + 1);
        }
        
        return res;
    }
}
