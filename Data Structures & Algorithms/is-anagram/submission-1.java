class Solution {
    public int CHAR = 26; //english letters
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int arr[] = new int[CHAR];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++; // -'a' as input contains lower case english letters
            arr[t.charAt(i)-'a']--; // -'a' as input contains lower case english letters
        }

        for(int i=0; i<CHAR; i++){
           if(arr[i]!=0){
                return false;
           }
        }

        return true;

    }
}
