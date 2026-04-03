class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int rc = t.length();

        if(rc > n){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int start_i = 0;
        int min_window = Integer.MAX_VALUE;

        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch) > 0){
                --rc;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while(rc == 0){
                int curr_window = j - i + 1;

                if(min_window > curr_window){
                    min_window = curr_window;
                    start_i = i;
                }

                //shrink
                char start_char = s.charAt(i);
                map.put(start_char, map.getOrDefault(start_char, 0) + 1);

                if(map.get(start_char) > 0){
                    ++rc;
                }
                ++i;
            }
            ++j;
        }

        return min_window == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i+min_window);
    }
}
