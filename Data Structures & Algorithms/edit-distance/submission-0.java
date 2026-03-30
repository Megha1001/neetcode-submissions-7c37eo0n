class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        return editDistance(word1, word2, m , n);
        
    }

    public int editDistance(String s1, String s2, int m , int n){

        if(m == 0){
            return n; //n insertions
        }

        if(n == 0){
            return m; //m deletions
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return editDistance(s1, s2, m-1, n-1);
        }

        else {
            return 1 + Math.min(Math.min(editDistance(s1, s2, m, n-1), //insert
                            editDistance(s1, s2, m-1, n)),//delete
                            editDistance(s1, s2, m-1, n-1)) ; //replace
                            //1 is for the operations
        }


    }
}
