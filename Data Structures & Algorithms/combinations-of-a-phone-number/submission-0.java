class Solution {
    private List<String>res;
    private String stringToChar[] = {"","","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        backTrack(0, "", digits);
        return res;
    }

    private void backTrack(int i , String curr, String digits){
        if(curr.length() == digits.length()){
            res.add(curr);
            return; 
        }

        String chars = stringToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){
            backTrack(i+1, curr + c, digits);
        }
    }
}
