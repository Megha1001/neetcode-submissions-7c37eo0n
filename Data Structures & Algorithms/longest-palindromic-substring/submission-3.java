class Solution {

    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        //Naive solution- Find all substring

        String res = "";

        for(int i=0; i<s.length(); i++){
            int currMax = 1;
            String currRes = s.substring(i,i+1);
            for(int j=i+1; j<s.length(); j++){
                if(isPalindrome(s.substring(i, j+1)) && currMax < (j-i+1)){
                    currMax = j-i+1;
                    currRes = s.substring(i, j+1);
                }
            }
            if(res.length() < currMax){
                res = currRes;
            }
        }

        return res;
    }

    public static boolean isPalindrome(String s){
        int l = 0;
        int h = s.length()-1;

        while(l<h){
            if(s.charAt(l)!= s.charAt(h)){
                return false;
            }else{
                ++l;
                --h;
            }
        }

        return true;
    }
}
