class Solution {
    public String minRemoveToMakeValid(String s) {
        //Use Stack

        HashSet<Integer> toRemove = new HashSet<>();
        Deque<Integer> st = new ArrayDeque<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else if(c == ')'){
                if(st.isEmpty()){
                    toRemove.add(i);
                }else{
                    st.pop();
                }
            }
        }

        while(!st.isEmpty()){
            toRemove.add(st.pop());
        }

        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            if(!toRemove.contains(i)){
                result.append(s.charAt(i));
            }
        }

        return result.toString();
        
    }
}