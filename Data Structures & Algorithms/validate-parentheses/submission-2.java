class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            switch(c){
                case '{' :
                case '[' :
                case '(' :
                    stack.push(c);
                    break;

                case '}' :
                case ']' :
                case ')' :
                    if(!stack.isEmpty() && (
                        (stack.peek()=='{' && c=='}')
                        ||
                        (stack.peek()=='[' && c==']')
                        ||
                        (stack.peek()=='(' && c==')')
                    )){
                        stack.pop();
                        break;
                    }else{
                        return false;
                    }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        return true;
        
    }
}
