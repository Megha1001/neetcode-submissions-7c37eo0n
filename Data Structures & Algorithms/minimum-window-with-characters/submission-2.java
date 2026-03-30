class Solution {
    public String minWindow(String s, String t) {
        //https://www.youtube.com/watch?v=3Bp3OVD1EGc
        //Sliding window

        int n = s.length();
        int requiredCount = t.length();

        if(requiredCount > n){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int start_i = 0;
        int minWindow = Integer.MAX_VALUE;

        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch) > 0){
                --requiredCount;
            }

            map.put(ch, map.getOrDefault(ch, 0)-1);

            while(requiredCount == 0){
                int currWindow = j-i+1;

                if(minWindow > currWindow){
                    minWindow = currWindow;
                    start_i = i;
                }

                char start_char = s.charAt(i);
                map.put(start_char, map.getOrDefault(start_char, 0) + 1);
                if(map.containsKey(start_char) && map.get(start_char) > 0){
                    ++requiredCount;
                }

                ++i;

            }
            ++j;
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindow);
        
    }
}
