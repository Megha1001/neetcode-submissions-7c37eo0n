//TC : O(N), SC : O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Two pointer
        int n = s.length();

        if(n==0){
            return 0;
        }

        int i = -1;
        int j = 0;
        int res = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        while(j < n){ //grow
            while(i <= j && set.contains(s.charAt(j))){//shrink
                ++i;
                set.remove(s.charAt(i));
            }
            set.add(s.charAt(j));
            ++j;
            res = Math.max(res, set.size());
        }


        return res;
        
    }
}
