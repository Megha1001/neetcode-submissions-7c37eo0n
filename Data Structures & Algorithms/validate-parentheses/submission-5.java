class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            switch(ch){
                case '[':
                case '{':
                case '(':
                    st.push(ch);
                    break;
                
                case ')':
                case ']':
                case '}':
                    if(!st.isEmpty() && (
                        (st.peek() == '[' && ch == ']') || 
                        (st.peek() == '(' && ch == ')') ||
                        (st.peek() == '{' && ch == '}')

                        )
                    ){
                        st.pop();
                    }else {
                        return false;
                    }
            }
        }

        return st.isEmpty();
        
    }
}
