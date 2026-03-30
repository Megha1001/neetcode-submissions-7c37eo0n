class Solution {
    public int numDistinct(String s, String t) {

        //Brute force
        //Generate all subsequences of s
        List<String> allSubs = new ArrayList<>();

        backTrack(0, s, new StringBuilder(), allSubs);

        int res = 0;

        for(String str : allSubs){
            if(str.equals(t)){
                ++res;
            }
        }

        return res;
        
    }

    private void backTrack(int i , String s, StringBuilder curr, List<String> allSubs){
        if(i == s.length()){
            allSubs.add(curr.toString());
            return;
        }

        //include character
        curr.append(s.charAt(i));
        backTrack(i+1, s, curr, allSubs);

        //not include character
        curr.deleteCharAt(curr.length() - 1);
        backTrack(i+1, s, curr, allSubs);
    }
}
