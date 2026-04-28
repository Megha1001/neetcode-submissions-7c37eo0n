// TC : O(1), SC : O(N)
class MinStack {

    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val, val});
            return;
        }
        int minValue = Math.min(val, st.peek()[1]);
        st.push(new int[]{val, minValue});
        return;
    }
    
    public void pop() {
        st.pop();
        
    }
    
    public int top() {
        return st.peek()[0]; 
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
