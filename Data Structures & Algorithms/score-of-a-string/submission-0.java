class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for(int i = 1; i < s.length(); i++){
            int u = s.charAt(i-1) - 'a';
            int v = s.charAt(i) - 'a';
            sum += Math.abs(v - u);
        }

        return sum;
    }
}