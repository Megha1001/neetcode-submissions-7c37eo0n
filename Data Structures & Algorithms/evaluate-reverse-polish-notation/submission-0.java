class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") | s.equals("*") || s.equals("/")){
                int a = st.pop();
                int b = st.pop();
                int res = 0;
                switch(s){
                    case "+" : res = b + a; break;
                    case "-" : res = b - a; break;
                    case "*" : res = b * a; break;
                    case "/" : res = b / a; break;
                }
                st.push(res);
            }else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}
