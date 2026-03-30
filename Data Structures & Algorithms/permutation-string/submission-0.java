class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int s1Count[] = new int[26];
        int s2Count[] = new int[26];

        for(char c : s1.toCharArray()){
            s1Count[c - 'a']++;
        }

        for(int i = 0; i < s1.length(); i++){
            s2Count[s2.charAt(i) - 'a'] ++;
        }

        if(Arrays.equals(s1Count, s2Count)){
            return true;
        }

        int l = 0;

        for(int r = s1.length(); r < s2.length(); r++){
            s2Count[s2.charAt(r) - 'a']++;
            s2Count[s2.charAt(l) - 'a']--;
            l++;
            if(Arrays.equals(s1Count, s2Count)){
                return true;
            }
        }

        return false;
        
    }
}
