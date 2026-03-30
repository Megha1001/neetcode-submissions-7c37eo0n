class Solution {
    public int lengthOfLongestSubstring(String s) {

        //Brute force
        // if(s.length()==0){
        //     return 0;
        // }

        // HashSet<Character> set = new HashSet<>();

        // int len=0;

        // for(int i=0; i<s.length(); i++){
        //     int currMax = 1;
        //     set = new HashSet<>();
        //     set.add(s.charAt(i));
        //     for(int j=i+1; j<s.length(); j++){
        //         if(set.contains(s.charAt(j))){
        //             break;
        //         }else{
        //             set.add(s.charAt(j));
        //             ++currMax;
        //         }
        //     }

        //     len = Math.max(currMax, len);
        // }

        // return len;


        //Efficient -> Two Pointer approach

        if(s.length()==0){
            return 0;
        }
        
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                ++l;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r-l+1);
        }

        return res;
        
    }
}
