class Solution {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backTrack(n, 0, 0, "");
        return res;
    }

    private void backTrack(int n , int open, int close, String curr){
        if(curr.length() == n*2){
            res.add(curr);
            return;
        }

        if(open < n){
            backTrack(n, open+1, close, curr+"(");
        }

        if(close < open){
            backTrack(n, open, close+1, curr+")");
        }
    }


    //TLE
    List<String> perms;//allPermutations
    public List<String> generateParenthesisBruteForce(int n) {
        HashSet<String> res = new HashSet<>();

        String pair = "()"; //1 <= n <= 7

        String inputStr = "";
        for(int i = 0 ; i < n; i++){
            inputStr += pair;
        }

        perms = new ArrayList<>();
        boolean pick[] = new boolean[inputStr.length()];
        generateAllPermutations(inputStr, "", pick);

        for(String str : perms){
            if(isValidParenthesis(str)){
                res.add(str);
            }
        }
        return new ArrayList<>(res);
 
    }

    private void generateAllPermutations(String str, String curr, boolean[] pick){
        if(str.length() == curr.length()){
            perms.add(curr);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            if(!pick[i]){
                curr += str.charAt(i);
                pick[i] = true;
                generateAllPermutations(str, curr, pick);
                pick[i] = false;
                curr = curr.substring(0, curr.length()-1);
            }
        }

    }

    private boolean isValidParenthesis(String str){
        char[] c = str.toCharArray();
        Deque<Character> stack = new ArrayDeque();
        
        for(char ch : c){
            switch(ch){
                case '(':
                    stack.push(ch); break;
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}
