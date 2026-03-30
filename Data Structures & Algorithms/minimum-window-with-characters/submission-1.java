class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        
        //sliding window
        Map<Character, Integer> countT = new HashMap<>();
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int l = 0;
        int resLength = Integer.MAX_VALUE;
        int have = 0;
        int need = countT.size();
        int res[] = {-1,-1};

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                ++have;
            }

            while(have == need){
                if((r-l+1) < resLength){
                    resLength = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1); //no need to do getOrDefault as we have added leftChar
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    --have;
                }
                ++l;
            }
        }

        return resLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
